package com.qa.cardatabase.service;

import com.qa.cardatabase.data.entity.Flight;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class FlightApiService {
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

        //logic to then set the Flight class variables
        return json;
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