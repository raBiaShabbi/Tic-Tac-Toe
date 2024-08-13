## Tic Tac Toe Game

This Java application implements a simple Tic Tac Toe game using Swing for the graphical user interface. The game allows two players to play Tic Tac Toe in a graphical environment, featuring a simple and interactive interface. The game is designed with a bold color scheme and includes basic functionality for game management.

### Features

- **Graphical User Interface:** The game uses `JFrame`, `JPanel`, and `JButton` from the Swing library to create a visually appealing interface with a 3x3 grid for the Tic Tac Toe board.
- **Icon Integration:** Includes a custom application icon.
- **Player Turns:** Alternates turns between Player One and Player Two. Player One uses "O" and Player Two uses "X".
- **Win Detection:** Checks for winning conditions in rows, columns, and diagonals. Displays a dialog box announcing the winner.
- **Draw Detection:** Detects a draw if all cells are filled without a winner.
- **Game Reset:** Offers an option to reset the game after a win or draw, allowing players to start a new game.
- **Exit Option:** Provides an option to exit the game if players do not wish to continue after a game ends.

### How to Run

1. **Compile the Code:** Ensure you have Java installed on your system. Compile the Java file using the `javac` command:
   ```sh
   javac Main.java
   ```
2. **Run the Application:** Execute the compiled class file with the `java` command:
   ```sh
   java Main
   ```

### Customization

- **Icon:** Update the path to the game icon in the `ImageIcon` constructor to use a custom icon for your application.
- **Colors and Fonts:** Modify the color and font settings in the code to suit your preferences.

### Dependencies

- Java Development Kit (JDK) 8 or later.

### Notes

- Ensure the path to the image file for the icon is correct.
- The game is designed for simplicity and does not use advanced object-oriented programming techniques or complex data structures.

Feel free to modify and enhance the game according to your needs!

---
