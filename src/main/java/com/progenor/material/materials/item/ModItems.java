package com.progenor.material.materials.item;

import com.progenor.material.materials.Materials;
import com.progenor.material.materials.item.custom.Extinguisher;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
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


    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () ->
            new SwordItem(ModItemTier.TUNGSTEN, 4, -2.3f,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () ->
            new PickaxeItem(ModItemTier.TUNGSTEN, 2, -3f,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel", () ->
            new ShovelItem(ModItemTier.TUNGSTEN, 2f, -4.0f,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () ->
            new AxeItem(ModItemTier.TUNGSTEN, 6f, -4f,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () ->
            new HoeItem(ModItemTier.TUNGSTEN, 4, 0f,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_BOOTS = ITEMS.register("tungsten_boots", () ->
            new ArmorItem(ModArmorMaterial.TUNGSTEN, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_LEGGINGS = ITEMS.register("tungsten_leggings", () ->
            new ArmorItem(ModArmorMaterial.TUNGSTEN, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_CHESTPLATE = ITEMS.register("tungsten_chestplate", () ->
            new ArmorItem(ModArmorMaterial.TUNGSTEN, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));

    public static final RegistryObject<Item> TUNGSTEN_HELMET = ITEMS.register("tungsten_helmet", () ->
            new ArmorItem(ModArmorMaterial.TUNGSTEN, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.MATERIAL_GROUP)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
