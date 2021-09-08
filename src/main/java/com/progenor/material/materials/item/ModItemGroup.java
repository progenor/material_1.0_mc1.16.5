package com.progenor.material.materials.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MATERIAL_GROUP = new ItemGroup("materialModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.THUNGSTEN_INGOT.get());
        }
    };


}
