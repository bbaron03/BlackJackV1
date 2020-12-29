package BlackJackFiles;

public class Card
{

    private String suit, valueName;
    private int value;
    private final String  SPADE_SYM = "♠";
    private final String  HEART_SYM = "♡";
    private final String  DIAMOND_SYM = "♢";
    private final String  CLUB_SYM = "♣";
    private boolean isInDeck;

    public Card()
    {
        int suitNum = (int)(Math.random() * 4 + 1);
        if(suitNum == 1)
            suit = "spades";
        else if(suitNum ==2)
            suit = "clubs";
        else if(suitNum == 3)
            suit = "hearts";
        else
            suit = "diamonds";
        value = (int)(Math.random() * 13 + 1);
        if(value > 10)
        {
            if(value == 11)
            {valueName = "jack";
            this.value = 10;}
            else if(value == 12)
            {valueName = "queen";
            this.value = 10;}
            else
            {valueName = "king";
            this.value = 10;}
        }
        else if(value == 1)
            valueName = "ace";
        else 
            valueName = value + "";

        isInDeck = true;
    }

    public Card(String suit)
    {
        this.suit = suit;
        value = (int)(Math.random() * 13 + 1);
        if(value > 10)
        {
            if(value == 11)
            {valueName = "jack";
            this.value = 10;}
            else if(value == 12)
            {valueName = "queen";
            this.value = 10;}
            else
            {valueName = "king";
            this.value = 10;}
        }
        else if(value == 1)
            valueName = "ace";
        else 
            valueName = value + "";

        isInDeck = true;
    }

    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
        if(value > 10)
        {
            if(value == 11)
            {valueName = "jack";
            this.value = 10;}
            else if(value == 12)
            {valueName = "queen";
            this.value = 10;}
            else
            {valueName = "king";
            this.value = 10;}
        }
        else if(value == 1)
            valueName = "ace";
        else 
            valueName = value + "";

        isInDeck = true;
    }

    public Card(int suitNumx, int value)
    {
        int suitNum = (int)(Math.random() * 4 + 1);
        if(suitNum == 1)
            suit = "spades";
        else if(suitNum ==2)
            suit = "clubs";
        else if(suitNum == 3)
            suit = "hearts";
        else
            suit = "diamonds";

        this.value = value;
        if(value > 10)
        {
            if(value == 11)
            {valueName = "jack";
            this.value = 10;}
            else if(value == 12)
            {valueName = "queen";
            this.value = 10;}
            else
            {valueName = "king";
            this.value = 10;}
        }
        else if(value == 1)
            valueName = "ace";
        else 
            valueName = value + "";

        isInDeck = true;
    }

    // accessors
    public String getSuit()
    {return suit;}

    public int getValue()
    {return value;}

    public String getValueName()
    {return valueName;}

    public boolean isCardInDeck()
    {return isInDeck;}

    public void changeStatus()
    {
        isInDeck = !isInDeck;
    }

    public void changeValueAce()
    {
        if(value == 1)
        {
            value = 11;
        }
        
    }

    public String toString()
    {
        if(suit.equals("diamonds"))
            return "|" + DIAMOND_SYM + " " + valueName + "|";
        else if(suit.equals("hearts"))
            return "|" + HEART_SYM + " " + valueName + "|";
        else if(suit.equals("spades"))
            return "|" + SPADE_SYM + " " + valueName + "|";
        else
            return "|" + CLUB_SYM + " " + valueName + "|";
    }


}