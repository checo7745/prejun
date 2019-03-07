package model;

public class Airline extends Plane {

    private int peopleCapacity;
    private AirClass airClass;

    public Airline(int peopleCapacity, AirClass airClass, double distance) {
        this.peopleCapacity = peopleCapacity;
        this.airClass = airClass;
        setDistanceCapacity(distance);
    }

    public Airline() {
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public AirClass getAirClass() {
        return airClass;
    }

    public void setAirClass(AirClass airClass) {
        this.airClass = airClass;
    }
}
