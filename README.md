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

[ ] Categories can currently be assigned to multiple times,
need to constrain to only once per category per round

[] Need to reflect this constraint in the user interface

[ ] Introduce "Die" as a value object (to replace Integer) 
