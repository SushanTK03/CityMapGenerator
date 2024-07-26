package com.cityMapGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CityGenerator {
    private static final String[] NAMES = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda", "Mu", "Nu", "Xi", "Omicron", "Pi", "Rho", "Sigma", "Tau", "Upsilon", "Phi", "Chi", "Psi", "Omega"};
    private static final Random RANDOM = new Random();

    public static List<City> generateCities(int count) {
        List<City> cities = new ArrayList<>();
        Set<String> usedNames = new HashSet<>();

        for (int i = 0; i < count; i++) {
            String name;
            do {
                name = NAMES[RANDOM.nextInt(NAMES.length)] + i; // Ensure uniqueness by appending index
            } while (usedNames.contains(name));

            usedNames.add(name);

            double latitude = RANDOM.nextDouble() * 180 - 90; // Random latitude between -90 and 90
            double longitude = RANDOM.nextDouble() * 360 - 180; // Random longitude between -180 and 180

            cities.add(new City(name, latitude, longitude));
        }

        return cities;
    }
}
