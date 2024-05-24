/*
 * Reference: Read inputs from console (BufferedReader, InputStreamReader,  java.io.IOException)
 * GeeksforGeeks. "Ways to read input from console in Java."
 * Available online: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
 */

/*
 * Reference: To delete a text file
 * W3Schools. "Java Files Delete."
 * Available online: https://www.w3schools.com/java/java_files_delete.asp
 */

/*
 * Reference: to continue validation for the email
 * GeeksforGeeks. "Check whether an email address is valid or not in Java."
 * Available online: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
 */





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

public class PlaneManagement {

//  Arrays to represent seat availability for each row
    static int[] A = new int[14];
    static int[] B = new int[12];
    static int[] C = new int[12];
    static int[] D = new int[14];
    static Ticket[] tickets = new Ticket[52];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("\n*   Welcome to the Plane Management application  *");
        menu();
    }

//  Method to display menu options and handle user input
    private static void menu() {
        while (true) {
            System.out.println("""
                    **************************************************
                    *                  MENU OPTIONS                  *
                    **************************************************
                          1) Buy a seat
                          2) Cancel a seat
                          3) Find first available seat
                          4) Show seating plan
                          5) Print ticket information and total sales
                          6) Search ticket
                          0) Quit
                    **************************************************
                    """);

            try {
                System.out.print("Please select an option : ");
                int option = Integer.parseInt(br.readLine());

//  Switch statement to handle menu options, directing to corresponding methods

                switch (option) {
                    case 1 -> buy_a_seat();
                    case 2 -> cancel_a_seat();
                    case 3 -> find_first_available();
                    case 4 -> show_seating_plan();
                    case 5 -> print_ticket_info();
                    case 6 -> search_ticket();
                    case 0 -> {                // Quit the program
                        br.close();            // Close BufferedReader
                        System.exit(0);  // Exit the program
                    }
                    default -> System.out.println("""
                            ------------------------------------------------------
                            Invalid option!!! Please enter a number between 0 and 6.
                            ------------------------------------------------------
                            """);
                }
            } catch (Exception e) {
                System.out.println("""
                        -------------------------------------------
                        Invalid input!!! Please enter a valid option.
                        -------------------------------------------
                        """);
            }
        }
    }

//  Method to get the seat availability array for a given row

    private static int[] getRow(String rowLetter) {
        switch (rowLetter) {
            case "A" -> {
                return A;
            }
            case "B" -> {
                return B;
            }
            case "C" -> {
                return C;
            }
            case "D" -> {
                return D;
            }
        }
        return null;
    }

//  Method to validate whether a seat is available
    private static int validateSeat(String row, int seat) {
        if (seat > 0 && seat <= getRow(row).length) {
            if (getRow(row)[seat - 1] == 0) {
                return 0;         // Seat is available
            } else {
                return 1;         // Seat is occupied
            }
        }
        return 2;                 // Invalid seat number
    }

