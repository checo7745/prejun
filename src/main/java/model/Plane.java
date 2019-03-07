package model;

public abstract class Plane {

    protected long number = 1;
    private double distanceCapacity;

    Plane() {
        ++number;
    }

    public long getNumber() {
        return number;
    }

    public double getDistanceCapacity() {
        return distanceCapacity;
    }

    public void setDistanceCapacity(double distanceCapacity) {
        this.distanceCapacity = distanceCapacity;
    }
}
