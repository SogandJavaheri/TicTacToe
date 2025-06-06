# TicTacToe
# Tic Tac Toe – Java OOP Console Game

## 🎮 Overview  
This is a **two-player Tic Tac Toe game** implemented in Java using an **object-oriented design**. The game is played in the console and includes full turn-based logic, board rendering, win/draw detection, and clean code structure with multiple classes.

It's designed to demonstrate practical OOP principles such as **encapsulation**, **class responsibilities**, and **modularity**, making it a solid example of clean and maintainable Java code.

---

## 🧠 OOP Structure

| Class             | Responsibility                                          |
|------------------|----------------------------------------------------------|
| `TicTacToeGame`   | Main class for managing game flow and interactions      |
| `Board`           | Handles board state, rendering, and win/draw checking   |
| `Player`          | Represents each player (name, symbol)                   |
| `Move` *(optional)* | Represents a player's move (row, col)                   |

---

## ✨ Features  
- Clean separation of concerns via multiple classes  
- 3×3 grid with automatic display updates  
- Turn-based logic for Player X and O  
- Win, draw, and invalid input handling  
- Easy to expand into GUI or AI modes

---

## 🔧 Technologies Used  
- **Java** (JDK 8 or above)  
- OOP principles (encapsulation, modularity)  
- Console I/O

---

## 🚀 How to Run  
```bash
git clone https://github.com/SogandJavaheri/tic-tac-toe-java.git
cd tic-tac-toe-java
javac *.java
java TicTacToeGame
