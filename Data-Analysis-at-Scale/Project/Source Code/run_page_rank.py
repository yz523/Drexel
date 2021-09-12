import networkx as nx
import os
import sys
import ast

file = sys.argv[1]
iterations = int(sys.argv[2])
dataproc_nodes = int(sys.argv[3])

#read in graph
f = open(file,"r")
lines = f.read().splitlines()
e = lines[0]
edges = ast.literal_eval(e)
G = nx.DiGraph()
G.add_edges_from(edges)

#initiate pageranks
pagerank = dict()
for node in G.nodes():
  pagerank[node] = 1

#iterate
edges = list(G.edges)
for i in range(iterations):
  #create input files
  for node in G.nodes:
    f = open(f"input{hash(node)}.txt","w")
    f.write(str(edges))
    f.write("\n")
    f.write(str(pagerank))
    f.write("\n")
    f.write(node)
    f.close()

  #generate new pageranks
  os.system(f"python3 page_rank_iteration.py -r dataproc input*.txt --num-core-instances {dataproc_nodes} > output.txt")

  #update pageranks
  f = open("output.txt", "r")
  lines = f.read().splitlines()
  for line in lines:
    entry = line.replace("\"","").split()
    pagerank[entry[0]] = float(entry[1])

  os.system("rm input*.txt")

#normalize and print pageranks
sum_pr = sum(pagerank.values())
f = open(f"pagerank_results_iterations_{iterations}_nodes_{dataproc_nodes}.txt","w")
for node in pagerank.keys():
  pagerank[node] /= sum_pr
  f.write(f"{node} : {pagerank[node]}\n")
f.close()

#cleanup
os.system("rm output.txt")