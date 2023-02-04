package me.awumii;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class VerificationServer {
    public static final Logger LOGGER = Logger.getLogger("VerificationServer");

    public static void main(String[] args) throws IOException {
        try {
            var server = HttpServer.create(new InetSocketAddress("localhost", 80), 0);
            server.createContext("/verify", new VerifyHandler());
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();

            LOGGER.info("Server started on port 80");
        } catch (IOException exception) {
            LOGGER.severe("Could not start the verification server. Check if there is anything running on port 80, and run the program as root.");
            exception.printStackTrace();
            System.exit(0);

            // Attempt to fix bind permissions
            Runtime.getRuntime().exec("pkexec setcap CAP_NET_BIND_SERVICE=+eip /usr/bin/java");
        }
    }
}