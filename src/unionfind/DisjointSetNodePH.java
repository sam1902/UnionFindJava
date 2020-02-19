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

/* Implements Path Halving in DisjointSetNode's find method */
public class DisjointSetNodePH<T> extends DisjointSetNode<T> {
    public DisjointSetNodePH(T value) {
        super(value);
    }

    /***
     * Path halving makes -->every other<-- node on the path point to its grandparent.
     *
     * Path splitting keeps a ref to the previous to make EVERY node on the path point to its grandparent
     * whilst path halving doesn't bother and just set the parent to the grandparent and then goes to the grandparent
     * hence dodging going to the parent entierely, but hence not halving the parent's either (therefore every other node).
     *
     * Suppose we have A->B->C->D
     * after PH, we have A->C->D and B->C whilst after PS we would have A->C and B->D etc.
     * @return the root node which uniquely identify this tree.
     */
    public DisjointSetNode find(){
        DisjointSetNode node = this;
        while (!node.next.equals(node)){
            node.next = node.next.next;
            node = node.next;
        }
        return node;
    }
}
