package com.sda.weather.location;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationController {

    private final ObjectMapper objectMapper;
    private final LocationService locationService;

    public String createLocation(String inputData) {
        try {
            Location location = objectMapper.readValue(inputData, Location.class); // todo create and use LocationDTO
            Location targetLocation = locationService.createLocation(
                    location.getCityName(),
                    location.getLatitude(),
                    location.getLongitude(),
                    location.getCountryName(),
                    location.getRegion());
            return objectMapper.writeValueAsString(targetLocation); // todo LocationDTO
        } catch (IllegalArgumentException e) {
            return String.format("{\"message\": \"%s Spróbuj ponownie!\"}", e.getMessage()); // todo JSON format {"key": "value"}
        } catch (JsonProcessingException e) {
            return String.format("{\"message\": \"%s\" Spróbuj ponownie!}\n", e.getMessage()); // todo compare with a proper JSON (this above)
        }
    }
}
