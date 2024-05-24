//Class representing a person.
public class Person {
    private String name;
    private String surname;
    private String email;


    //Constructor to initialize a Person object with name, surname, and email.
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Getter for the person's name.
    public String getName() {
        return name;
    }

    //Setter for the person's name.
    public void setName(String name) {
        this.name = name;
    }

    //Getter for the person's surname.
    public String getSurname() {
        return surname;
    }

    //Setter for the person's surname.
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Getter for the person's email address.
    public String getEmail() {
        return email;
    }

    //Setter for the person's email address.
    public void setEmail(String email) {
        this.email = email;
    }


    //Method to print person's information.
    public void printPersonInfo() {
        System.out.format("""
                        \tName : %s
                        \tSurname : %s
                        \tEmail : %s
                        """,
                name, surname, email);
    }
}
