package com.progenor.material.materials.events;


import com.progenor.material.materials.Materials;
import com.progenor.material.materials.commands.ReturnHomeCommand;
import com.progenor.material.materials.commands.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Materials.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event){
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        if(!event.getOriginal().getEntityWorld().isRemote()){
            event.getPlayer().getPersistentData().putIntArray(Materials.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(Materials.MOD_ID + "homepos"));
        }
    }

}
