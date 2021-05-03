import pdb

def read_file(filename):
    big = []

    with open(filename, "r") as f:
        lines = f.readlines()
        i = 0
        counter = 0
        while (i < len(lines)):
            # Words
            words = []
            for j in range(i+1, i + int(lines[i]) + 1):
                words.append(lines[j].strip())
            i += int(lines[i]) + 1

            # Rules
            rules = []
            for j in range(i+1, i + int(lines[i]) + 1):
                rules.append(lines[j].strip())
            i += int(lines[i]) + 1

            big.append([words, rules])

    return big

def print_pws(pw_set, rule_ix=0, word_ix=0, rule_char='', dig=0, word=''):
    rules = pw_set[1]
    rule_n = len(rules)
    if (rule_ix < rule_n):
        rule = pw_set[1][rule_ix]
        print(rule)
        print_pws(pw_set, rule_ix+1)

if __name__ == "__main__":
    big = read_file("input.txt")
    print(big)
    for pw_set in big:
        print("--")
        print_pws(pw_set)