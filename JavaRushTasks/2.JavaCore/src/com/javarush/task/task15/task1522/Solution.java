package com.javarush.task.task15.task1522;

/*
Закрепляем Singleton pattern
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String planetName = scanner.nextLine();
        if (planetName.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        }
        else if (planetName.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        }
        else if (planetName.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        }
        else thePlanet = null;
    }
}
