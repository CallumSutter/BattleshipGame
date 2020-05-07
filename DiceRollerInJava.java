import java.util.Random;
import java.util.Scanner;
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
        int TotalCount = 0;

        while(true){
            System.out.println("What do you want to do ? (type roll to play) (type quit or exit to end the game) ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("roll")){
                int result = dice.roll();
                System.out.println("dice face value: " + result);
                dice.draw(result);
                count++;
                TotalCount += result;
                System.out.println("The dice has rolled " + count + " times");
                System.out.println("The total Count so far is:" + TotalCount);
                
                //This try and catch method will grab the value of Total Count and then print it to the designated file
                printToTxt(TotalCount);
                continue;
            }
             else if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")){
                System.out.println("Bye! see you next time");
                scanner.close();
                return;
            } 
            else{
                clearScreen();
            }
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


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }

    public static void printToTxt(int TotalCount){
        try {
            PrintWriter Writer = new PrintWriter("TotalCount.txt");
            Writer.print(TotalCount);
            Writer.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
     
    }
}
