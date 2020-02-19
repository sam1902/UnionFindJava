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

/* Implements Path Compression in DisjointSetNode's find method */
public class DisjointSetNodePC<T> extends DisjointSetNode<T> {
    public DisjointSetNodePC(T value) {
        super(value);
    }

    /***
     *
     * @return the root node which uniquely identify this tree.
     */
    public DisjointSetNode find(){
        /*
         * Recursive version
         * if (!this.equals(this.next)){
         *     this.next = this.next.find();
         * }
         * return this.next;
         */
        // Iterative version
        DisjointSetNode temp, root = super.find(), node = this;
        while (!node.equals(root)){
            temp = node;
            node = node.next;
            temp.next = root;
        }
        return root;
    }
}
