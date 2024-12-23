package subway.service;

import static subway.constant.InputConstant.*;

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

    public int calculateShortestDistance(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestPathByDistance();
        return (int) dijkstraShortestPath.getPathWeight(departureStation, arrivalStation);
    }

    public int calculateShortestTime(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestPathByDistanceByTime();
        return (int) dijkstraShortestPath.getPathWeight(departureStation, arrivalStation);
    }

    public int calculateDistance(List<String> paths) {
        return LineInformation.sumDistance(paths);
    }

    public int calculateTime(List<String> paths) {
        return LineInformation.sumTime(paths);
    }

    private DijkstraShortestPath getDijkstraShortestPathByDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        for (String line : LineInformation.getLineInformation()) {
            List<String> stations = Parser.separateBySeparator(line, LINE_SEPARATOR.getContent());
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
            List<String> stations = Parser.separateBySeparator(line, LINE_SEPARATOR.getContent());
            graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(1)),
                    LineInformation.findTimeByName(line));
        }
        return new DijkstraShortestPath(graph);
    }
}
