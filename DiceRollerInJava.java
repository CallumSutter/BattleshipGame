import java.util.Random;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;;
 
// dice roller java source code
// Also outputs the dice face as ASCII art

public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    static int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }, 
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } }, 
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, 
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } } };
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
        int count = 0;
        int TotalCount = 0;
        String name ="";

        StartMenu();
        if(Checker()){
            String design = design();
            name = playerName();
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

                        //Multiple dice can be rolled
                        System.out.println("How many Tetrahedral dice would you like to roll? Pick one, two or three" );
                        String  rollNum = scanner.nextLine();
                        switch(rollNum)
                        {
                            case "one": 
                            int resultTetra = dice.rollTetra();
                            System.out.println("dice face value: " + resultTetra);
                            TotalCount +=resultTetra;
                            dice.drawTetra(resultTetra);
                            count++;
                            break;

                            case "two":
                            int thisCount = 0;
                            int resultTetra1 = dice.rollTetra();
                            System.out.println("First dice face value: " + resultTetra1);
                            TotalCount +=resultTetra1;
                            thisCount += resultTetra1;
                            dice.drawTetra(resultTetra1);
                            count++;

                            int resultTetra2 = dice.rollTetra();
                            System.out.println("Second dice face value: " + resultTetra2);
                            TotalCount +=resultTetra2;
                            thisCount += resultTetra2;
                            dice.drawTetra(resultTetra2);
                            count++;
                            System.out.println("The total dice value this round is: " + thisCount);
                            break;
                            
                            case "three":
                            int thisCount1 = 0;
                            int resultTetra11 = dice.rollTetra();
                            System.out.println("First dice face value: " + resultTetra11);
                            TotalCount +=resultTetra11;
                            thisCount1 += resultTetra11;
                            dice.drawTetra(resultTetra11);
                            count++;

                            int resultTetra22 = dice.rollTetra();
                            System.out.println("Second dice face value: " + resultTetra22);
                            TotalCount +=resultTetra22;
                            thisCount1 += resultTetra22;
                            dice.drawTetra(resultTetra22);
                            count++;
                            
                            int resultTetra33 = dice.rollTetra();
                            System.out.println("Third dice face value: " + resultTetra33);
                            TotalCount +=resultTetra33;
                            thisCount1 += resultTetra33;
                            dice.drawTetra(resultTetra33);
                            count++;
                            System.out.println("The total dice value this round is: " + thisCount1);
                            break;

                            default: System.out.println("Invalid input.");
                            break;
                        }
                    }

                    //Rolls regular (6-sided square) dice
                    else if(selection.equalsIgnoreCase("R") || selection.equalsIgnoreCase("r"))
                    {
                        //Multiple dice can be rolled
                        System.out.println("How many Regular dice would you like to roll? Type one, two or three." );
                        String  rollNum = scanner.nextLine();
                        switch(rollNum)
                        {
                            case "one": 
                            int result = dice.roll();
                            System.out.println("dice face value: " + result);
                            TotalCount +=result;
                            rollAnimation(design);

                            dice.draw(result,design);
                            count++;
                            break;

                            case "two":
                            int roundCount = 0;
                            int result1 = dice.roll();
                            System.out.println("First dice face value: " + result1);
                            TotalCount +=result1;
                            roundCount += result1;
                            rollAnimation(design);

                            dice.draw(result1,design);

                            count++;

                            int result2 = dice.roll();
                            System.out.println("Second dice face value: " + result2);
                            TotalCount +=result2;
                            roundCount += result2;
                            rollAnimation(design);

                            dice.draw(result2,design);

                            count++;
                            System.out.println("The total dice value this round is: " + roundCount);
                            break;
                            
                            case "three":
                            int roundCount1 = 0;
                            int result11 = dice.roll();
                            System.out.println("First dice face value: " + result11);
                            TotalCount +=result11;
                            roundCount1 += result11;
                            rollAnimation(design);

                            dice.draw(result11,design);

                            count++;

                            int result22 = dice.roll();
                            System.out.println("Second dice face value: " + result22);
                            TotalCount +=result22;
                            roundCount1 += result22;
                            rollAnimation(design);

                            dice.draw(result22,design);

                            count++;
                            
                            int result33 = dice.roll();
                            System.out.println("Third dice face value: " + result33);
                            TotalCount +=result33;
                            roundCount1 += result33;
                            rollAnimation(design);

                            dice.draw(result33,design);

                            count++;
                            System.out.println("The total dice value this round is: " + roundCount1);
                            break;

                            default: System.out.println("Invalid input.");
                            break;
                        }
                    }
                    
                    System.out.println("The dice has rolled " + count + " times so far.");
                    System.out.println("Total Dice value " + TotalCount);
                    // print to txt
                    printToTxt(TotalCount,name);

                    continue;
                } else if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                    System.out.println("Bye! see you next time");
                    scanner.close();
                    return;
                } else if (input.equalsIgnoreCase("design")) {
                    design = design();
                }
                else {
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
    private static void draw(int value, String design) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print(design);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");

    }
    private static String design() {
        int designLength;
        String design;
        Scanner scannerDesign = new Scanner(System.in);
        do {
            // checks what character the user would like for their design

            System.out.print("Please select your wanted design: e.g (x, o, *):");
            design = scannerDesign.nextLine();
            designLength = design.length();
            if (designLength != 1) {
                System.out.println("Please only select one character as your design!");
            }
        } while (designLength != 1);
        
        return design;
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
    // provides animation of the dice rolling
    private static void rollAnimation(String design) {
        int count = 0;
        // pause time between each print is 100ms
        long sleepTime = 100;
        DiceRollerInJava  diceAnimation = new DiceRollerInJava();

        while (count < 10) {
            int result = diceAnimation.roll();
            draw(result, design);
            count++;
            // delay for the next print of the dice animation when rolling
            try {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            // clearing the current console output allowing to write over previous dice output
            // System.out.print("\033[F" + "\033[F" + "\033[F"+ "\033[F" + "\033[F" + "\033[\r");
            clearScreen();
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }

    public static void printToTxt(int TotalCount, String name){
        try {
            PrintWriter Writer = new PrintWriter("TotalCount.txt");
            Writer.print(name + " :");
            Writer.print(TotalCount);
            Writer.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
     
    }

    public static String playerName(){
        System.out.println("Please input your name : ");
        Scanner scanner = new Scanner(System.in);
        
        String name = scanner.nextLine();
        return name;
    }

}
