# Union-Find in Java
A disjoint-set data structure (also called a union–find data structure or merge–find set) 
is a data structure that tracks a set of elements partitioned into a number of disjoint (non-overlapping) subsets. 

It provides **near-constant-time operations** (bounded by the inverse *Ackermann* function) to perform the following:
 
 - add new sets (`join`)
 - merge existing sets (`union`)
 - determine whether elements are in the same set (`find`)
 
![Example underlying structure](/images/Forest.png?raw=true "Union-Find maintains a *forest* of *tree*, similar to a linked-list")
Union-Find maintains a *forest* of *tree*, similar to a linked-list

![Path reduciton](/images/PathReduction.png?raw=true "Paths in the tree can be compressed in three ways (c.f. `DisjointSetNodePC`/`PH`/`PS`) to reduce the computation time of `find` in the future")
Paths in the tree can be compressed in three ways (c.f. `DisjointSetNodePC`/`PH`/`PS`) to reduce the computation time of `find` in the future

 
In addition to just being awesome, disjoint-sets play a key role in Kruskal's algorithm 
for finding the minimum spanning tree of a graph. 

![Kruskal example Union Find](/images/UnionFindKruskalDemo.gif?raw=true "A demo for Union-Find when using Kruskal's algorithm to find minimum spanning tree. [(from Wikipedia)](https://www.wikiwand.com/en/Disjoint-set_data_structure)")

