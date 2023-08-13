package com.chromanyan.bundleenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BundleCapacityEnchantment extends Enchantment {

    public BundleCapacityEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.VANISHABLE, EquipmentSlot.values());
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem().equals(Items.BUNDLE);
    }

    public int getMinCost(int p_45121_) {
        return 10 * p_45121_;
    }

    public int getMaxCost(int p_45123_) {
        return this.getMinCost(p_45123_) + 30;
    }

    public int getMaxLevel() {
        return 4;
    }
}
