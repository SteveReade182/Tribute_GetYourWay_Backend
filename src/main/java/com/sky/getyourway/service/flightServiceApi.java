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
//        String priceOutput = (dataArray.get(0).getAsJsonObject().getAsJsonObject("price").get("total").getAsString());
//        JSONObject dataReturn = new JSONObject();
//        dataReturn.put("duration", durationOutput);
//        dataReturn.put("price", priceOutput);

        if (flightOffers[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code: " + flightOffers[0].getResponse().getStatusCode());
            System.exit(-1);
        }

        String inputString = durationOutput;

// Extract hour and minute values from input string
        int hours = 0;
        int minutes = 0;

        int hourIndex = inputString.indexOf("H");
        int minuteIndex = inputString.indexOf("M");

        if (hourIndex > 0) {
            hours = Integer.parseInt(inputString.substring(2, hourIndex));
        }

        if (minuteIndex > 0) {
            minutes = Integer.parseInt(inputString.substring(hourIndex + 1, minuteIndex));
        }
// Airport codes used for 1st iteration and testing
        String iataCodeOutboundAirport = f.getDeparture();
        String iataCodeDestinationAirport = f.getDestination();

        String outboundAirportName = "";
        String destinationAirportName = "";

        switch (iataCodeOutboundAirport){
            case "LHR":
                outboundAirportName = "London Heathrow Airport";
                break;
            case "LGW":
                outboundAirportName = "London Gatwick Airport";
                break;
        }

        switch (iataCodeDestinationAirport){
            case  "DBV":
                destinationAirportName = "Dubrovnik Airport";
                break;
            case  "MAD":
                destinationAirportName = "Adolfo Suárez Madrid-Barajas Airport";
                break;
            case  "YEG":
                destinationAirportName = "Edmonton International Airport";
                break;
            case  "YYC":
                destinationAirportName = "Calgary International Airport";
                break;
            case "CTA":
                destinationAirportName = "Catania–Fontanarossa Airport";
                break;
            case "ITO":
                destinationAirportName = "Hilo International Airport";
                break;
        }



// Format output string using extracted values
        String outputString = "The flight duration is ";

        if (hours > 0) {
            outputString += hours + " Hours ";
        }

        if (minutes > 0) {
            outputString += minutes + " minutes";
        }

        if (hours == 0 && minutes == 0) {
            outputString += "0 minutes";
        }

        outputString += " departing from " + outboundAirportName + " and arriving at " + destinationAirportName + ".";

        return outputString;
    }

}
