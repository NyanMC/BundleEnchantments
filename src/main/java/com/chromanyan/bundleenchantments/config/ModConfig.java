package com.chromanyan.bundleenchantments.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {

    public static class Common {
        public final IntValue bundleCapacityMaxLevel;
        public final IntValue bundleCapacityItemsPerLevel;
        public final BooleanValue allowIllegalStacks;

        public Common(ForgeConfigSpec.Builder builder) {
            bundleCapacityMaxLevel = builder
                    .comment("The amount of levels the enchantment has. If a mod such as Apotheosis is installed, this is overridden and you should consult that mod's config instead.")
                    .defineInRange("bundleCapacityMaxLevel", 4, 1, Integer.MAX_VALUE);
            bundleCapacityItemsPerLevel = builder
                    .comment("The amount of additional items a bundle can carry per level of the enchantment.")
                    .defineInRange("bundleCapacityItemsPerLevel", 16, 1, Integer.MAX_VALUE);
            allowIllegalStacks = builder
                    .comment("Whether additional code which prevents an illegal stack from being made should be disabled. This code prevents many bugs such as potential loss of items, however may cause compatibility issues. Only set this to true if you know what you're doing.")
                    .define("allowIllegalStacks", false);
        }
    }

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

}
