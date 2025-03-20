package dev.snas.soex;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean keepGoing = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                    
                    Choose one of the following options:
                    1: getUsers()
                    2: addUser()
                    """);

            switch (scanner.nextLine()) {
                case "1" -> request(URI.create("https://triptop-identity.wiremockapi.cloud/login"), "{\"username\":\"your_username\",\"password\":\"your_password\"}");
                case "2" -> request(URI.create("https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=TOKEN_UIT_HET_VORIGE_REQUEST"), "{\"username\":\"your_username\",\"password\":\"your_password\"}");
                case "exit" -> keepGoing = false;
            }
        } while (keepGoing);
    }

    private static void request(URI uri, String body) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }
}