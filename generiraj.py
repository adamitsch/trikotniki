import random
graf = {}

vozlisc = 100
polnost = 1

povezav = 0

for i in range(vozlisc):
    graf[i] = []

for i in range(vozlisc):
    for j in range(i+1,vozlisc):
        if random.random() <= polnost :
            graf[i].append(j)
            povezav += 1

zapis = ""
zapis+= str(vozlisc)+" "+str(povezav)+"\n"
for vozlisce in graf:
    for sosed in graf[vozlisce]:
        zapis = zapis+str(vozlisce)+" "+str(sosed)+"\n"

with open('vhod100100.txt', 'w+') as f:
    f.write(zapis)

