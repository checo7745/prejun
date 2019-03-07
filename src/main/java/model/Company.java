package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private String name;
    private List<TransportPlane> transportPlanes = new ArrayList<TransportPlane>();
    private List<Airline> airlines = new ArrayList<Airline>();

    public Company(String name, List<TransportPlane> transportPlanes, List<Airline> airlines) {
        this.name = name;
        this.transportPlanes = transportPlanes;
        this.airlines = airlines;
    }

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TransportPlane> getTransportPlanes() {
        return transportPlanes;
    }

    public void setTransportPlanes(List<TransportPlane> transportPlanes) {
        this.transportPlanes = transportPlanes;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public void addTransportPlane(TransportPlane plane) {
        transportPlanes.add(plane);
    }

    public double countCarryingCapacity() {
        return transportPlanes.stream()
                              .mapToDouble(TransportPlane::getCarryingCapacity)
                              .sum();
    }

    public double countPeopleCapacity () {
        return airlines.stream()
                              .mapToInt(Airline::getPeopleCapacity)
                              .sum();
    }

    public void sortByDistance() {
        List<Double> listDistance = new ArrayList<Double>();
        for (TransportPlane plane : transportPlanes) {
            listDistance.add(plane.getDistanceCapacity());
        }
        for (Airline plane : airlines) {
            listDistance.add(plane.getDistanceCapacity());
        }

        Collections.sort(listDistance);
        System.out.println("Sorted by distance:\n");
        for (double distance : listDistance) {
            System.out.println("\n" + distance);
        }


    }

}
