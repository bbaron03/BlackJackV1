package BlackJackFiles;

import java.util.Scanner;
public class Game
{
    public static void main(String[] args)
    {
        Scanner inputStr = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        boolean playAgain = true;
        Deck d1 = new Deck();

        int userWins = 0;
        int compWins = 0;

        while(playAgain)
        {

            Hand userHand = new Hand(new Card(), new Card());
            Hand computerHand = new Hand(new Card(), new Card());
            int userTotal = 0;
            int compTotal = 0;
            d1.shuffle();
            userTotal = userHand.sum();
            compTotal = computerHand.sum();
            System.out.println("\nUser hand: " + userHand.getHand(0) + ", " + userHand.getHand(1) + "| Total: " + userTotal );
            System.out.println("Computer Hand: " + computerHand.getHand(0) + ", ??");
            if(userHand.getHand(0).getValue() == 1)
                    {
                        System.out.println("You want that ace to be a 1 or an 11?");
                        int aceVal = inputNum.nextInt();
                        if(aceVal == 11){
                        userHand.getHand(0).changeValueAce();
                        userTotal = userHand.sum();
                        
                        }
                        System.out.println("Total: " + userTotal);
                    } 
            if(userHand.getHand(1).getValue() == 1)
                    {
                        System.out.println("You want that ace to be a 1 or an 11?");
                        int aceVal = inputNum.nextInt();
                        if(aceVal == 11){
                            userHand.getHand(1).changeValueAce();
                            userTotal = userHand.sum();
                            
                            
                        }
                        System.out.println("Total: " + userTotal);
                    } 
            
            while(userTotal < 22)
            {
                
                if(userTotal == 21)
                {
                    System.out.println("Blackjack!");
                    break;
                }
                System.out.println("\nHit or Stand?: ");
                String userInput = inputStr.nextLine();
                if(userInput.equalsIgnoreCase("hit"))
                {
                    userHand.addCard(d1.getCard());

                    System.out.println("You pulled a(n) " + userHand.getLastCard());
                    
                    if(userHand.getLastCard().getValue() == 1)
                    {
                        System.out.println("You want that ace to be a 1 or an 11?");
                        int aceVal = inputNum.nextInt();
                        if(aceVal == 11)
                            userHand.getLastCard().changeValueAce();

                    } 
                    userTotal = userHand.sum();
                    
                    System.out.println("Total: " + userTotal);

                }
                else
                    break;
            }
            System.out.println("\nUser Hand: " + userHand + "| Total: " + userTotal);

            while(compTotal < 17 && userTotal < 22)
            {
                if(userTotal <22)
                computerHand.addCard(d1.getCard());
                compTotal = computerHand.sum();
            }
            if(compTotal < 21)
            {
                System.out.println("The computers final hand is " + computerHand);
            }
            else if(compTotal > 21)
            {
                System.out.println("The computer busted with a final hand of " + computerHand);
            }
            else
            {
                System.out.println("The computer got Blackjack with " + computerHand);
            }

            if((userTotal == 21 && compTotal == 21) || userTotal == compTotal)
            {
                System.out.println("It is a tie. Both of you got a(n) " + userTotal);
            }
            else if(userTotal > compTotal && userTotal <= 21)
            {
                System.out.println("User wins. User got a(n) " + userTotal + " while the computer got a(n) " + compTotal);
                userWins++;
            }
            else if(compTotal > userTotal && compTotal <= 21)
            {
                System.out.println("Computer wins. User got a(n) " + userTotal + " while the computer got a(n) " + compTotal);
                compWins++;
            }
            else if(compTotal > 21)
            {
                System.out.println("Computer busted with a(n) " + compTotal + ". User Win.");
                userWins++;
            }
            else
            {
                System.out.println("User busted with a(n) " + userTotal + ". Computer Win.");
                compWins++;
            }

            System.out.println("Want to play again(y/n): ");
            String inp = inputStr.nextLine();
            if(inp.equalsIgnoreCase("n"))
                playAgain = false;

        }
        System.out.println("Game Over.");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        inputStr.close();
        inputNum.close();
    }

}