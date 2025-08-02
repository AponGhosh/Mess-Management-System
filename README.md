# Mess Management System

## Overview 
A Java-based desktop application to manage mess (shared accommodation) expenses efficiently by calculating rent, grocery, and meal costs per person. Built using fundamental **Object-Oriented Programming (OOP)** concepts, including **Encapsulation, Inheritance, Polymorphism, Abstraction**, and **Interfaces**.


## Features

- Input personal details of mess members.
- Calculate individual rent cost (equally shared).
- Track grocery and meal consumption per member.
- Determine the total amount payable per person.
- Identify whether a member needs to pay extra or get a refund.
- File handling for storing personal and payment information.
- Exception handling for robust user input.


## OOP Concepts Applied

| Concept         | Implementation                                                                 |
|-----------------|----------------------------------------------------------------------------------|
| **Encapsulation** | `Person` class with private fields and public getter/setter methods             |
| **Inheritance**   | `Project` → `Calculation` → `Rent`, with `Calculation` also implementing `Groceries` |
| **Polymorphism**  | Method overriding (e.g. `Cost()`, `Item_Price()`), and polymorphic object usage  |
| **Abstraction**   | Abstract class `Rent` and abstract methods like `MealCount()`                   |
| **Interface**     | `Groceries` interface with method declarations for groceries management         |


## Tools & Technologies

- **Language**: Java
- **IDE**: Apache NetBeans
- **JDK**: Version 17
- **Platform**: Desktop & Laptop 


## Cost Calculation Logic

1. **Rent** is divided equally among all members.
2. **Grocery cost per meal** = Total grocery cost ÷ Total meals consumed by all.
3. **Meal cost per person** = Per meal cost × Meals consumed by that person.
4. **Final amount** = Rent + (Meal cost – Personal groceries).
- If a member spends less on groceries than they consume, they pay the difference.
- If a member spends more on groceries than they consume, they are refunded.


## File Operations

- `ProjectFile.txt` – Stores personal info (name, contact, DOB, NID, address).
- `PaymentFile.txt` – Stores meal and total payment info.
- Uses `FileWriter`, `Scanner`, and `IOException` for reading/writing.


## Exception Handling

Handled two types of exceptions:

- **InputMismatchException** – For invalid data types (e.g., string instead of integer).
- **IOException** – For file read/write failures.


## Project Structure
Mess-Management-System/ <br>
├── src/ <br>
│   └── main/ <br>
│       ├── Person.java           # Encapsulates personal data (name, NID, etc.)<br>
│       ├── Rent.java             # Abstract class for rent-related fields & methods<br>
│       ├── Groceries.java        # Interface for grocery-related operations<br>
│       ├── Calculation.java      # Inherits Rent & implements Groceries (Polymorphism)<br>
│       └── Project.java          # Main driver class (user input, file handling, logic execution, output)<br>
├── ProjectFile.txt               # Stores resident personal information<br>
├── PaymentFile.txt               # Stores rent/grocery payment summary<br>
├── README.md                     # Project documentation<br>
└── pom.xml                       # Maven configuration file<br>


## Sample Output

![Input-personal-info](https://github.com/AponGhosh/Mess-Management-System/blob/main/Input-personal-info.png) <br>
![Payment-info](https://github.com/AponGhosh/Mess-Management-System/blob/main/Payment-info.png)<br>
![Info-saved-ProjectFile](https://github.com/AponGhosh/Mess-Management-System/blob/main/Info-saved-ProjectFile.png)<br>


## Clone & Run the Repository

1. **Clone the repository**
```bash
git clone https://github.com/AponGhosh/Mess-Management-System.git
```

2. **Navigate to the project directory**
```bash
cd Mess-Management-System
```

4. **How to Run**
- Open the project in **Apache NetBeans**.
- Ensure **JDK 17** is installed.
- Run the `Project.java` file.
- Follow CLI prompts to input data.
- View results in the terminal and generated files.

