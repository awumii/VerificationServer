package me.awumii;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public final class NetUtils {
    public static void respond(HttpExchange exchange, String response) throws IOException {
        // HTTP status 200 OK
        exchange.sendResponseHeaders(200, response.getBytes().length);

        // Write the response now
        var out = exchange.getResponseBody();
        out.write(response.getBytes());
        out.close();
    }
}
