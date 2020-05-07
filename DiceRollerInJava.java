import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
 
// dice roller java source code
// Also outputs the dice face as ASCII art

public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }, 
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } }, 
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, 
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } } };
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
        int count = 0;
        StartMenu();
        if(Checker()){
            while(true){
                System.out.println("What do you want to do ? (type roll to play) (type quit or exit to end the game) ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("roll")){
                    System.out.println();
    
                    //Gets type of dice to be rolled from user
                    System.out.println("What type of dice would you like to roll? Terahedral/Regular?");
                    System.out.println("Please insert T or R.");
                    String selection = scanner.nextLine();
    
                    //Rolls tetrahedral (4-sided triangular) dice
                    if(selection.equalsIgnoreCase("T") || selection.equalsIgnoreCase("t"))
                    {
                        System.out.println("You have selected Tetrahedral!");
                        int resultTetra = dice.rollTetra();
                        System.out.println("dice face value: " + resultTetra);
                        dice.drawTetra(resultTetra);
                        count++;
                    }
                    //Rolls regular (6-sided square) dice
                    else if(selection.equalsIgnoreCase("R") || selection.equalsIgnoreCase("r"))
                    {
                    int result = dice.roll();
                    System.out.println("dice face value:" + result);
                    dice.draw(result);
                    count++;
                    }
    
                    System.out.println("The dice has rolled " + count + " times");
                    continue;
                } else if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")){
                    System.out.println("Bye! see you next time");
                    scanner.close();
                    return;
                } else{
                    clearScreen();
                }
            }
        } else {
            System.out.println("Bye! see you next time");
            scanner.close();
            return;
        }
        
        
    }

    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");

    }

    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
    
    private int rollTetra()
    {
        Random r = new Random();
        return r.nextInt(4)+1;
    }

    //Draw the tetrahedral dice using ascii characters
    private void drawTetra(int v)
    {
        System.out.println("    ^ ");            
        System.out.println("  / "+v+" \\");          
        System.out.println(" /     \\");
        System.out.println("/"+v+"     "+v+"\\");
        System.out.println("---------");                       
    }

    private static void StartMenu() {
    
        System.out.println("-- Dice Roller Game --");
        // Display the menu
        System.out.println("1\t Start Game");
        System.out.println("2\t Quit Game");
        System.out.println("Please enter your choice:");
            
        
    }
    private static boolean Checker(){
        Scanner in = new Scanner(System.in);
        int getUserInput;
        while(true){
            getUserInput = in.nextInt();
            if (getUserInput == 1 || getUserInput == 2){
                break;
            } else {
            System.out.println("Please make a valid entry");
            }
        }
        if(getUserInput == 1){
            return true;
        } else {
            return false;
        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }


}

