package me.awumii.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import me.awumii.NetUtils;
import me.awumii.VerificationServer;

import java.io.IOException;

public class IslandHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Yes, that's it. That's the entire DRM....
        NetUtils.respond(exchange, "1,.1,.1,.1");

        VerificationServer.LOGGER.info("Authenticated game session: " + exchange.getRequestURI().toString());
    }
}
