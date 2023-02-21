package com.qa.cardatabase.service;

import com.qa.cardatabase.data.entity.Flight.Flight;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class FlightApiService {
    private static final String API_URL = "https://app.goflightlabs.com/search-best-flights";

    public List<Flight> getOutboundFlights() {
        RestTemplate restTemplate = new RestTemplate();
        String API_Key = "access_key=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI0IiwianRpIjoiOWE5YjFhODk0NDczMmZlODg0MzA4OGIxMTBmOTE1ZGFlZTlkMjUwNzIyMjE3NjkwMTZjNThlNjAyYzI4MTc0ZjMxODQ2YzFmNjI4ZTMwNzUiLCJpYXQiOjE2NzY1ODQwOTQsIm5iZiI6MTY3NjU4NDA5NCwiZXhwIjoxNzA4MTIwMDk0LCJzdWIiOiIyMDA1MCIsInNjb3BlcyI6W119.mlQ3VFAMWes2TFiPGzgCl_tQe3khTpgCO49oh9eigNVmzVd3Cw0S4oS9l8WaOMyDYhYXo3DhHnla_qybx23DDw"; //API KEY
        String departureDate = "2023-02-25"; // example date
        String query = "&adults=1&origin=LHR&destination=KEF&departureDate=" + departureDate;
        String apiUrl = API_URL + "?" +API_Key + query;
        ResponseEntity<Flight[]> response = restTemplate.getForEntity(apiUrl, Flight[].class);
        return Arrays.asList(response.getBody());
    }
}


//https://app.goflightlabs.com/search-all-flights
// access_key=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI0IiwianRpIjoiOWE5YjFhODk0NDczMmZlODg0MzA4OGIxMTBmOTE1ZGFlZTlkMjUwNzIyMjE3NjkwMTZjNThlNjAyYzI4MTc0ZjMxODQ2YzFmNjI4ZTMwNzUiLCJpYXQiOjE2NzY1ODQwOTQsIm5iZiI6MTY3NjU4NDA5NCwiZXhwIjoxNzA4MTIwMDk0LCJzdWIiOiIyMDA1MCIsInNjb3BlcyI6W119.mlQ3VFAMWes2TFiPGzgCl_tQe3khTpgCO49oh9eigNVmzVd3Cw0S4oS9l8WaOMyDYhYXo3DhHnla_qybx23DDw
// &adults=1
// &origin=LHR
// &destination=KEF
// &departureDate=2023-02-24

//https://app.goflightlabs.com/search-best-flights?
// access_key=YOUR_ACCESS_KEY
// &adults=1
// &origin=MAD
// &destination=FCO
// &departureDate=2023-03-03