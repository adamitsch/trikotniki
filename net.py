import networkx as nx
import matplotlib.pyplot as plt
import random

G = nx.Graph()

vozlisc = 0
povezav = 0
with open('vhod20.txt', 'r') as f:

    abc = f.readline().split()
    vozlisc = int(abc[0])
    povezav = int(abc[1])

    for line in f:
        a,b = line.split()
        G.add_edge(a,b)

#pos = nx.spring_layout(G)
#pos = nx.circular_layout(G)
pos = nx.fruchterman_reingold_layout(G)
#pos = nx.random_layout(G)

barve = ['r','g','b','c','y','m']
for i in range(vozlisc-2):
    for j in range(i+1, vozlisc-1):
        for k in range(j+1, vozlisc):
            a,b,c = str(i),str(j),str(k)
            if G.has_edge(a,b) and G.has_edge(b,c) and G.has_edge(a,c):
                nx.draw_networkx_edges(G,pos,edgelist=[(a,b),(b,c),(a,c)],
                        width=5,edge_color=random.choice(barve))

#stetje trikotnikov
print("trikotnikov:",sum(nx.triangles(G).values())/3)

nx.draw(G,pos, with_labels=True)
#nx.draw(G,with_labels=True)
plt.show()

'''
https://networkx.github.io/documentation/networkx-1.7/_modules/networkx/algorithms/cluster.html#triangles
'''
