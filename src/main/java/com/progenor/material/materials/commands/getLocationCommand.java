package com.progenor.material.materials.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class getLocationCommand {

    public getLocationCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("position")
                .then(Commands.literal("get").executes((command -> {
                    return getLocation(command.getSource());
                }))));

    }

    private int getLocation(CommandSource source) throws CommandSyntaxException{
        ServerPlayerEntity player = source.asPlayer();
        BlockPos playerPos = player.getPosition();
        String pos = playerPos.getCoordinatesAsString();

        source.sendFeedback(new StringTextComponent("Your current location is: " + pos), true);
        return 1;
    }

}
