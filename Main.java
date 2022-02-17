/*
    Notes: make the winner function and update gameOver in the main fucntion 

    functions:  - main() - - - - - - Will choose a random first player and input move,
                                     will then use an if statement inside while loop to change players
                                     . . .
                                     the cond for the while loop is gameOver, is not updated yet
                - gameOutput() - - - Will output the game board
                - gameInput()- - - - Will check the player, then either input an X or O on the board
                                     it will also check if the move is valid by calling .isValid()
                - isValid()  - - - - As of right now the function works but . . . after input is corrected 
                                     multiple boards are output
                - checkGame()- - - - Will grab the value of "winning" chars on the board, assign them to 
                                     a string and then compare their values to "XXX" and "OOO", 
                                     if equal it will stop the program and output the winner

*/

import java.util.*;

class Main
{
  // create scanner obj
  static Scanner console = new Scanner(System.in);


  /////////////////
  // main function
  ////////////////
  public static void main(String[] args) 
  {
    //create char 2d array for gameBoard
    char gameArray[][] = {{' ', '|', ' ', '|', ' '},
                          {'-', '+', '-', '+', '-'},
                          {' ', '|', ' ', '|', ' '},
                          {'-', '+', '-', '+', '-'},
                          {' ', '|', ' ', '|', ' '} };
    
    // print out the gameBoard
    System.out.println("-------------");
    System.out.println(" Tic Tac Toe ");
    System.out.println("-------------");
    gameOutput(gameArray);

    // choose 1st player 
    Random rand = new Random();
    int firstPlayer = rand.nextInt(2); // rand 1 or 0
    String player = (firstPlayer == 1) ? "Player X" : "Player O";
    System.out.println("--- "+player+" goes first ---");
    
    gameInput(gameArray, player); // get 1st players input

    // while loop to keep game going
    boolean gameOver = false;
    while (gameOver != true)
    {
      // get second players input (player will change each time)
      if(player.equals("Player X")){
        player = "Player O";
        System.out.println("--- Player O's Turn ---");
        gameInput(gameArray, player);

        gameOver = checkGame(gameArray);}   // update condition
        if(gameOver == true)
            break;
        
      else if(player.equals("Player O")){
        player = "Player X";
        System.out.println("--- Player X's Turn ---");
        gameInput(gameArray, player);

        gameOver = checkGame(gameArray);} // update condition
        if(gameOver == true)
            break;

    }
    
    console.close();
  }// end of main

  
  ////////////////
  // Game Output
  ////////////////
  static public void gameOutput(char array[][])
  {
    // step through row then col
    for(int y = 0; y < array.length; y++){
      for(int x = 0; x < array[y].length; x++){
        System.out.print(array[y][x] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }// end of gameOutput
    
  
  //////////////////
  // gameInput (will call .isValid())
  //////////////////
  static public void gameInput(char array[][], String player)
  {
    // prompt input
    System.out.print("Enter a place (1-9): ");
    int choice = console.nextInt();
    System.out.println();
    
    char symbol = ' '; // declare char var
    
    // assign val to symbol
    if(player.equals("Player X")){
      symbol = 'X';
      System.out.println("Player X's Move: ");
      System.out.println("--------------");
    }
    else if(player.equals("Player O")){
      symbol = 'O';
      System.out.println("Player O's Move: ");
      System.out.println("--------------");
    }

    // place player symbol on board/gameArray
    switch(choice)
    {
      case 1: if(isValid(array, 1) == true)
                array[0][0] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;
                
      case 2: if(isValid(array, 2) == true)
                array[0][2] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 3: if(isValid(array, 3) == true)
                array[0][4] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 4: if(isValid(array, 4) == true)
                array[2][0] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 5: if(isValid(array, 5) == true)
                array[2][2] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 6: if(isValid(array, 6) == true)
                array[2][4] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 7: if(isValid(array, 7) == true)
                array[4][0] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 8: if(isValid(array, 8) == true)
                array[4][2] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      case 9: if(isValid(array, 9) == true)
                array[4][4] = symbol;
              else{
                System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);}
              break;

      default:  System.out.println("-- INVALID MOVE TRY AGAIN --");
                gameInput(array, player);
                break;
    }

    // output board
    gameOutput(array);
  }// end of gameOutput

  
  ////////////
  // isValid
  ////////////
  static public boolean isValid(char array[][], int choice)
  {
   switch(choice)
    {
      case 1: 
        //boolean temp = array[0][0] == ' ';  // for testing purposes
        //System.out.println(temp);
        return (array[0][0] == ' ');
        
      case 2: return (array[0][2] == ' ');
        
      case 3: return (array[0][4] == ' ');
        
      case 4: return (array[2][0] == ' ' );
        
      case 5: return (array[2][2] == ' ');
       
      case 6: return (array[2][4] == ' ');
       
      case 7: return (array[4][0] == ' ');
        
      case 8: return (array[4][2] == ' ');
        
      case 9: return (array[4][4] == ' ');
       
      default: return false;
  
    }

  }// end of isValid()

  
  /////////////
  // checkGame 
  /////////////
  public static boolean checkGame(char array[][])
  {
    
    // check for winning positions
    String tempStr;
      
      // get board values
      char one = array[0][0];
      char two = array[0][2];
      char three = array[0][4];
      char four = array[2][0];
      char five = array[2][2];
      char six = array[2][4];
      char seven = array[4][0];
      char eight = array[4][2];
      char nine = array[4][4];

      //System.out.println(one + " " + two + " " + three + " " + four + " " + five+ " " + six + " " + seven + " " + eight + " " + nine);
    
    // for loop to check each winning line
    for(int i = 0; i < 8; i++)
    {
      tempStr = " "; // initialize tempLine
      
      switch(i) // assign value of char to tempStr
      {
        case 0: // top line <>
          tempStr = Character.toString(one) + Character.toString(two) + Character.toString(three);
          //System.out.println(tempStr);
          break;
        case 1: // middle line <>
          tempStr =  Character.toString(four) + Character.toString(five) + Character.toString(six);
          break;
        case 2: // bottom line <>
          tempStr =  Character.toString(seven) + Character.toString(eight) +Character.toString(nine);
          break;
        case 3: // left line ^v
          tempStr =  Character.toString(one) + Character.toString(four) + Character.toString(seven);
          break;
        case 4: // middle line ^v
          tempStr =  Character.toString(two) + Character.toString(five) + Character.toString(eight);
          break;
        case 5: // right line ^v
          tempStr =  Character.toString(three) + Character.toString(six) + Character.toString(nine);
          break;
        case 6: // diagonal line 1
          tempStr =  Character.toString(one) + Character.toString(five) + Character.toString(nine);
          break;
        case 7: // diagonal line 2
          tempStr =  Character.toString(three) + Character.toString(five) + Character.toString(seven);
          break;
      }

      // check if tempLine is a win for the human
      if(tempStr.equals("XXX")){
        //System.out.println(tempStr); // for testing purposes
        System.out.println("--- Player X Won ---");
        return true;}
      // check if tempLin is a win for the CPU
      if(tempStr.equals("OOO")){
        //System.out.println(tempStr); // for testing
        System.out.println("--- Player O Won ---");
        return true;}

    }

  return false;

  }// end of checkGame
  

}// end of class Main