package edu.institution;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InstitutionDatabase database = new InstitutionDatabase();

        // Initial menu for user choice
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert Institution Information");
            System.out.println("2. Search Institutions");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertInstitutionInfo(scanner, database);
                    break;
                case 2:
                    searchInstitutions(scanner, database);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
            }
        }
    }

    private static void insertInstitutionInfo(Scanner scanner, InstitutionDatabase database) {
        System.out.print("Enter the number of institutions to add: ");
        int numInstitutions = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numInstitutions; i++) {
            System.out.println("Enter details for institution " + (i + 1) + ":");

            System.out.print("Enter the name of the institution: ");
            String name = scanner.nextLine();

            System.out.print("Enter the location of the institution: ");
            String location = scanner.nextLine();

            System.out.print("Enter the start of the school year (e.g., August): ");
            String schoolYearStart = scanner.nextLine();

            System.out.print("Enter the end of the school year (e.g., May): ");
            String schoolYearEnd = scanner.nextLine();

            EducationalInstitution institution = new EducationalInstitution(name, location, schoolYearStart, schoolYearEnd);

            System.out.print("Enter the number of courses to add: ");
            int numCourses = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int j = 0; j < numCourses; j++) {
                System.out.print("Enter course name: ");
                String course = scanner.nextLine();
                institution.addCourse(course);
            }

            database.addInstitution(institution);
        }
    }

    private static void searchInstitutions(Scanner scanner, InstitutionDatabase database) {
        while (true) {
            System.out.println("\nSearch options:");
            System.out.println("1. By Location");
            System.out.println("2. By Course");
            System.out.println("3. By School Year");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    List<EducationalInstitution> locationResults = database.searchByLocation(location);
                    printSearchResults(locationResults);
                    break;
                case 2:
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    List<EducationalInstitution> courseResults = database.searchByCourse(course);
                    printSearchResults(courseResults);
                    break;
                case 3:
                    System.out.print("Enter school year start date (e.g., August): ");
                    String start = scanner.nextLine();
                    System.out.print("Enter school year end date (e.g., May): ");
                    String end = scanner.nextLine();
                    List<EducationalInstitution> schoolYearResults = database.searchBySchoolYear(start, end);
                    printSearchResults(schoolYearResults);
                    break;
                case 4:
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }

    private static void printSearchResults(List<EducationalInstitution> results) {
        if (results.isEmpty()) {
            System.out.println("No institutions found matching the criteria.");
        } else {
            results.forEach(EducationalInstitution::printDetails);
        }
    }
}
