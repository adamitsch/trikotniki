import random
import math

graf = {}

vozlisc = 15000
polnost = 0.02

povezav = 0

abc = list(range(vozlisc))

for i in range(vozlisc):
    graf[i] = []

for i in range(vozlisc):
    stevilo_novih = math.floor( (vozlisc-i-1) * polnost)
    dodaj = random.sample( abc[i+1:], stevilo_novih)
    for j in dodaj:
        graf[i].append(j)
        povezav += 1

zapis = ""
zapis+= str(vozlisc)+" "+str(povezav)+"\n"
for vozlisce in graf:
    if vozlisce % 1000 == 0:
        print(vozlisce)

    for sosed in graf[vozlisce]:
        zapis = zapis+str(vozlisce)+" "+str(sosed)+"\n"

with open('vhod15000.txt', 'w+') as f:
    f.write(zapis)  

