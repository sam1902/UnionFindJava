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

import java.util.ArrayList;
import java.util.Random;

public class Main {
    /*
    * Disjoint-set data structure (i.e. Union/Find) implementation
    * https://www.wikiwand.com/en/Disjoint-set_data_structure
    */
    public static void main(String[] args) {
        Random prng = new Random();
        prng.setSeed(42);

        /* Change DisjointSetNode for one of
            - DisjointSetNodePH (Path Halving)
            - DisjointSetNodePC (Path Compression)
            - DisjointSetNodePS (Path Splitting)
            To see the effect on the length of the chains printed out
         */
        class NodeClass<T> extends DisjointSetNode<T> {
            public NodeClass(T value) { super(value); }
        }

        // Create new nodes whilst keeping references of them all
        ArrayList<NodeClass<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            nodes.add(new NodeClass<>(i));
        }
        // Randomly union them one to another
        // do this in two steps or the trees will be quite shallow
        for (int i = 0; i < 200; i++){
            nodes.get(prng.nextInt(nodes.size()))
                    .union(
                            nodes.get(prng.nextInt(nodes.size())
                            )
                    );
        }
        // Looks for the unique roots, this will give us the size of our forest
        ArrayList<Integer> roots = new ArrayList<>();
        for (NodeClass<Integer> n : nodes){
            System.out.println(n);
            int root = (Integer) n.find().getValue();
            if (!roots.contains(root)){
                roots.add(root);
            }
        }
        System.out.println("Distinct roots of " + nodes.size() + " nodes: " + roots.size() + " " + roots);

        /* Checks the union/find works well on a small scale */
        NodeClass<Integer> node1 = new NodeClass<>(1);
        NodeClass<Integer> node2 = new NodeClass<>(2);
        NodeClass<Integer> node3 = new NodeClass<>(3);
        NodeClass<Integer> node4 = new NodeClass<>(4);
        node1.union(node2);
        node3.union(node4);
        node2.union(node4);
        assert node1.find().equals(node4.find());
    }
}
