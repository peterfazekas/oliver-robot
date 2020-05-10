package hu.robot.model.domain;

public class Step {

    private final int id;
    private final Coordinate coordinate;

    public Step(int id, Coordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
    }

    public int getId() {
        return id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getDistance() {
        return coordinate.getDistance();
    }

    @Override
    public String toString() {
        return coordinate.toString();
    }
}
