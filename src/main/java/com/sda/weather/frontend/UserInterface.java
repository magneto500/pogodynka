package com.sda.weather.frontend;

import com.sda.weather.location.LocationController;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface {

    private final LocationController locationController;

    public void run() {
        System.out.println("Aplikacja jest uruchomiona\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Witaj w aplikacji pogody, co chcesz zrobić?");
            System.out.println("1. Dodać nową lokalizację");
            System.out.println("2. Wyśtwietlić lokalizacje");
            System.out.println("3. Pobrać informacje pogodowe");
            System.out.println("0. Wyjść z aplikacji");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addLocalization();
                    break;
                case 2:
                    getAllLocalizations();
                    break;
                case 3:
                    getWeatherInfo();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void getWeatherInfo() {
        System.out.println("Pobranie informacji pogodowych - praca nad utworzeniem funkjonalnośći trwa!");
    }

    private void getAllLocalizations() {
        System.out.println("Wyśtwietlanie lokalizacji - praca nad utworzeniem funkjonalnośći trwa!");
    }

    private void addLocalization() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę nowej miejscowości: ");
        String cityName = scanner.nextLine();
        System.out.println("Podaj szerokość geograficzną [W przypadku minut kątowych użyj przecinka jako separatora: -90,0 -> E, 90,0 -> W]: ");
        Double latitude = scanner.nextDouble();
        System.out.println("Podaj dlugość geograficzną [W przypadku minut kątowych użyj przecinka jako separatora: -180,0 -> S, 180,0 -> N]: ");
        Double longitude = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj nazwę kraju: ");
        String countryName = scanner.nextLine();
        System.out.println("Jeśli chcesz wpisz region, jeśli nie wciśnij enter: ");
        String region = scanner.nextLine();
        String requestBody = String.format("{\"cityName\":\"%s\",\"latitude\":\"%s\",\"longitude\":\"%s\",\"countryName\":\"%s\",\"region\":\"%s\"}", cityName, latitude, longitude, countryName, region);
        String responseBody = locationController.createLocation(requestBody);
        System.out.println("Odpowiedź serwera: " + responseBody);
    }
}
