# AZ-Holdem

AZ-Holdem is a Java-based simulation of Texas Hold'em poker, designed to model and simulate poker gameplay with a focus on card handling, player interaction, and game logic. This project provides a foundational framework for simulating Texas Hold'em, allowing for further development and customization.

# Features
- Card and Deck Management: Classes for handling cards (Card.java), card decks (CardDeck.java), and shuffling.
- Player Logic: The Player.java class manages player attributes, including hand management and decision-making.
- Game Simulation: The Game.java class controls the flow of the Texas Hold'em game, managing rounds, betting, and determining the winner.
- Poker Hand Evaluation: The PokerHand.java class evaluates and compares poker hands, determining the strongest hand according to Texas Hold'em rules.
- Unit Testing: Comprehensive unit tests are included to ensure the functionality of the card, player, and game logic (CardTest.java, PlayerTest.java, GameTest.java, PokerHandTest.java).

# Installation
To install and run AZ-Holdem, clone the repository and compile the Java files:

git clone https://github.com/EduardoRamonHernandez/AZ-Holdem.git
cd AZ-Holdem
javac *.java

# Usage
To start a game of AZ-Holdem, run the Main class after compiling the project:

java Main

# Classes Overview
Card.java: Represents a playing card with a suit and rank.
CardDeck.java: Manages a deck of cards, including shuffling and drawing cards.
Player.java: Represents a player in the game, managing their hand and actions.
Game.java: Controls the overall game flow, including betting rounds and determining the winner.
PokerHand.java: Evaluates the strength of poker hands and compares them to determine the winning hand.
Rank.java and Suit.java: Enumerations that define the possible ranks and suits of a card.

# Testing
To run the unit tests, use a Java testing framework like JUnit. The provided test classes (CardTest.java, PlayerTest.java, GameTest.java, PokerHandTest.java) cover essential functionality to ensure the game operates correctly.

# Contributing
Contributions are welcome! If you have suggestions, bug fixes, or improvements, please feel free to submit a pull request or open an issue.

# License
This project is licensed under the MIT License. See the LICENSE file for more details.

# Contact
For any questions or support, please contact Eduardo Hernandez.
