package service;

import java.util.List;
import java.util.stream.Collectors;


import model.AirClass;
import model.Airline;
import model.Company;
import model.Consignment;
import model.TransportPlane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyService {

    static final Logger log = LogManager.getRootLogger();

    public static Company init() {
        Company company = new Company("Belavia");
        TransportPlane transportFirst = new TransportPlane(Consignment.CAR, 26, 5000);
        TransportPlane transportSecond = new TransportPlane(Consignment.MEAL, 50, 15000);
        Airline airlineFirst = new Airline(100, AirClass.BUSINESS, 6000);
        Airline airlineSecond = new Airline(200, AirClass.SECOND, 10000);
        TransportPlane transportThird = new TransportPlane(Consignment.ELECTRONIC, 50, 7000);
        Airline airlineThird = new Airline(200, AirClass.FIRST, 120000);
        company.addAirline(airlineFirst);
        company.addAirline(airlineSecond);
        company.addTransportPlane(transportFirst);
        company.addTransportPlane(transportSecond);
        company.addAirline(airlineThird);
        company.addTransportPlane(transportThird);
        return company;
    }

    public List<Long> searchByPeople(Company company, double value) {
        return company.getAirlines()
                      .stream()
                      .filter(o -> o.getPeopleCapacity() == value)
                      .map(Airline::getNumber)
                      .collect(Collectors.toList());
    }

    public List<Long> searchByCarrying(Company company, double value) {
        return company.getTransportPlanes()
                      .stream()
                      .filter(o -> o.getCarryingCapacity() == value)
                      .map(TransportPlane::getNumber)
                      .collect(Collectors.toList());
    }

    public List<Long> searchByDistance(Company company, double value) {
        return null; //TODO
    }
}
