/*
 * Reference:
 * GeeksforGeeks. (n.d.). Encapsulation in Java. Retrieved [Date you accessed the page], from https://www.geeksforgeeks.org/encapsulation-in-java/
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Class representing a ticket.
public class Ticket {

    // Fields representing ticket attributes
    private String row;
    private int seat;
    private double price;
    private Person person;

    //Constructor to initialize a Ticket object with row, seat, price, and person.
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getter for the row of the ticket.
    public String getRow() {
        return row;
    }

    //Setter for the row of the ticket.
    public void setRow(String row) {
        this.row = row;
    }

    //Getter for the seat number of the ticket.
    public int getSeat() {
        return seat;
    }

    //Setter for the seat number of the ticket.
    public void setSeat(int seat) {
        this.seat = seat;
    }

    //Getter for the price of the ticket.
    public double getPrice() {
        return price;
    }

    //Setter for the price of the ticket.
    public void setPrice(double price) {
        this.price = price;
    }

    //Getter for the person associated with the ticket.
    public Person getPerson() {
        return person;
    }

    //Setter for the person associated with the ticket.
    public void setPerson(Person person) {
        this.person = person;
    }

    //Method to print ticket information.
    public void printTicketInfo() {
        System.out.format("""
                        Ticket Information
                        Row : %s
                        Seat : %s
                        Price : $%s
                        Person Information :
                        """,
                row, seat, price);
        person.printPersonInfo();
    }

    //Method to save ticket information to a file.
    public void save() {
        String fileName = row + seat + ".txt";
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write("Ticket Information:\n");
            writer.write("Row: " + row + "\n");
            writer.write("Seat: " + seat + "\n");
            writer.write("Price: £" + price + "\n");
            writer.write("Person Information:\n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket information saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the ticket information.");
            e.printStackTrace();
        }
    }
}
