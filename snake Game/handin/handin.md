# The First Bug

- what is the name of the variable on line 98 of the `SnakeGame` class whose value is `null`? `snake` 


- what change did you make to fix the bug that caused the `NullPointerException`
- I changed the line `new  Snake(new Cell(BOARD_ROWS / 2, BOARD_COLS / 2)); ` to `snake = new  Snake(new Cell(BOARD_ROWS / 2, BOARD_COLS / 2));` 


# The Remaining Four Bugs

First provide your answer to each of the following questions:

- when the game first starts, is the colour of the food green, as expected? no  

- every time the game starts, is the food placed at a random location on the board? no it's always at the same position 

- when you repeatedly try to rotate the snake's head counter-clockwise by pressing the left arrow key - does it behave as expected? yes it does. It rotates 90 degrees counter-clockwise with each key press 

- when you repeatedly try to rotate the snake's head clockwise by pressing the right arrow key - does it behave as expected? no it does not move correctly

- does the game end when the snake runs off the edge of the board? yes it does, the snake disappears. 



## Bug 1

- Briefly describe the bug. How does it manifest itself when the program runs?: the colour of the food is red not green indiciating that it has no nutritional value. 

- What is your hypothesis / hypotheses for the cause of this bug: 
1) the nutritional value assigned to the food when it is constructed is not correct
2) The nutritional value field is being changed somewhere, when it is not supposed to be 

- Where did you set a breakpoint when debugging the code?  If you set more than one, list all of them. 
AND/OR 
- What test method names, if any, assisted you in determining where to find the bug? The `testConstructor()` failed in the `FoodTest()` class. 

- What did you do to fix the bug (include the class name and line number(s))? I read the error that said `exptected [100] but found [0]` for the failing test so I went to the `Food.java` calss and found the `Food()` constructor (the first one). I saw that the `EFFECTS` clause said that the food has INITIAL_NUTRITIONAL_VALUE but it was set to 0. I changed line number: 
1) Line 14: I changed `nutritionalValue = 0;` to `nutritionalValue = INITIAL_NUTRITIONAL_VALUE`   


## Bug 2

- Briefly describe the bug. How does it manifest itself when the program runs?: The food is never placed at a random location, it is always in the same position on the board even if it gets eaten 

- What is your hypothesis / hypotheses for the cause of this bug:
1) The position of the food is not being gotten correctly 
2) The position of the food is not being updated correctly 

- Where did you set a breakpoint when debugging the code?  If you set more than one, list all of them. 
AND/OR
- What test method names, if any, assisted you in determining where to find the bug? I saw that the `testNewFoodCreatedWhenEaten()` was failing but the error message was not very hepfull so I set a breakpoint in the `SnakeGame.java` class on line number 95. It showed me that `position` was randomized and gotten correctly (so H1 is wrong), but food was always being updated to `Cell@47` and not the `position`. (H2 is correct)

- What did you do to fix the bug (include the class name and line number(s))? I went to the `SnakeGame.java` class and I went down to the `createFood()` method. I changed the following lines of code: 
1) Line 99: I changed `food = new Food(new Cell(BOARD_ROWS / 4, BOARD_COLS / 4)); ` to `food = new Food(position);` 


## Bug 3

- Briefly describe the bug. How does it manifest itself when the program runs?: when you press the right arrow key the snake does not move clockwise 90 degrees correcrtly it moves in the wrong directions 

- What is your hypothesis / hypotheses for the cause of this bug:
1) when pressing the right arrow key the direction to move to is not being updated correctly

- Where did you set a breakpoint when debugging the code?  If you set more than one, list all of them. 
AND/OR
- What test method names, if any, assisted you in determining where to find the bug? the test method `testRotateSnakeRight()` didnt pass and that helped me identify the issue. I didn't set a breakpoint because the issue was obvious to me after seeing where the test was failing.

- What did you do to fix the bug (include the class name and line number(s))? I went to the `Snake.java` class and looked at the `rotateright() method` and then updated the directions to the correct ones. I changes the following lines of code: 
1) line 78 : `direction = Direction.LEFT;` changed to `direction = Direction.RIGHT;`

## Bug 4

- Briefly describe the bug. How does it manifest itself when the program runs?: the snake does not grow when its nurtitional value has reached the value it requires to grow 

- What is your hypothesis / hypotheses for the cause of this bug:
1) The method to grow the snake is not being called correctly 
2) The method to grow the snake is not increasing the length of the snake 
3) the method to grow the snake is not updating to the the correct length 

- Where did you set a breakpoint when debugging the code?  If you set more than one, list all of them. 
AND/OR
- What test method names, if any, assisted you in determining where to find the bug? The `testMoveBody()` test failed. I went to the `Snake.java()` class and set a breakpoint at line 100.

- What did you do to fix the bug (include the class name and line number(s))?  I noticed that the length of the snake is increased regardless from the beginning so hypothesis 1 and 2 is wrong. I realized that the issue was in the `canGrow()` method of the the `Snake.java()` class. I changed the following line of code 
1) Line 111 : I changed `return nutritionConsumed == NUTRITION_TO_GROW;` to  `return nutritionConsumed >= NUTRITION_TO_GROW;`



