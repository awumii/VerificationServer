package me.awumii;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class VerificationHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equals("GET")) {
            return;
        }

        // Read the request URL.
        var request = exchange.getRequestURI().toString();
        VerificationServer.LOGGER.info(request);

        // Parse code from the request.
        var code = request.split("\\?code=")[1].split("&")[0];

        // Send the response.
        var response = code + "true";
        exchange.sendResponseHeaders(200, response.getBytes().length);

        var out = exchange.getResponseBody();
        out.write(response.getBytes());
        out.close();
    }
}
