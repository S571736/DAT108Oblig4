package no.hvl.dat108;

import java.util.ArrayList;


public class Graf {
    ArrayList<Node> noder;
    ArrayList<Kant> kanter;
    Kant kant;
    Node node;


    //Slett funker betre.
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

    public void slettKant(Kant sletteKant, Node sletteNode){
        for(int i = 0; i < sletteNode.tilkobletKant.size(); i++){
            if (sletteNode.tilkobletKant.get(i) == sletteKant){
                sletteNode.tilkobletKant.remove(i);
            }
        }
    }

    public ArrayList<Node> breddeFørst(){
        ArrayList<Node> ko = new ArrayList<>();
        ArrayList<Node> bredde = new ArrayList<>();
        Node ekstraNode;
        ko.add(noder.get(0));

        while(ko.size()!= 0){
            node = ko.get(0);
            System.out.println(node.toString());
            for (int i = 0; i < node.tilkobletKant.size(); i++){
                kant = node.tilkobletKant.get(i);
                //sletter kanten fra tilkobla node
                if (kant.tilkobletNode.get(0) != node){
                    ekstraNode = kant.tilkobletNode.get(0);
                    slettKant(kant, ekstraNode);
                }else{
                    ekstraNode = kant.tilkobletNode.get(1);
                    slettKant(kant, ekstraNode);
                }

            }
        }

        return bredde;
    }
}
