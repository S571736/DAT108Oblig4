package no.hvl.dat108;

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


    public ArrayList<Node> lagNodene() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        noder.add(a); //0
        noder.add(b); //1
        noder.add(c); //2
        noder.add(d); //3
        noder.add(e); //4
        noder.add(f); //5

        return noder;
    }

    public ArrayList<Kant> lagKantene() {
        Kant ac = new Kant(1);
        Kant ab = new Kant(1);
        Kant ad = new Kant(3);
        Kant af = new Kant(5);
        Kant bc = new Kant(2);
        Kant be = new Kant(2);
        Kant ef = new Kant(1);
        Kant df = new Kant(4);
        Kant cd = new Kant(8);
        kanter.add(ab); //0
        kanter.add(ac); //1
        kanter.add(ad); //2
        kanter.add(af); //3
        kanter.add(bc); //4
        kanter.add(be); //5
        kanter.add(cd); //6
        kanter.add(df); //7
        kanter.add(ef); //8

        return kanter;
    }

    public void connect(){
       kanter.get(0).kobleSammen(noder.get(0), noder.get(1));
       kanter.get(1).kobleSammen(noder.get(0), noder.get(2));
       kanter.get(2).kobleSammen(noder.get(0), noder.get(3));
       kanter.get(3).kobleSammen(noder.get(0), noder.get(5));
       kanter.get(4).kobleSammen(noder.get(1), noder.get(2));
       kanter.get(5).kobleSammen(noder.get(1), noder.get(4));
       kanter.get(6).kobleSammen(noder.get(2), noder.get(3));
       kanter.get(7).kobleSammen(noder.get(3), noder.get(5));
       kanter.get(8).kobleSammen(noder.get(4), noder.get(5));

    }

    //Slett funker betre.
    public Kant fjernKant(int kantNr) {
        kant = kanter.get(kantNr);
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

    public void slettKant(Kant sletteKant, Node sletteNode) {
        for (int i = 0; i < sletteNode.tilkobletKant.size(); i++) {
            if (sletteNode.tilkobletKant.get(i) == sletteKant) {
                sletteNode.tilkobletKant.remove(i);
                kanter.remove(sletteKant);
            }
        }
    }

    public Node fjernNode(Node node) {

        if (node.tilkobletKant.size() != 0) {
            for (int i = 0; i < node.tilkobletKant.size(); i++) {
                node.tilkobletKant.remove(i);
            }
        }
        noder.remove(node);
        return node;
    }

    public ArrayList<Node> breddeFørst(Node node) {
        ArrayList<Node> ko = new ArrayList<>();
        ArrayList<Node> bredde = new ArrayList<>();
        ko.add(node);

        while (ko.size() != 0) {
            node = ko.get(0);
            for (int i = 0; i < node.tilkobletKant.size(); i++) {
                kant = node.tilkobletKant.get(i);
                for (Node n : kant.tilkobletNode) {
                    if (bredde.contains(n) || ko.contains(n)) {
                        ko.add(n);
                    }

                    /*
                    her eller utafor for-løkka?
                    bredde.add(node);
                    ko.remove(node);
                    */
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
                if (Id.equals(N.getId())) {
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
        for (int i = 0; i < kanter.size(); i++) {
            haug.add(kanter.get(i));
        }
        while (!haug.isEmpty()) {
            Kant k = (Kant) haug.poll();
            for (int j = 0; j < k.tilkobletNode.size(); j++) {
                midlertidig = k.tilkobletNode.get(j);
                if (!brukt.contains(midlertidig)) {
                    brukt.add(midlertidig);
                    MST.add(k);
                }
            }
        }

        return MST;

    }


}
