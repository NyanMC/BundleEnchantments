package com.chromanyan.bundleenchantments.mixin;

import com.chromanyan.bundleenchantments.init.ModEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;
import java.util.Optional;

@Mixin(BundleItem.class)
public class MixinBundleItem {

    private static int getMaxWeight(ItemStack stack) {
        return BundleItem.MAX_WEIGHT + (stack.getEnchantmentLevel(ModEnchantments.BUNDLE_CAPACITY.get()) * 16);
    }

    @ModifyConstant(method = "getFullnessDisplay", constant = @Constant(floatValue = 64.0F))
    private static float modifyGetFullnessDisplay(float constant, ItemStack p_150767_) {
        return (float) getMaxWeight(p_150767_);
    }

    @ModifyConstant(method = "overrideStackedOnOther", constant = @Constant(intValue = 64))
    private static int modifyOverrideStackedOnOther(int constant, ItemStack p_150733_, Slot p_150734_, ClickAction p_150735_, Player p_150736_) {
        return getMaxWeight(p_150733_);
    }

    @ModifyConstant(method = "getBarWidth", constant = @Constant(intValue = 64))
    private static int modifyGetBarWidth(int constant, ItemStack p_150771_) {
        return getMaxWeight(p_150771_);
    }

    @ModifyConstant(method = "add", constant = @Constant(intValue = 64))
    private static int modifyAdd(int constant, ItemStack p_150764_, ItemStack p_150765_) {
        return getMaxWeight(p_150764_);
    }

    @ModifyConstant(method = "appendHoverText", constant = @Constant(intValue = 64))
    private int modifyAppendHoverText(int constant, ItemStack p_150749_, Level p_150750_, List<Component> p_150751_, TooltipFlag p_150752_) {
        return getMaxWeight(p_150749_);
    }

    // i am so sorry
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType") // i don't have a choice
    @ModifyVariable(method = "add", at = @At("STORE"))
    private static Optional<CompoundTag> modifyOptional(Optional<CompoundTag> value, ItemStack p_150764_, ItemStack p_150765_) {
        if (p_150764_.getEnchantmentLevel(ModEnchantments.BUNDLE_CAPACITY.get()) > 0 && value.isPresent()) { // only step in to stop problems you caused
            CompoundTag compoundtag1 = value.get();
            ItemStack itemstack = ItemStack.of(compoundtag1);
            if (itemstack.getCount() + p_150765_.getCount() > itemstack.getMaxStackSize())
                return Optional.empty();
            else
                return value;
        } else
            return value;
    }
}