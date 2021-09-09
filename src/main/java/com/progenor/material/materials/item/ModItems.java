package com.progenor.material.materials.item;

import com.progenor.material.materials.Materials;
import com.progenor.material.materials.item.custom.Extinguisher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Materials.MOD_ID);

    public static final RegistryObject<Item> THUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () ->
            new Item(new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> EXTINGUISHER = ITEMS.register("extinguisher", () ->
            new Extinguisher(new Item.Properties().group(ModItemGroup.MATERIAL_GROUP).maxDamage(2)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
