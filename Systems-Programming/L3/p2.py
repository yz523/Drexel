import random
import timeit

start = timeit.default_timer()

nodes=16
c = 0
num_samples = 100000000

def inside(p):
    x, y = random.random(), random.random()
    return x*x + y*y < 1

for i in range(nodes):
    count = sc.parallelize(range(i * (num_samples / nodes), (i+1) * (num_samples / nodes))).filter(inside).count()
    c = c + count


pi = 4.0 * c / num_samples
print(pi)

stop = timeit.default_timer()

print stop - start

sc.stop()