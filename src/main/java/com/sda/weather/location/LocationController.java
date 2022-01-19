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
            LocationDTO locationDTOFromMapper = objectMapper.readValue(inputData, LocationDTO.class);
            Location location = locationService.createLocation(
                    locationDTOFromMapper.getCityName(),
                    locationDTOFromMapper.getLatitude(),
                    locationDTOFromMapper.getLongitude(),
                    locationDTOFromMapper.getCountryName(),
                    locationDTOFromMapper.getRegion());
            LocationDTO locationDTO = mapLocationToLocationDTO(location);
            return objectMapper.writeValueAsString(locationDTO);
        } catch (IllegalArgumentException e) {
            return String.format("{\"message\": \"%s\"}", e.getMessage());
        } catch (JsonProcessingException e) {
            return String.format("{\"message\": \"%s\"}", e.getMessage());
        }
    }

    private LocationDTO mapLocationToLocationDTO(Location newLocation) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(newLocation.getId());
        locationDTO.setCityName(newLocation.getCityName());
        locationDTO.setLatitude(newLocation.getLatitude());
        locationDTO.setLongitude(newLocation.getLongitude());
        locationDTO.setCountryName(newLocation.getCountryName());
        locationDTO.setRegion(newLocation.getRegion());
        return locationDTO;
    }
}
