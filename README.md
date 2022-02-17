# TicTacToe_-PvP-
A simple console screen version of TicTacToe

### Functions:
 - main() - - - - - - Will choose a random first player and input their move,
                      will then use an if statement inside while loop to change players
 - gameOutput() - - - Will output the game board, a 2d char array
 - gameInput()- - - - Will check the player, then either input an X or O on the board
                      it will also check if the move is valid by calling .isValid()
 - isValid()  - - - - Will check a spot on the game board to see if it is occupied 
 - checkGame()- - - - Will check the the board for any winning lines, it will assign char 
                      to a string and then compare their values to "XXX" and "OOO", 
                      if equal it will stop the program and output the winner
