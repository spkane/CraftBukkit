package org.bukkit.craftbukkit.util;

import net.minecraft.server.ExceptionWorldConflict;
import net.minecraft.server.MinecraftServer;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;

public class ServerShutdownThread extends Thread {
    private final MinecraftServer server;

    public ServerShutdownThread(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            server.stop();
        } catch (ExceptionWorldConflict ex) {
            NewRelic.noticeError(ex);
            ex.printStackTrace();
        } finally {
            try {
                server.reader.getTerminal().restore();
            } catch (Exception e) {
            }
        }
    }
}
