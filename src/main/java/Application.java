import java.io.Console;
import java.util.Scanner;

import model.AirClass;
import model.Airline;
import model.Company;
import model.Consignment;
import model.TransportPlane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    static final Logger log = LogManager.getRootLogger();
    static Company belavia = init();

    public static void main (String args[]) {
        welcomeMesssage();
        input();
    }

    private static void welcomeMesssage() {
        log.info("Hi!\n");
        log.info("Let's start!\n");
        log.info("\nAvailable commands:\n P - People Capacity\n C - Carrying Capacity\n S - Sorting by distance\n Q - Exit");
    }

    private static void input() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            log.info("Enter command: ");
            String input = scanner.nextLine();
            log.info("Input : " + input);
            log.info("\n-----------\n");

            switch(input) {
                case "Q":
                    log.info("Exit!\n");
                    System.exit(0);
                    break;

                case "P":
                    log.info("Total people capacity of company: " + belavia.countPeopleCapacity());
                    break;

                case "C":
                    log.info("Total carrying capacity of company: " + belavia.countCarryingCapacity());
                    break;

                case "S":
                    log.info("Sorting by distance: \n");
                    belavia.sortByDistance();
                    break;

                default:
                    log.warn("Not matching! Try Again!\n");
            }
        }
    }

    private static Company init() {
        Company company = new Company("Belavia");
        TransportPlane transportFirst = new TransportPlane(Consignment.CAR, 26, 5000);
        TransportPlane transportSecond = new TransportPlane(Consignment.MEAL, 50, 15000);
        Airline airlineFirst = new Airline(100, AirClass.BUSINESS, 6000);
        Airline airlineSecond = new Airline(200, AirClass.SECOND, 10000);
        company.addAirline(airlineFirst);
        company.addAirline(airlineSecond);
        company.addTransportPlane(transportFirst);
        company.addTransportPlane(transportSecond);
        return company;
    }


}
