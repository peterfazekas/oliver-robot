package hu.robot.model.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {

    private final int id;
    private final String commands;
    private final List<Step> steps;
    private final int batteryDemand;

    public Program(int id, String commands) {
        this.id = id;
        this.commands = commands;
        steps = createSteps();
        batteryDemand = createBatteryDemand();
    }

    public int getId() {
        return id;
    }

    public String getCommands() {
        return commands;
    }

    public int getBatteryDemand() {
        return batteryDemand;
    }

    public boolean isReducible() {
        return commands.contains("ED") || commands.contains("DE") || commands.contains("KN") || commands.contains("NK");
    }

    public String getWayBackToOrigin() {
        return steps.get(steps.size() - 1).toString();
    }

    public String getFarthestStepDetails() {
        Step step = getFarthestStep();
        return String.format("A robot a %d lépést követően került (légvonalban) legtávolabb a kiindulási ponttól, " +
                "a távolság %5.3f cm.", step.getId(), step.getDistance());
    }

    public boolean isLowCapacityBattery() {
        return batteryDemand <= 100;
    }

    private Step getFarthestStep() {
        return steps.stream()
                .max(Comparator.comparing(Step::getDistance))
                .get();
    }

    private List<Step> createSteps() {
        List<Step> steps = new ArrayList<>();
        Coordinate actual = new Coordinate(0, 0);
        for (int i = 0; i < commands.length(); i++) {
            String command = String.valueOf(commands.charAt(i));
            Direction direction = Direction.valueOf(command);
            Coordinate coordinate = direction.getCoordinate();
            actual = actual.move(coordinate);
            Step step = new Step(i + 1, actual);
            steps.add(step);
        }
        return steps;
    }

    private int createBatteryDemand() {
        int battery = 3;
        for (int i = 1; i < commands.length(); i++) {
            battery += commands.charAt(i) == commands.charAt(i - 1) ? 1 : 3;
        }
        return battery;
    }
}
