# APCSa-Final-Project# Casino Games Project

This project is a Java-based casino game application that includes two games: **War** and **Blackjack**. The application features a graphical user interface (GUI) for game selection and gameplay, allowing players to enjoy card games with visual feedback.

---

## Features
- **War**:
  - Players draw a card, and the opponent draws a card.
  - The higher card wins, and chips are awarded or deducted based on the result.
  - Includes ASCII art representation of cards for visual feedback.
  - Option to play again, return to the menu, or exit after each round.

- **Blackjack**:
  - Players can "Hit" to draw more cards or "Stay" to end their turn.
  - The goal is to get as close to 21 as possible without exceeding it.
  - Dealer automatically draws cards until reaching 17 or higher.
  - Aces are dynamically valued as 1 or 11 based on the hand's total value.

- **Graphical User Interface (GUI)**:
  - Menu to select games or exit the application.
  - Visual display of cards and game results using `JOptionPane`.

---

## How to Run
1. **Clone or Download the Repository**:
   - Clone the repository or download the project files to your local machine.

2. **Compile the Project**:
   - Ensure you have Java installed on your system.
   - Compile all `.java` files using the following command:
     ```bash
     javac *.java
     ```

3. **Run the Application**:
   - Run the `GameGUI` class to start the application:
     ```bash
     java GameGUI
     ```

4. **Play the Games**:
   - Use the menu to select either "War" or "Blackjack."
   - Follow the on-screen instructions to play.

---

## Project Structure
- **Card.java**:
  - Represents a playing card with a rank, suit, and value.
  - Includes methods to calculate card values and display card details.

- **Deck.java**:
  - Represents a standard 52-card deck.
  - Includes methods to shuffle and draw cards.

- **Player.java**:
  - Represents a player with a name and chip balance.
  - Includes methods to add or subtract chips.

- **War.java**:
  - Implements the War card game logic.
  - Displays results and allows players to play again or return to the menu.

- **Blackjack.java**:
  - Implements the Blackjack game# Casino Games Project

This project is a Java-based casino game application that includes two games: **War** and **Blackjack**. The application features a graphical user interface (GUI) for game selection and gameplay, allowing players to enjoy card games with visual feedback.

---

## Features
- **War**:
  - Players draw a card, and the opponent draws a card.
  - The higher card wins, and chips are awarded or deducted based on the result.
  - Includes ASCII art representation of cards for visual feedback.
  - Option to play again, return to the menu, or exit after each round.

- **Blackjack**:
  - Players can "Hit" to draw more cards or "Stay" to end their turn.
  - The goal is to get as close to 21 as possible without exceeding it.
  - Dealer automatically draws cards until reaching 17 or higher.
  - Aces are dynamically valued as 1 or 11 based on the hand's total value.

- **Graphical User Interface (GUI)**:
  - Menu to select games or exit the application.
  - Visual display of cards and game results using `JOptionPane`.

---

## How to Run
1. **Clone or Download the Repository**:
   - Clone the repository or download the project files to your local machine.

2. **Compile the Project**:
   - Ensure you have Java installed on your system.
   - Compile all `.java` files using the following command:
     ```bash
     javac *.java
     ```

3. **Run the Application**:
   - Run the `GameGUI` class to start the application:
     ```bash
     java GameGUI
     ```

4. **Play the Games**:
   - Use the menu to select either "War" or "Blackjack."
   - Follow the on-screen instructions to play.

---

## Project Structure
- **Card.java**:
  - Represents a playing card with a rank, suit, and value.
  - Includes methods to calculate card values and display card details.

- **Deck.java**:
  - Represents a standard 52-card deck.
  - Includes methods to shuffle and draw cards.

- **Player.java**:
  - Represents a player with a name and chip balance.
  - Includes methods to add or subtract chips.

- **War.java**:
  - Implements the War card game logic.
  - Displays results and allows players to play again or return to the menu.

- **Blackjack.java**:
  - Implements the Blackjack game
