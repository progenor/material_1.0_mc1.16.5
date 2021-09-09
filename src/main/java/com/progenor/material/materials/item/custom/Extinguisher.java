package com.progenor.material.materials.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class Extinguisher extends Item {
    public Extinguisher(Properties properties){


        super(properties);
    }


    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();


        if(!world.isRemote){
            PlayerEntity playerEntity = Objects.requireNonNull( context.getPlayer());


            rightClickInAir(playerEntity);

            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
        }
        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.materials.extinguisher_shift"));
        }else {
            tooltip.add(new TranslationTextComponent("tooltip.materials.extinguisher"));
        }


        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    private void rightClickInAir(PlayerEntity playerEntity) {

        boolean playerIsOnFire = playerEntity.isBurning();

        if(playerIsOnFire){
            //extinguish the player and gain fire resistance for safe keeping
            extinguishPlayerAndFireRes(playerEntity);
        }


    }

    private void extinguishPlayerAndFireRes(PlayerEntity playerEntity){
        extinguishPlayer(playerEntity);
    }

    public static void extinguishPlayer(PlayerEntity playerEntity){
        playerEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10));
        playerEntity.extinguish();
    }



}


