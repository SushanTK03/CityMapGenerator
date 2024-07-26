package com.cityMapGenerator;


import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class MapVisualizer {
    public static void visualize(List<City> cities, List<Road> roads) {
        Graph graph = new SingleGraph("CityMap");

        // Add cities as nodes
        for (City city : cities) {
            graph.addNode(city.getName())
                 .setAttribute("xyz", city.getLatitude(), city.getLongitude(), 0);
        }

        // Add roads as edges
        for (Road road : roads) {
            graph.addEdge(road.getCity1().getName() + "-" + road.getCity2().getName(),
                          road.getCity1().getName(),
                          road.getCity2().getName())
                 .setAttribute("ui.label", road.getLanes() + " lanes");
        }

        // Visualize the graph
        Viewer viewer = graph.display();
        viewer.enableAutoLayout();
    }
}


