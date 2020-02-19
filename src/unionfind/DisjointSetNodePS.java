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

/* Implements Path Splitting in DisjointSetNode's find method */
public class DisjointSetNodePS<T> extends DisjointSetNode<T> {
    public DisjointSetNodePS(T value) {
        super(value);
    }

    /**
     * TL;DR: Path splitting makes -->every<-- node on the path point to its grandparent.
     *
     * When going up the chain, suppose we have A->B->C, with
     * the current node n=A, we keep another reference tmp=A
     * then n goes to the next, that being n=B, but tmp is still at A
     * so what we do is tell A that its next is not B but the next of n,
     * that being C, so now we have:
     * A-->C and B->C
     * which means that next time this is called, it'll go
     * straight to C no matter where we start !
     * @return the root node which uniquely identify this tree.
     */
    public DisjointSetNode find(){
        DisjointSetNode temp, node = this;
        while (!node.equals(node.next)){
            temp = node;
            node = node.next;
            temp.next = node.next;
        }
        return node;
    }
}
