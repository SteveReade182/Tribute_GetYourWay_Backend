package com.qa.cardatabase.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cardatabase.CardatabaseApplication;
import com.qa.cardatabase.data.entity.Flight;
import com.qa.cardatabase.data.entity.FlightApiResponse;
import com.qa.cardatabase.data.entity.Weather;
import net.minidev.json.JSONArray;

import net.minidev.json.writer.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



@Component
public class FlightApiService {

    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
    private static final String API_URL = "https://airlabs.co/api/v9/schedules";

//    public List<Flight> getOutboundFlights() {
//        RestTemplate restTemplate = new RestTemplate();
//        String API_Key = "api key = 135f1a6f-5adb-43af-bee8-2304b4fddcd6"; //API KEY
////        String departureDate = "2023-02-25"; // example date
//        String query = "dep_iata=LHR&arr_iata=KEF&";// + departureDate;
//        String apiUrl = API_URL + "?" +query+API_Key;
//        ResponseEntity<Flight[]> response = restTemplate.getForEntity(apiUrl, Flight[].class);
//        return Arrays.asList(response.getBody());
//    }

    public String getSchedules(){
        RestTemplate restTemplate = new RestTemplate();
        String API_Key = "api_key=135f1a6f-5adb-43af-bee8-2304b4fddcd6"; // API KEY
        String departureIATA = "LHR";
        String destinationIATA = "KEF";

        String url = API_URL + "?" + "dep_iata=" + departureIATA + "&arr_iata=" + destinationIATA + "&" + API_Key;

        String json = restTemplate.getForObject(url, String.class);


        return json;
    }

    public Flight getSchedules3() {
        try {
            URL url = new URL("https://airlabs.co/api/v9/schedules?dep_iata=LHR&arr_iata=KEF&api_key=135f1a6f-5adb-43af-bee8-2304b4fddcd6");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error: " + responseCode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                StringBuilder sb = new StringBuilder();
                while (sc.hasNext()) {
                    sb.append(sc.nextLine());
                }
                sc.close();
                String jsonString = sb.toString();
                JSONObject json = new JSONObject(jsonString);
                String flightDuration = json.getAsJsonObject();
                return new Flight(flightDuration);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String getSchedules2(){
//        RestTemplate restTemplate = new RestTemplate();
//        String API_Key = "api_key=135f1a6f-5adb-43af-bee8-2304b4fddcd6"; // API KEY
//        String departureIATA = "LHR";
//        String destinationIATA = "KEF";
//
//        String url = API_URL + "?" + "dep_iata=" + departureIATA + "&arr_iata=" + destinationIATA + "&" + API_Key;
//
//        String json = restTemplate.getForObject(url, String.class);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        FlightApiResponse output = null;
//        try {
//            output = objectMapper.readValue(json, FlightApiResponse.class);
//        }
//        catch(JsonProcessingException e){
//
//        }
    public String getSchedules2(){
//        RestTemplate restTemplate = new RestTemplate();
        String API_Key = "api_key=135f1a6f-5adb-43af-bee8-2304b4fddcd6"; // API KEY
        String departureIATA = "LHR";
        String destinationIATA = "KEF";

        try {
            int counter = 0;

            URL url = new URL (API_URL + "?" + "dep_iata=" + departureIATA + "&arr_iata=" + destinationIATA + "&" + API_Key);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200){
                System.out.println("Error: " + responseCode);
            } else {


                Scanner scanner = new Scanner(url.openStream());
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner.hasNext()){
                    counter++;
                    stringBuilder.append(scanner.nextLine());
                }
                logger.info("===============================================================================");
                logger.info(Integer.toString(counter));
                scanner.close();
                String jsonString = stringBuilder.toString();
                logger.info("#################################################################################");
                logger.info(jsonString);
                JSONObject json = new JSONObject(jsonString);
                logger.info("#################################################################################");
                logger.info(json.toString());
//                int duration = json.getJSONObject("response").getInt("duration");
                int duration = json.getJSONObject("response").get(0).getAsJsonObject().get("duration").getInt();
                logger.info("===============================================================================");
                logger.info(String.valueOf(duration));

//                JSONObject duration = json.getJSONObject("response");
                return Integer.toString(counter);
//                return Integer.toString(duration);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}


//https://app.goflightlabs.com/search-all-flights
// access_key=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI0IiwianRpIjoiOWE5YjFhODk0NDczMmZlODg0MzA4OGIxMTBmOTE1ZGFlZTlkMjUwNzIyMjE3NjkwMTZjNThlNjAyYzI4MTc0ZjMxODQ2YzFmNjI4ZTMwNzUiLCJpYXQiOjE2NzY1ODQwOTQsIm5iZiI6MTY3NjU4NDA5NCwiZXhwIjoxNzA4MTIwMDk0LCJzdWIiOiIyMDA1MCIsInNjb3BlcyI6W119.mlQ3VFAMWes2TFiPGzgCl_tQe3khTpgCO49oh9eigNVmzVd3Cw0S4oS9l8WaOMyDYhYXo3DhHnla_qybx23DDw
// &adults=1
// &origin=LHR
// &destination=KEF
// &departureDate=2023-02-24


//api key = 135f1a6f-5adb-43af-bee8-2304b4fddcd6

//https://airlabs.co/api/v9/schedules?dep_iata=LHR&arr_iata=KEF&api_key=135f1a6f-5adb-43af-bee8-2304b4fddcd6


//original below

//    private static final String API_URL = "https://airlabs.co/api/v9/schedules";
//
//    public List<Flight> getOutboundFlights() {
//        RestTemplate restTemplate = new RestTemplate();
//        String API_Key = "api key = 135f1a6f-5adb-43af-bee8-2304b4fddcd6"; //API KEY
////        String departureDate = "2023-02-25"; // example date
//        String query = "dep_iata=LHR&arr_iata=KEF&";// + departureDate;
//        String apiUrl = API_URL + "?" +query+API_Key;
//        ResponseEntity<Flight[]> response = restTemplate.getForEntity(apiUrl, Flight[].class);
//        return Arrays.asList(response.getBody());
//    }