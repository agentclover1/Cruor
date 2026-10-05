package dev.agentclover.commands;

import com.mojang.brigadier.CommandDispatcher;
import dev.agentclover.Cruor;
import dev.agentclover.game.GameState;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.Objects;

public class CruorCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        // Cruor Start Command
        dispatcher.register(
                CommandManager.literal("cruor:start")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            System.out.println("Cruor start command!");
                            Cruor.GAME_MANAGER.startGame(Objects.requireNonNull(context.getSource().getPlayer()));
                            return 1;
                        })
        );

        // Cruor Stop Command
        dispatcher.register(
                CommandManager.literal("cruor:stop")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            System.out.println("Cruor stop command!");
                            Cruor.GAME_MANAGER.stopGame(Objects.requireNonNull(context.getSource().getPlayer()));
                            return 1;
                        })
        );

        // Cruor State Command -- For Debugging
        dispatcher.register(
                CommandManager.literal("cruor:state")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            GameState state = Cruor.GAME_MANAGER.getState();

                            context.getSource().sendMessage(
                                    Text.literal("Game State: " + state)
                            );
                            return 1;
                        })
        );

        // Cruor Jessi Command -- For Fun
        dispatcher.register(
                CommandManager.literal("cruor:jessi")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            context.getSource().sendMessage(
                                    Text.literal("Jessi is like really cool but I still mog her")
                            );
                            return 1;
                        })
        );
    }
}
