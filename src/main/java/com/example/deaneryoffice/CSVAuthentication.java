package com.example.deaneryoffice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVAuthentication {
    private static final String CSV_FILE_PATH = "/Users/yelyzaveta/IdeaProjects/DeaneryOffice/src/main/webapp/students.csv";
    private static final Logger logger = Logger.getLogger(CSVAuthentication.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Request user input
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate user
        if (authenticateUser(email, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed. Invalid email or password.");
        }

        scanner.close();
    }
    private static boolean authenticateUser(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 6) {
                    logger.info("Checking email: " + values[3] + " and password: " + values[5]);
                    if (values[3].equals(email) && values[5].equals(password)) {
                        logger.info("Authentication successful for email: " + email);
                        return true;
                    }
                } else {
                    logger.warning("Incorrect format in line: " + line);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception during user authentication", e);
        }
        logger.info("Authentication failed for email: " + email);
        return false;
    }
}


