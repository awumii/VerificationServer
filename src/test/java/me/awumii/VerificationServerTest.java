package me.awumii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Random;

public class VerificationServerTest {

    @Test
    void testVerificationServer() throws URISyntaxException, IOException {
        // Start the server
        VerificationServer.main(null);

        // Creating the client
        var client = HttpClient.newHttpClient();

        // Generate random code, server has to send it back.
        var code = new Random().nextInt(Integer.MAX_VALUE);

        // Creating the request
        var request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost/verify?code=" + code + "&name=Herobrine"))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        // Send the request, then check if the response contains the original code and true at the end.
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> Assertions.assertEquals(response.body(), code + "verified", "Unexpected response: " + response.body()))
                .join();
    }
}
