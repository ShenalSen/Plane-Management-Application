# Plane-Management-Application

This Java-based application leverages Object-Oriented Programming (OOP) principles to manage airplane seating and ticketing. It allows users to perform various operations such as purchasing tickets, canceling seats, searching for tickets, and displaying seating plans.

## Key Features:

1. **Seat Purchase**: Users can buy tickets by providing personal information (name, surname, email). The application verifies seat availability, calculates ticket prices based on seat location, and stores ticket details.
2. **Seat Cancellation**: Allows users to cancel previously booked seats. The application updates the seating plan and deletes the associated ticket file.
3. **First Available Seat**: Quickly finds and displays the first available seat in the plane.
4. **Seating Plan Display**: Shows the current seating arrangement, indicating occupied and available seats.
5. **Ticket Information and Total Sales**: Prints detailed ticket information along with the total sales amount.
6. **Ticket Search**: Users can search for tickets using seat number and row, and view the associated booking details.

With robust input validation and user-friendly messages, this application ensures smooth and efficient management of plane seating and ticketing operations.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Class Structure](#class-structure)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Installation

To install and run the Plane-Management-Application, follow these steps:

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/Plane-Management-Application.git

2. **Navigate to the project directory**:
   ```sh
   cd Plane-Management-Application
   ```

3. **Compile the Java files**:
   ```sh
   javac -d bin src/*.java
   ```

4. **Run the application**:
   ```sh
   java -cp bin Main
   ```

## Usage

Upon running the application, a menu will be displayed with the following options:

1. **Purchase Ticket**: Follow the prompts to enter personal information and seat preference. The application will confirm the purchase if the seat is available.
2. **Cancel Seat**: Enter the seat number and row of the booking you wish to cancel. The application will update the seating plan accordingly.
3. **First Available Seat**: The application will display the first available seat in the plane.
4. **Display Seating Plan**: View the current seating arrangement, with occupied and available seats clearly indicated.
5. **Ticket Information and Total Sales**: View detailed information about all purchased tickets and the total sales amount.
6. **Search Ticket**: Enter the seat number and row to view the details of a specific booking.

## Class Structure

- **Main**: Entry point of the application. Handles the user interface and menu options.
- **Seat**: Represents a seat in the plane. Contains seat attributes and methods to check availability.
- **Ticket**: Represents a ticket. Contains customer details and ticket information.
- **Plane**: Manages the seating plan and ticketing operations. Includes methods for purchasing tickets, canceling seats, searching tickets, and displaying the seating plan.

## Contributing

Contributions are welcome! Follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature/YourFeature`).
6. Open a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
