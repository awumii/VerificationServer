package me.awumii;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class VerifyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Read the request URL. It contains code generated by the client.
        var request = exchange.getRequestURI().toString();
        VerificationServer.LOGGER.info(request);

        // Parse code from the request.
        var code = request.split("\\?code=")[1].split("&")[0];

        // Append "verified" to the code and send it back to the client.
        var response = code + "verified";

        // HTTP status 200 OK
        exchange.sendResponseHeaders(200, response.getBytes().length);

        // Write the response now
        var out = exchange.getResponseBody();
        out.write(response.getBytes());
        out.close();
    }
}