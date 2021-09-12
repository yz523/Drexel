import requests
from bs4 import BeautifulSoup
import networkx as nx

def get_links(url, G):
  try:
    reqs = requests.get(url, timeout=5)
  except:
    return G, set()
  soup = BeautifulSoup(reqs.text, 'html.parser')
  new_urls = set()
  for link in soup.find_all('a'):
    new_url = link.get('href')
    if type(new_url) is str and new_url[0:4] == "http":
      new_urls.add(new_url)
      G.add_edge(url, new_url)
  return G, new_urls

def bfs_crawler(start_url, iterations):
  G = nx.DiGraph()
  explored_urls = set()
  urls_to_explore = {start_url}
  next_urls = set()
  for i in range(iterations):
    for url in urls_to_explore:
      G, new_urls = get_links(url, G)
      explored_urls.add(url)
      next_urls.update(new_urls)
    urls_to_explore = next_urls.difference(explored_urls)
  return G

def trim_dangling_nodes(G):
  no_dangling_nodes = False
  while not no_dangling_nodes:
    no_dangling_nodes = True
    nodes = list(G.nodes())
    for node in nodes:
      if len(G.adj[node]) == 0:
        G.remove_node(node)
        no_dangling_nodes = False
  return G
