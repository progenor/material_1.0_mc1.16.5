package com.progenor.material.materials.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.progenor.material.materials.Materials;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("home")
                .then(Commands.literal("set").executes((command) -> {
            return setHome(command.getSource());
        })));
    }

    private int setHome(CommandSource source) throws CommandSyntaxException{
        ServerPlayerEntity player = source.asPlayer();
        BlockPos playerPos = player.getPosition();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";

        player.getPersistentData().putIntArray(Materials.MOD_ID + "homepos",
                new int[]{ playerPos.getX(), playerPos.getY(), playerPos.getZ()});

        source.sendFeedback(new StringTextComponent("Set Home at " + pos), true);
        return 1;
    }
}
