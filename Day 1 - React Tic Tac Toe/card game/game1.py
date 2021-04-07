# Deck of cards
import random

# Deck generator
def generate_deck():
    # suits
    suits = ['hearts', 'spades', 'clubs', 'diamonds']
    
    # numbers/types
    ranks = ['ace', 'two', 'three', 'four', 'five', 'six',
             'seven', 'eight', 'nine', 'ten', 'jack', 'queen',
             'king']
    
    # generate all cards
    # nested for loop
    deck = []
    for ix in range(len(ranks)):
        for suit in suits:
            rank = ranks[ix]
            value = ix + 1;
            deck.append(rank, suit, value)
    
    return deck
    
# 
if __name__ == "__main__":
    print(random.choice(generate_deck()))