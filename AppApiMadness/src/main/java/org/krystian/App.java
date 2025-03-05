package org.krystian;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    static String BASE_URL = "http://numbersapi.com/";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = httpClient.send(getHttpRequest(), HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void welcomeMessage(){
        System.out.println("Hello World!");
    }

    private static String askForInput(Scanner scn){
        System.out.println("Provide a number to get a fun fact about.");
        return scn.nextLine();
    }

    private static HttpRequest getHttpRequest() {
        try{
            String numberToAskFor = askForInput(scanner);
            HttpRequest getRequest = HttpRequest.newBuilder(new URI(BASE_URL + numberToAskFor)).build();
            return getRequest;
        } catch (URISyntaxException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
