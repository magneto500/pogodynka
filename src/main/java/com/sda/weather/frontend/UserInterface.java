package com.sda.weather.frontend;

import java.util.Scanner;

public class UserInterface {

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
    }

    private void getAllLocalizations() {
    }

    private void addLocalization() {
    }
}
