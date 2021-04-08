# Card game
import random
import game1

# Check if prime
def is_prime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

# Main method
if __name__ == "__main__":
    deck = game1.generate_deck()

    won = False

    while (not won and len(deck) != 0):
        print("Draw a card!")
        drawn_cards = []
        sum = 0
        turn_counter = 0
        while (turn_counter < 3 or len(deck) == 1):
            input()
            drawn = random.choice(deck)
            print("You drew " +
                str(drawn[0]) + ' of ' + str(drawn[1]) +
                ' (' + str(drawn[2]) + ')')
            deck.remove(drawn)
            turn_counter += 1
            sum += drawn[2]
        print("The sum is:", sum)
        if (is_prime(sum)):
            print("You won!")
            won = True
        else:
            print("Better luck next time!")

    if (not won and len(deck) == 0):
        print("Sorry, you lost :(")
        
