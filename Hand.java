package BlackJackFiles;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;


    public Hand(Card c1, Card c2)
    {
        hand = new ArrayList<Card>();
        hand.add(c1);
        hand.add(c2);
    }
    //precondition: Index is within the range of the hand
    public Card getHand(int index)
    {return hand.get(index);}

    public Card getLastCard()
    {return hand.get(hand.size() -1);}

    public int sum()
    {
        int sum = 0;
        for(Card c: hand)
        {
            sum += c.getValue(); 
        }
        return sum;
    }

    public void addCard(Card c)
    {
        hand.add(c);
    }

    public void clearHand()
    {
        int index = 0;
        while(hand.size() > 0)
        {
            hand.remove(index);
        }
    }

    public String toString()
    {
        String totString = "";

        for(int i = 0; i < hand.size();i++)
        {
            if(i < hand.size() - 1)
            totString += hand.get(i) + ", ";
            else
            totString += hand.get(i);
        }

        return totString;
    }
}