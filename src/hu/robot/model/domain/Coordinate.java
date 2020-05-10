package hu.robot.model.domain;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate move(Coordinate vector) {
        return new Coordinate(x + vector.getX(), y + vector.getY());
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public String toString() {
        return String.format("%d lépést kell tenni az ED, %d lépést a KN tengely mentén.", Math.abs(y), Math.abs(x));
    }
}
