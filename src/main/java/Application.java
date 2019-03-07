import java.util.List;
import java.util.Scanner;

import model.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.CompanyService;

public class Application {

    static final Logger log = LogManager.getRootLogger();
    private static CompanyService companyService = new CompanyService();
    private static Company belavia = CompanyService.init();

    public static void main (String args[]) {
        welcomeMesssage();
        input();
    }

    private static void welcomeMesssage() {
        log.info("Hi!\n");
        log.info("Let's start!\n");
        log.info("\nAvailable commands:\n P - People Capacity\n C - Carrying Capacity\n S - Sorting by distance\n Search - Search plane\n Q - Exit");
    }

    private static void input() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            log.info("Enter command: ");
            String input = scanner.nextLine();

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

                case "Search":
                    searchPlaneByCompany(belavia);

                default:
                    log.warn("Not matching! Try Again!\n");
            }
        }
    }

    private static void searchPlaneByCompany(Company company) {
        Scanner scanner = new Scanner(System.in);
        log.info("Select search param and value:\n P - People Capacity\n C - Carrying Capacity\n D - Distance\n Format of search: Format:value");
        String input = scanner.nextLine();
        String[] array = input.split("[:]");
        String param = array[0];
        List<Long> numbers;
        double value = Double.valueOf(array[1]);
        log.info("Param:" + param + "\nValue: " + value);
        switch (param) {
            case "P":
                log.info("Search by People");
                numbers = companyService.searchByPeople(company, value);
                log.info("# of matched planes:");
                numbers.forEach(System.out::println);
                break;

            case "C":
                log.info("Search by Carrying");
                numbers = companyService.searchByCarrying(company, value);
                log.info("# of matched planes:");
                numbers.forEach(System.out::println);
                break;

            case "D":
                log.info("Search by Distance");
                companyService.searchByDistance(company, value);
                log.info("# of matched planes:");
                break;

            case "Q":
                log.info("Exit!\n");
                System.exit(0);
                break;

            default:
                log.warn("Incorrect value!");
        }
    }

}