//  Method to get the row letter from user input
    private static String getRowLetter() {
        String rowLetter;

        while (true) {
            System.out.print("Enter the row letter (A, B, C, D): ");
            try {
                rowLetter = br.readLine().toUpperCase();

                if (!rowLetter.matches("[ABCD]")) {
                    System.out.println("""
                            --------------------------------------------------
                             Invalid row letter!!! Please enter A, B, C, or D.
                            --------------------------------------------------
                            """);
                } else {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return rowLetter;
    }

//  Method to get the seat number from user input
    private static int getSeatNumber(String rowLetter, boolean buyOrCancel) { // buy = true, cancel = false
        int seatNumber;

        while (true) {
            System.out.print("Enter the seat number: ");
            try {
                seatNumber = Integer.parseInt(br.readLine());

                switch (validateSeat(rowLetter, seatNumber)) {
                    case 0 -> {
                        if (buyOrCancel) {
                            return seatNumber;
                        } else {
                            System.out.format("""
                                            --------------------------------------
                                            Seat %s %s is already available.
                                            --------------------------------------
                                            """,
                                    rowLetter, seatNumber);
                            return 15;
                        }
                    }
                    case 1 -> {
                        if (buyOrCancel) {
                            System.out.println("""
                                    ----------------------------------------------------------------
                                    Sorry, the seat is already occupied. Please choose another seat.
                                    ----------------------------------------------------------------
                                    """);
                            return 15;
                        } else {
                            return seatNumber;
                        }
                    }
                    case 2 -> {
                        System.out.println("""
                                -----------------------------
                                 Sorry, Invalid seat number!!!
                                -----------------------------
                                """);

                    }
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("""
                        -----------------------------
                         Sorry, Invalid seat number!!!
                        -----------------------------
                        """);

            }
        }
    }

//  Method to handle purchasing a seat
    private static void buy_a_seat() {
        boolean available = false;
        for (Ticket ticket : tickets) {
            if (ticket == null || ticket.getPerson() == null) {
                available = true;
                break;
            }
        }
        if (!available) {
            System.out.println("Sorry, All tickets are sold out!!!");
            return;
        }

        String rowLetter = getRowLetter();
        int seatNumber = getSeatNumber(rowLetter, true);
        if (seatNumber == 15) {
            return;
        }

//  Get person's information

        System.out.println("""
                --------------------------------
                Enter the person's information:
                --------------------------------
                """);


        String name;
        while (true) {
            System.out.print("Enter the person's First name: ");
            try {
                name = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("""
                        ----------------------------
                        Please enter a valid name.
                        ----------------------------
                        """);
            }
        }

        String surname;
        while (true) {
            System.out.print("Enter the person's Surname: ");
            try {
                surname = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!surname.isEmpty()) {
                break;
            } else {
                System.out.println("""
                        -----------------------------
                        Please enter a valid Surname.
                        -----------------------------
                        """);
            }
        }

        String email;
        while (true) {
            System.out.print("Enter the person's e-mail address: ");
            try {
                email = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Validate email
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("""
                        -----------------------------------
                        Please enter a valid e-mail address.
                        -----------------------------------
                        """);
            }
        }

        // Create Person object
        Person person = new Person(name, surname, email);

        double price = calculatePrice(seatNumber);

        // Create Ticket object
        Ticket ticket = new Ticket(rowLetter, seatNumber, price, person);

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                tickets[i] = ticket;
                break;
            }
        }
        getRow(rowLetter)[seatNumber - 1] = 1;
        ticket.save();

        System.out.format("""
                        --------------------------------------------
                        Seat %s %s has been successfully purchased.
                        --------------------------------------------
                        """,
                rowLetter, seatNumber);
    }


    // Method to validate email format
    static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }


    // Method to calculate ticket price based on seat number
    static double calculatePrice(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= 5) {
            return 200.0;
        } else if (seatNumber >= 6 && seatNumber <= 9) {
            return 150.0;
        } else if (seatNumber >= 10 && seatNumber <= 14) {
            return 180.0;
        }
        // Default price
        return 0.0;
    }

    // Method to cancel a seat
    static void cancel_a_seat() {
        String rowLetter = getRowLetter();
        int seatNumber = getSeatNumber(rowLetter, false);
        if (seatNumber == 15) {
            return;
        }

        // Get the corresponding ticket
        Ticket cancelledTicket = null;
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getRow().equals(rowLetter) && ticket.getSeat() == seatNumber) {
                cancelledTicket = ticket;
                break;
            }
        }

        // If ticket found, cancel it and delete the corresponding file
        if (cancelledTicket != null) {
            getRow(rowLetter)[seatNumber - 1] = 0;

            // Remove ticket from tickets array
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == cancelledTicket) {
                    tickets[i] = null;
                    break;
                }
            }

            // Delete ticket file
            String fileName = rowLetter + seatNumber + ".txt";
            File file = new File(fileName);
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Ticket file " + fileName + " deleted.");
                } else {
                    System.out.println("Failed to delete ticket file " + fileName);
                }
            } else {
                System.out.println("Ticket file " + fileName + " does not exist.");
            }

            System.out.format("""
                                        
                --------------------------------------------------
                Seat %s %s has been successfully canceled.
                --------------------------------------------------
                """,
                    rowLetter, seatNumber);
        } else {
            System.out.println("Ticket not found for seat " + rowLetter + seatNumber);
        }
    }


    // Method to find the first available seat
    static void find_first_available() {
        char[] rows = {'A', 'B', 'C', 'D'};
        int[][] seatArrays = {A, B, C, D};

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < seatArrays[i].length; j++) {
                if (seatArrays[i][j] == 0) {
                    System.out.println(String.format("""
                                    %n------------------------------------
                                    The first available seat is: %c%d
                                    ------------------------------------%n""",
                            rows[i], (j + 1)));
                    return;
                }
            }
        }
        System.out.println("Sorry, there are no available seats right now. All tickets are sold out!!!");
    }

    // Method to display the seating plan
    static void show_seating_plan() {
        String[] rows = {"A", "B", "C", "D"};
        for (String i : rows) {
            for (int j : getRow(i)) {
                if (j == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    // Method to print ticket information and total sales
    static void print_ticket_info() {
        double totalAmount = 0.0;

        for (Ticket ticket : tickets) {
            if (ticket != null) {
                totalAmount += ticket.getPrice();
                Person person = ticket.getPerson();

                System.out.format("""
                                -----------------------------------
                                        Tickets Information
                                -----------------------------------
                                Row: %s
                                Seat: %s
                                Price: £%s
                                Person Information:
                                    Name: %s
                                    Surname: %s
                                    Email: %s
                                -----------------------------------
                                """,
                        ticket.getRow(), ticket.getSeat(), ticket.getPrice(),
                        person.getName(), person.getSurname(), person.getEmail());
            }
        }

        System.out.format("""
                Total Amount: £%s
                -----------------------------------
                """, totalAmount);
    }

    // Method to search for a ticket
    static void search_ticket() {
        String rowLetter = getRowLetter();
        int seatNumber = getSeatNumber(rowLetter, false);
        if (seatNumber == 15) {
            return;
        }

        // Iterate through tickets to find the ticket for given seat
        for (Ticket ticket : tickets) {
            if (ticket.getRow().equals(rowLetter) && ticket.getSeat() == seatNumber) {
                System.out.println("--------------------------------------");
                System.out.println("Seat " + rowLetter + seatNumber + " is not available.");
                System.out.println("--------------------------------------");
                System.out.println("Ticket Information:");
                System.out.println("Row: " + ticket.getRow());
                System.out.println("Seat: " + ticket.getSeat());
                System.out.println("Price: £" + ticket.getPrice());
                System.out.println("Person Information:");
                Person person = ticket.getPerson();
                System.out.println("Name: " + person.getName());
                System.out.println("Surname: " + person.getSurname());
                System.out.println("Email: " + person.getEmail());
                System.out.println("--------------------------------------");
                break;
            }
        }
    }
}
