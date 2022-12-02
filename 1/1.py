elves = []
temp = []

with open('Advent of Code.txt') as f:
    while True:
        line = f.readline()
        if not line:
            break

        if line != '\n':
            temp.append(int(line))
        else:
            elves.append(sum(temp))
            temp = []

print("Top 3")
sums = 0
for i in range(0,3):
    m = max(elves)
    elves.remove(m)
    sums += m
    print(m)
print("\nTotal")
print(sums)
