# Union-Find in Java
A disjoint-set data structure (also called a union–find data structure or merge–find set) 
is a data structure that tracks a set of elements partitioned into a number of disjoint (non-overlapping) subsets. 

It provides **near-constant-time operations** (bounded by the inverse *Ackermann* function) to perform the following:
 
 - add new sets (`join`)
 - merge existing sets (`union`)
 - determine whether elements are in the same set (`find`)
 
<img src="/images/Forest.png?raw=true" alt="Example underlying structure" width="400"/>

Union-Find maintains a *forest* of *tree*, similar to a linked-list

<img src="/images/PathReduction.png?raw=true" alt="Path reduction" width="700"/>

Paths in the tree can be compressed in three ways (c.f. `DisjointSetNodePC`/`PH`/`PS`) to reduce the computation time of `find` in the future

 
In addition to just being awesome, disjoint-sets play a key role in Kruskal's algorithm 
for finding the minimum spanning tree of a graph. 

<img src="/images/UnionFindKruskalDemo.gif?raw=true" alt="Kruskal example Union Find" width="400"/>

A demo for Union-Find when using Kruskal's algorithm to find minimum spanning tree. [(from Wikipedia)](https://www.wikiwand.com/en/Disjoint-set_data_structure)
