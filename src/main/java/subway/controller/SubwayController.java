package subway.controller;

import java.util.List;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final SubwayService subwayService;

    public SubwayController(InputView inputView, SubwayService subwayService) {
        this.inputView = inputView;
        this.subwayService = subwayService;
    }

    public void run() {
        subwayService.preSetting();
        while (true) {
            String mainOption = returnMainOption();
            if (processMainOne(mainOption)) {
                continue;
            }
            if (processMainTwo(mainOption)) {
                break;
            }
        }
    }

    private boolean processMainOne(String mainOption) {
        if (mainOption.equals("1")) {
            return processStandard();
        }
        return false;
    }

    private static boolean processMainTwo(String mainOption) {
        return mainOption.equals("Q");
    }

    private boolean processStandard() {
        String standardOption = returnStandardOption();
        processStandardOne(standardOption);
        processStandardTwo(standardOption);
        return processStandardQ(standardOption);
    }

    private void processStandardOne(String standardOption) {
        if (standardOption.equals("1")) {
            String departureStation = returnDepartureStation();
            String arrivalStation = returnArrivalStation(departureStation);
            int distance = subwayService.calculateShortestDistance(departureStation, arrivalStation);
            List<String> stations = subwayService.calculatePathByDistance(departureStation, arrivalStation);
            int time = subwayService.calculateTime(stations);
            OutputView.printResult(distance, time, stations);
        }
    }

    private void processStandardTwo(String standardOption) {
        if (standardOption.equals("2")) {
            String departureStation = returnDepartureStation();
            String arrivalStation = returnArrivalStation(departureStation);
            int time = subwayService.calculateShortestTime(departureStation, arrivalStation);
            List<String> stations = subwayService.calculatePathByTime(departureStation, arrivalStation);
            int distance = subwayService.calculateDistance(stations);
            OutputView.printResult(distance, time, stations);
        }
    }

    private static boolean processStandardQ(String standardOption) {
        return standardOption.equals("B");
    }

    public String returnMainOption() {
        while (true) {
            try {
                OutputView.printMainOptionGuidance();
                return inputView.readMainOption();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public String returnStandardOption() {
        while (true) {
            try {
                OutputView.printStandardOptionGuidance();
                return inputView.readStandardOption();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public String returnDepartureStation() {
        while (true) {
            try {
                OutputView.printDepartureStationGuidance();
                return inputView.readDepartureStation();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public String returnArrivalStation(String departureStation) {
        while (true) {
            try {
                OutputView.printArrivalStationGuidance();
                return inputView.readArrivalStation(departureStation);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
