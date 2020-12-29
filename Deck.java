package BlackJackFiles;

import java.util.ArrayList;
public class Deck
{
    private ArrayList<Card> deck;

    public Deck()
    {
        deck = new ArrayList<Card>();
        for(int i = 0; i < 52; i++)
        {
            deck.add(i , new Card((i + 1) % 4, i + 1 % 13));
        }
        shuffle();
    }

    //Searches for a random card that is in the deck
    public Card getCard()
    {
        int i = 0;
        while(true)
        {
            if(deck.get(i).isCardInDeck())
            {
                deck.get(i).changeStatus();
                return deck.get(i);
            }
            else
            i++;
        }
        //Will never occur unless the whole deck in empty
        
    }

    //returns null if the card is not in the deck
    public Card getCard(int index)
    {
        boolean cardInDeck = deck.get(index).isCardInDeck();
        if(cardInDeck)
        {
            deck.get(index).changeStatus();
            return deck.get(index);
        }
        return null;

    }
    //resets in deck values and swaps cards randomly
    public void shuffle()
    {
        for(int i = 0; i < deck.size(); i++)
        {
            if(deck.get(i).isCardInDeck() == false)
                deck.get(i).changeStatus();
        }
        for(int i = 0; i < deck.size(); i++)
        {
            Card temp = deck.remove((int)(Math.random() * deck.size()));
            deck.add((int)(Math.random() * deck.size()), temp);
        }
    }
}