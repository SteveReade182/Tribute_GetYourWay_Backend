package com.sky.getyourway.service;


import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sky.getyourway.data.entity.Flight;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;


@Service
public class flightServiceApi implements FlightService {

    public String getFlightAsString(Flight f) throws Exception {
        Amadeus amadeus = Amadeus.builder("G8bcAGUEG6ohGQvoFTN04GeY16Koc4k5", "DrEiZ3uWNQAWxsF6").build();

        FlightOfferSearch[] flightOffers = amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", f.getDeparture())
                        .and("destinationLocationCode", f.getDestination())
                        .and("departureDate", f.getDate())
                        .and("adults", f.getAdults())
                        .and("max", 1)
        );

        JsonObject body = flightOffers[0].getResponse().getResult();

        JsonArray dataArray = body.getAsJsonArray("data");

        String durationOutput = (dataArray.get(0).getAsJsonObject().getAsJsonArray("itineraries")
                .get(0).getAsJsonObject().get("duration").getAsString());
        String priceOutput = (dataArray.get(0).getAsJsonObject().getAsJsonObject("price").get("total").getAsString());
        JSONObject dataReturn = new JSONObject();
        dataReturn.put("duration", durationOutput);
        dataReturn.put("price", priceOutput);

        if (flightOffers[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code: " + flightOffers[0].getResponse().getStatusCode());
            System.exit(-1);
        }

        return dataReturn.toString();
    }

}
