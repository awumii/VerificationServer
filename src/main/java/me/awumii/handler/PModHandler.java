package me.awumii.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import me.awumii.NetUtils;
import me.awumii.VerificationServer;

import java.io.IOException;

public class PModHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Read the request URL. It contains code generated by the client.
        var request = exchange.getRequestURI().toString();
        VerificationServer.LOGGER.info(request);

        // Parse code from the request.
        var code = request.split("\\?code=")[1].split("&")[0];

        // Append "verified" to the code and send it back to the client.
        NetUtils.respond(exchange, code + "verified");
    }
}
