/*
 * Copyright (c) 2020 Samuel Prevost.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package unionfind;

import java.util.Collection;

public class DisjointSetNode<T> {
    private T value;
    /* This structure can contain heterogeneous template types
    *  since no operation is performed between the nodes values themselves.
    */
    protected DisjointSetNode next;
    protected int rank;

    public DisjointSetNode(T value){
        this.value = value;
        this.next = this; // Make it its own set
        this.rank = 0;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        // Two nodes a and b are equal iif a.value.equals(b.value)
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisjointSetNode that = (DisjointSetNode) o;
        return value.equals(that.value);
    }

    @Override
    public String toString() {
        if (next != this) return "[" + value + "]->"+next ;
        return "[" + value + "](root)";
    }

    /***
     * Finds the equivalence class of this node.
     * For all nodes a and b of the same tree, find(a) = find(b)
     * @return the root node which uniquely identify this tree.
     */
    public DisjointSetNode find(){
        DisjointSetNode node = this;
        while (!node.equals(node.next)){
            node = node.next;
        }
        return node;
    }

    /***
     * Joins two DisjointSetNodes together assuming
     * those are the heads of each DisjointSet you want.
     * Example: if you join other=B and this=3 in structures
     * A->B->C->D and 1->2->3->4, then you'll have
     * A->B->3->4 and 1->2->3->4 but C->D
     * So now find(A) = find(B) = 4 ≠ find(C) = D
     * @param other the subtree you want to join to this tree.
     */
    public void join(DisjointSetNode other){
        if (other == null) throw new NullPointerException();
        other.next = this;
    }

    /***
     * Joins two DisjointSetNodes together such that
     * for all node a and b in this and in other,
     * find(a) = find(b).
     * This is not the same as join, c.f. join documentation.
     * @param other the tree you want to join to this tree.
     */
    public void union(DisjointSetNode other){
        DisjointSetNode p = this.find();
        DisjointSetNode q = other.find();
        if (p.equals(q)) return;
        if (p.rank < q.rank){
            // Swaps like p,q = q,p would
            DisjointSetNode temp = p;
            p = q;
            q = temp;
        }
        // Always join a small rank (q) to a big rank (p)
        // since rank(p.join(q)) = | p.rank     if p.rank > q.rank
        //                         | p.rank+1   else
        p.join(q);
        if (p.rank == q.rank) p.rank++;
    }
}
