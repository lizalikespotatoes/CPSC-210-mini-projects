package ca.ubc.cs.cpsc210.snake.model;

import java.util.*;

// Represents a game of snake played on a board of size BOARD_ROWS * BOARD_COLS with
// row number increasing from top to bottom and column number increasing from
// left to right.
public class SnakeGame {
    public static final int BOARD_COLS = 19;
    public static final int BOARD_ROWS = 11;

    private Random randomNumberGenerator;
    private Snake snake;
    private Food food;

    // EFFECTS: snake is at centre of board and food is at a random cell on board
    public SnakeGame() {
        randomNumberGenerator = new Random();
        snake = new  Snake(new Cell(BOARD_ROWS / 2, BOARD_COLS / 2));  
        createFood();
    }

    // REQUIRES: !isOver()
    // MODIFIES: this
    // EFFECTS:  move snake and decay food; if snake head is at food position, eat food and
    //           create new food at random location
    public void update() {
        snake.move();
        food.decay();
        if (canSnakeEat()) {
            snake.eat(food);
            createFood();
        }
    }

    public Cell getSnakeHeadPosition() {
        return snake.getPosition();
    }

    public List<Cell> getSnakeBodyPositions() {
        return snake.getBodyPositions();
    }

    public Direction getSnakeDirection() {
        return snake.getDirection();
    }

    public int getSnakeLength() {
        return snake.length();
    }

    public Cell getFoodPosition() {
        return food.getPosition();
    }

    public int getFoodNutritionalValue() {
        return food.getNutritionalValue();
    }

    public int getSnakeNutritionConsumed() {
        return snake.getNutritionConsumed();
    }

    // MODIFIES: this
    // EFFECTS:  rotate snake head 90 degrees to left
    public void rotateSnakeLeft() {
        snake.rotateLeft();
    }

    // MODIFIES: this
    // EFFECTS:  rotate snake head 90 degrees to right
    public void rotateSnakeRight() {
        snake.rotateRight();
    }

    // EFFECTS: returns true if game is over
    public boolean isOver() {
        return snake.selfIntersects() || !isInBounds(snake.getPosition());
    }

    // EFFECTS: returns true if cell is in bounds of game
    private boolean isInBounds(Cell cell) {
        return cell.getColumn() >= 0 && cell.getColumn() < BOARD_COLS
                && cell.getRow() >= 0 && cell.getRow() < BOARD_ROWS;
    }

    // EFFECTS: returns true if snake can eat
    private boolean canSnakeEat() {
        return snake.getPosition().equals(food.getPosition());
    }

    // MODIFIES: this
    // EFFECTS: updates food with new food at a random location other than location of snake's head
    private void createFood() {
         Cell position = randomCell();

        // generate a new position at a random location that is not equal to the snake's current position 
        while (position.equals(snake.getPosition())) {
            position = randomCell();
        }

        food = new Food(position); 
    }

    // EFFECTS: returns a cell at a randomly chosen location on the board
    private Cell randomCell() {
        return new Cell(randomNumberGenerator.nextInt(BOARD_ROWS), randomNumberGenerator.nextInt(BOARD_COLS));
    }
}
