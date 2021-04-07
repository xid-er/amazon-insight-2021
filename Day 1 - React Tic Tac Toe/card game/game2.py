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
    
def is_prime(n):
    for i in range(sqrt(n)):
        if n % i == 0:
            return True
    return False
    
# 
if __name__ == "__main__":
    print(random.choice(generate_deck()))
    
    
# Prime card game 

deck = generate_deck()

won = False

while (not won or len(deck) == 0):
    print("Draw a card!")
    drawn_cards = []
    sum = 0
    turn_counter = 0
    while (turn_counter < 3 and len(deck) > 1):
        input()
        drawn = random.choice(deck)
        print("You drew " + drawn[0] + ' of ' + drawn[1] +'(' + drawn[2] + ')')
        deck.remove(drawn)
        turn_counter += 1
        sum += drawn[2]
    if (len(deck) == 1):
        # TODO
    