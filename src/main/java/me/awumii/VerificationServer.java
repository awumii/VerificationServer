package me.awumii;

import com.sun.net.httpserver.HttpServer;
import me.awumii.handler.IslandHandler;
import me.awumii.handler.PModHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class VerificationServer {
    public static final Logger LOGGER = Logger.getLogger("VerificationServer");

    public static void main(String[] args) {
        try {
            var server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

            // Handler for a certain mod.
            server.createContext("/verify", new PModHandler());

            // Handler for a very old island themed game with dead DRM servers.
            server.createContext("/ws", new IslandHandler());

            server.setExecutor(Executors.newCachedThreadPool());
            server.start();

            LOGGER.info("Server started on port 8080");
        } catch (IOException exception) {
            LOGGER.severe("Could not start the verification server. Check if there is anything running on port 8080.");
        }
    }
}