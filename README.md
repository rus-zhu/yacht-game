# The Game of Yacht

## Terminology

Game has PLAYERs, each of whom have SCOREBOARD that contains ROLLs (yum) and SCORE and CATEGORYs
that are used/not yet used.
We know when a Game is over when all PLAYERs have filled all of their CATEGORYs in the SCOREBOARD.

## Next Steps

* Create a representation of a Game that stores the state of the Yacht Game,
  i.e., current score, which categories have been used, the rolls of the game, etc.

* From the UI have a way to create a Player, initially could just be anonymous and
  a new is created whenever a "Start Game" button is clicked.

## Game Flow

* Click "Enter Game Area" (creates a new Player)
  * Get Player NAME
  * Clear their "scoreboard"
* Start Yacht Game
  1. Roll Dice
  1. Choose a category for scoring
  1. Update score
  1. Repeat from 1. until no categories are left unassigned
  1. Show final score

## To Do

[X] Check that the score is being rendered as desired

[X] Refactor the YachtController category assignment code

[X] Add scoring for the remaining categories to Scoreboard (and ScoreCategory)

[X] Bounce back out a layer to front-end web to see what functionality we need next

[X] Full House validation broken (see disabled test)

[X]Add die selection (checkbox) to the UI to select the dice to "hold back" from a re-roll

[ ] Re-roll 1 or all 5 of the dice, up to 3 times per round
Rule: After 3 roll, must assign to a category

* Scenario: player rolls 6,6,3,2,1
  player holds 6,6 and re-rolls other 3 dice
  player rolls 6,5,4
  player holds 6,6,6 and re-roll other 2 dice
  player rolls 3,3
  dice roll to be assigned is now 6,6,6,3,3
  since that's all re-rolls allowed, must assign to category(e.g. Full House)

[ ] Constrain to only assign roll to category once per round

[ ] Need to reflect this constraint in the user interface

[ ] Game is over when all categories have been assigned

[ ] Add other scoring categories (should total 12 categories, which means 12 rounds):

* 3-of-a-kind scores sum of dice
* little straight(1-5) scores 30
* big straight(2-6) scores 30
* choice scores sum of dice, and Yacht(5-of-a-kind) scores 50

[] Change full house to score 25 (...)

[ ] Introduce "Die" as a value object (to replace Integer) 
