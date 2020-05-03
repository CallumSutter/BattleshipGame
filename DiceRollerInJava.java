import java.util.Random;
import java.util.Scanner;
 
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
        String design = design();

        // while (true) {
        //     int result = dice.roll();
        //     System.out.println("dice face value:" + result);
        //     dice.draw(result);
 
        //     System.out.println("Roll again? (type no to quit):");
        //     String input = scanner.nextLine();
        //     if (input.equalsIgnoreCase("n") || 
        //             input.equalsIgnoreCase("no")) {
        //         System.out.println("Bye!");
        //         scanner.close();
        //         return;
        //     }
        // }

        // change new logic that only receive the command if the command is roll or quit if other command is type there will be no result
        while (true) {
            System.out.println(
                    "What do you want to do ? (Type roll to play) (Type quit or exit to end the game) (Type design to change dice design)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("roll")) {
                int result = dice.roll();
                rollAnimation(design);
                System.out.println("Dice face value: " + result);
                dice.draw(result, design);
                count++;
                System.out.println("The dice has rolled " + count + " times");
                continue;
            } else if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                System.out.println("Bye! See you next time!");
                scanner.close();
                return;
            } else if (input.equalsIgnoreCase("design")) {
                design = design();
            } else {
                clearScreen();
            }
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
            System.out.print("\033[F" + "\033[F" + "\033[F"+ "\033[F" + "\033[F" + "\033[\r");
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }
}