package subway.service;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.LineInformation;
import subway.domain.Station;
import subway.domain.StationInformation;
import subway.domain.StationRepository;
import subway.util.Parser;

public class SubwayService {

    public void preSetting() {
        for (String station : StationInformation.getStationInformation()) {
            StationRepository.addStation(new Station(station));
        }
        for (String line : LineInformation.getLineInformation()) {
            LineRepository.addLine(new Line(line));
        }
    }

    public List<String> calculatePathByDistance(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestPathByDistance();
        return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
    }

    public List<String> calculatePathByTime(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestPathByDistanceByTime();
        return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
    }

    private DijkstraShortestPath getDijkstraShortestPathByDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        for (String line : LineInformation.getLineInformation()) {
            List<String> stations = Parser.separateBySeparator(line, "_");
            graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(1)),
                    LineInformation.findDistanceByName(line));
        }
        return new DijkstraShortestPath(graph);
    }

    private DijkstraShortestPath getDijkstraShortestPathByDistanceByTime() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        for (String line : LineInformation.getLineInformation()) {
            List<String> stations = Parser.separateBySeparator(line, "_");
            graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(1)),
                    LineInformation.findTimeByName(line));
        }
        return new DijkstraShortestPath(graph);
    }
}
