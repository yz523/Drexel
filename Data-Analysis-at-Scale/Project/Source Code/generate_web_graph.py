import sys
from web_crawler import *

G = nx.DiGraph()
url = sys.argv[1]
depth = int(sys.argv[2])
G = bfs_crawler(url, depth)
print(f"All nodes: {len(G.nodes())}")
G = trim_dangling_nodes(G)
print(f"Non-dangling nodes: {len(G.nodes())}")
edges = list(G.edges())
f = open("web_graph.txt","w")
f.write(str(edges))
f.close()