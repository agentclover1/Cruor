package dev.agentclover.game;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class GameManager {
    private GameState state = GameState.LOBBY;

    public GameState getState() {return state;}

    public void startGame(ServerPlayerEntity starter) {
        MinecraftServer server = starter.getServer();

        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.teleport(
                    player.getServerWorld(),
                    0,
                    -31,
                    0,
                    player.getYaw(),
                    player.getPitch()
            );
        }

        state = GameState.PLAYING;
    }
    public void stopGame(ServerPlayerEntity stopper) {
        MinecraftServer server = stopper.getServer();

        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.teleport(
                    player.getServerWorld(),
                    100,
                    -31,
                    100,
                    player.getYaw(),
                    player.getPitch()
            );
        }

        state = GameState.LOBBY;
    }
}
