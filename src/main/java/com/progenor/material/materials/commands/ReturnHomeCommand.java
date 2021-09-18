package com.progenor.material.materials.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.progenor.material.materials.Materials;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class ReturnHomeCommand {

    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes((command) -> {
            return returnHome(command.getSource());
        })));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException{
        ServerPlayerEntity player = source.asPlayer();

        boolean hasHomePos = player.getPersistentData().getIntArray(Materials.MOD_ID + "homepos").length != 0;

        if(hasHomePos){
            int[] playerPos = player.getPersistentData().getIntArray(Materials.MOD_ID + "homepos");
            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

            source.sendFeedback(new StringTextComponent("Welcome home!"), true);

            return 1;
        }else {
            source.sendFeedback(new StringTextComponent("There is NO home position!!!"), true);
            return -1;
        }

    }

}
