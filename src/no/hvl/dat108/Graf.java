package no.hvl.dat108;

import java.util.ArrayList;


public class Graf {
    ArrayList<Node> noder;
    ArrayList<Kant> kanter;
    Kant kant;
    Node node;


    public Kant fjernKant(int kantNr){
        kant = kanter.get(kantNr);
        //Sletter ein node som ender opp uten kanter
        //Sette opp ja nei om å slette?
        if(kant.tilkobletNode.size() != 0){
            for (int i = 0; i < kant.tilkobletNode.size(); i++){
                node = kant.tilkobletNode.get(i);
                if (node.tilkobletKant.size() == 0){
                    kant.tilkobletNode.remove(i);
                }
            }
        }
        kanter.remove(kant);
        return kant;
    }

    public Node fjernNode(int nodeNr){
        node = noder.get(nodeNr);
        if (node.tilkobletKant.size() != 0){
            for (int i = 0; i < node.tilkobletKant.size(); i++) {
                node.tilkobletKant.remove(i);
            }
        }
        noder.remove(node);
        return node;
    }
}
