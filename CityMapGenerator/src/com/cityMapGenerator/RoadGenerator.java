package com.cityMapGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoadGenerator {
    private static final int[] LANE_TYPES = {4, 3, 2, 1};

    public static List<Road> generateRoads(List<City> cities) {
        List<Road> roads = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < cities.size() - 1; i++) {
            City city1 = cities.get(i);
            City city2 = cities.get(rand.nextInt(cities.size()));

            if (!city1.equals(city2)) {
                int lanes = LANE_TYPES[rand.nextInt(LANE_TYPES.length)];
                roads.add(new Road(city1, city2, lanes));
            }
        }

        return roads;
    }
}

