package com.chromanyan.bundleenchantments.init;

import com.chromanyan.bundleenchantments.BundleEnchantments;
import com.chromanyan.bundleenchantments.enchantments.BundleCapacityEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BundleEnchantments.MODID);

    public static final RegistryObject<Enchantment> BUNDLE_CAPACITY = ENCHANTMENTS_REGISTRY.register("bundle_capacity", BundleCapacityEnchantment::new);
}
