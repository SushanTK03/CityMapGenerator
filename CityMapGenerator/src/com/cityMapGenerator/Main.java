package com.cityMapGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = CityGenerator.generateCities(100);
        List<Road> roads = RoadGenerator.generateRoads(cities);
        
        // Print cities
        for (City city : cities) {
            System.out.println(city.getName() + ": (" + city.getLatitude() + ", " + city.getLongitude() + ")");
        }

        // Visualize the map
        MapVisualizer.visualize(cities, roads);
    }
}

