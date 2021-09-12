from mrjob.job import MRJob
import ast

def get_adj(node, edges):
  adj = list()
  for edge in edges:
    if edge[0] == node:
      adj.append(edge[1])
  return adj

class PageRankIter(MRJob):
  def get_adj(node, edges):
    adj = list()
    for edge in edges:
      if edge[0] == node:
        adj.append(edge[1])
    return adj
    
  def mapper_raw(self, file, _):
    f = open(file,"r")
    lines = f.read().splitlines()
    e = lines[0]
    pr = lines[1]
    node = lines[2]
    edges = ast.literal_eval(e)
    pagerank = ast.literal_eval(pr)

    adj = get_adj(node, edges)
    p = float(pagerank[node]/len(adj))

    for adj_node in adj:
      yield (adj_node, p)

  def reducer(self, node, pr_list):
    yield node, sum(pr_list)

if __name__ == '__main__':
    PageRankIter.run()