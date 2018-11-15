package no.hvl.dat108;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;


/*
NOTATER:
slette noder etter eg har vert i de?


 */

public class Graf {
    ArrayList<Node> noder;
    ArrayList<Kant> kanter;
    Kant kant;
    Node node;


    //Slett funker betre.
    public Kant fjernKant(int kantNr) {
        kant = kanter.get(kantNr);
        //Sletter ein node som ender opp uten kanter
        //Sette opp ja nei om å slette?
        if (kant.tilkobletNode.size() != 0) {
            for (int i = 0; i < kant.tilkobletNode.size(); i++) {
                node = kant.tilkobletNode.get(i);
                if (node.tilkobletKant.size() == 0) {
                    kant.tilkobletNode.remove(i);
                }
            }
        }
        kanter.remove(kant);
        return kant;
    }

    public Node fjernNode(int nodeNr) {
        node = noder.get(nodeNr);
        if (node.tilkobletKant.size() != 0) {
            for (int i = 0; i < node.tilkobletKant.size(); i++) {
                node.tilkobletKant.remove(i);
            }
        }
        noder.remove(node);
        return node;
    }

    public void slettKant(Kant sletteKant, Node sletteNode) {
        for (int i = 0; i < sletteNode.tilkobletKant.size(); i++) {
            if (sletteNode.tilkobletKant.get(i) == sletteKant) {
                sletteNode.tilkobletKant.remove(i);
            }
        }
    }

    public ArrayList<Node> breddeFørst() {
        ArrayList<Node> ko = new ArrayList<>();
        ArrayList<Node> bredde = new ArrayList<>();
        Node ekstraNode;
        ko.add(noder.get(0));

        while (ko.size() != 0) {
            node = ko.get(0);
            for (int i = 0; i < node.tilkobletKant.size(); i++) {
                kant = node.tilkobletKant.get(i);

                if(kant.tilkobletNode.get(0).getId().compareTo(node.getId()) == 0){
                    ekstraNode = kant.tilkobletNode.get(1);
                    ko.add(ekstraNode);
                }else{
                    ekstraNode = kant.tilkobletNode.get(0);
                    ko.add(ekstraNode);
                }
                bredde.add(node);
                ko.remove(node);

            }
        }

        return bredde;
    }

    public boolean finnesNode(ArrayList<Node> liste, Node node) {
        Node N;
        boolean funnet = false;
        String Id = node.getId();
//double my ass, i need two things from one thingy so stfu
        while (funnet == false) {
            for (int i = 0; i < liste.size(); i++) {
                N = liste.get(i);
                if (Id.equals(N.getId())) {
                    funnet = true;
                    break;
                }

            }
        }
                return funnet;
    }

    public Node finnNode(ArrayList<Node> liste, Node node) {
        Node N = null;
        String Id = node.getId();
        boolean funnet = false;

        while (funnet == false) {
            for (int i = 0; i < liste.size(); i++) {
                N = liste.get(i);
                if (Id.equals(N.getId())){
                    funnet = true;
                    break;
                }
            }
        }
        return N;
    }

    public ArrayList<Kant> prim(Node n) {
        ArrayList<Node> brukt = new ArrayList<>();
        ArrayList<Kant> MST = new ArrayList<>();
        Node midlertidig = null;
        PriorityQueue haug = new PriorityQueue();
        for(int i = 0; i < kanter.size(); i++) {
            haug.add(kanter.get(i));
        }
        while(!haug.isEmpty()) {
            Kant k = (Kant) haug.poll();
            for(int j = 0; j < k.tilkobletNode.size(); j++) {
                midlertidig = k.tilkobletNode.get(j);
                if(!brukt.contains(midlertidig)) {
                    brukt.add(midlertidig);
                    MST.add(k);
                }
            }
        }

        return MST;

    }


}
