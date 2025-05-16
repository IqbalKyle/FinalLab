package org.team2.FinalLab;

public class DummyData {

    //Load data dummy 
    public static void load(bst bst, HashTable ht, graph gr) {
        //Loop to get the automated name for the dummy data 
        for (int id = 100; id <= 120; id++) {
            String name = "Contact" + id;
            bst.insert(id);
            ht.insert(id, name);
            gr.addNode(id);
        }
        //Random relations for the IDs 
        for (int id = 100; id < 120; id++) {
            gr.addEdge(id, id+1);
        }

        //Variations
                gr.addEdge(100, 105);
        gr.addEdge(102, 108);
        gr.addEdge(103, 110);
        gr.addEdge(104, 107);
        gr.addEdge(106, 109);
        gr.addEdge(111, 115);
        gr.addEdge(112, 114);
        gr.addEdge(113, 118);
        gr.addEdge(116, 120);
        gr.addEdge(117, 119);
    }
}