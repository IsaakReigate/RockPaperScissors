package rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {

        int score = 0;
        int botScore = 0;

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean gameLoop = true;
        boolean checkRPS = false;
        String humanAnswer = "rock";
        String botAnswer = "rock";
        int botAnswerNumber;

        while (gameLoop == true) {
            //Asks for user answer, if the answer is not rock, paper or scissors, asks again.
            while (checkRPS == false) {
                try {
                    System.out.println("Enter rock, paper or scissors: ");
                    humanAnswer = scan.next();
                    if (humanAnswer.equalsIgnoreCase("rock")) {
                        break;
                    } else {
                        if (humanAnswer.equalsIgnoreCase("paper")) {
                            break;
                        } else {
                            if (humanAnswer.equalsIgnoreCase("scissors")) {
                                break;
                            } else {
                                System.out.println("Please enter a valid answer.");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }

//Uses random number from 0-2 to allocate bot with rock, paper or scissors.
            botAnswerNumber = rand.nextInt(3);
            if (botAnswerNumber == 0) {
                botAnswer = "rock";
            }
            if (botAnswerNumber == 1) {
                botAnswer = "paper";
            }
            if (botAnswerNumber == 2) {
                botAnswer = "scissors";
            }
            System.out.println("The bot says: "+botAnswer);

//Checks who wins.
            if (botAnswer.equalsIgnoreCase(humanAnswer)) {
                System.out.println("Tie! No one gets any points!\n");
            } else {
                if ((humanAnswer.equalsIgnoreCase("rock") && botAnswer.equalsIgnoreCase("scissors")) || (humanAnswer.equalsIgnoreCase("paper") && botAnswer.equalsIgnoreCase("rock") || (humanAnswer.equalsIgnoreCase("scissors") && botAnswer.equalsIgnoreCase("rock")))) {
                    System.out.println("You won!\n");
                    score++;
                } else {
                    System.out.println("You lost!\n");
                    botScore++;
                }

            }

//print scores
            System.out.println("Your score is: " + score);
            System.out.println("The bot's score is: " + botScore+"\n");

        }
    }

}
