package no.hvl.dat108;

import java.util.ArrayList;
import java.util.PriorityQueue;


/*
NOTATER:
slette noder etter eg har vert i de?


 */

public class Graf {
    ArrayList<Node> noder = new ArrayList<>();
    ArrayList<Kant> kanter = new ArrayList<>();
    Kant kant;
    Node node;


    public ArrayList<Node> lagNodene() {
        /*
        Node a1 = new Node("a1");
        noder.add(a1);
        */
        noder.add(new Node("a"));
        noder.add(new Node("b"));
        noder.add(new Node("c"));
        noder.add(new Node("d"));
        noder.add(new Node("e"));
        noder.add(new Node("f"));

        return noder;
    }

    public ArrayList<Kant> lagKantene() {
        kanter.add(new Kant(1)); //ab
        kanter.add(new Kant(1)); //ac
        kanter.add(new Kant(3)); //ad
        kanter.add(new Kant(5)); //af
        kanter.add(new Kant(2)); //bc
        kanter.add(new Kant(2)); //be
        kanter.add(new Kant(8)); //cd
        kanter.add(new Kant(4)); //df
        kanter.add(new Kant(1)); //ef

        return kanter;
    }

    public void connect() {
        kanter.get(0).kobleSammen(noder.get(0), noder.get(1));
        kanter.get(1).kobleSammen(noder.get(0), noder.get(2));
        kanter.get(2).kobleSammen(noder.get(0), noder.get(3));
        kanter.get(3).kobleSammen(noder.get(0), noder.get(5));
        kanter.get(4).kobleSammen(noder.get(1), noder.get(2));
        kanter.get(5).kobleSammen(noder.get(1), noder.get(4));
        kanter.get(6).kobleSammen(noder.get(2), noder.get(3));
        kanter.get(7).kobleSammen(noder.get(3), noder.get(5));
        kanter.get(8).kobleSammen(noder.get(4), noder.get(5));

        for (int i = 0; i < kanter.size(); i++) {
            kant = kanter.get(i);
            for (int j = 0; j < kant.tilkobletNode.size(); j++) {
                node = kant.tilkobletNode.get(j);
                node.lagKobling(kant);

            }
        }



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

    //a blir lagt inn igjen i ko av ein grunn eg ikkje forstår... how?
    public ArrayList<Node> breddeFørst(Node node) {
        ArrayList<Node> ko = new ArrayList<>();
        ArrayList<Node> bredde = new ArrayList<>();
        ko.add(node);
        bredde.add(node);

        while (ko.size() != 0) {
            Node besokt = ko.get(0);
            for(Kant k : besokt.getTilkobletKant()){
                for(Node n : k.getTilkobletNode()) {
                    if(!n.equals(besokt)){
                        if(!bredde.contains(n)){
                            ko.add(n);
                            bredde.add(n);
                        }
                    }
                }

//            for (int i = 0; i < node.tilkobletKant.size(); i++) {
//                node = ko.get(0);
//                //finner kant som er tilkoblet til node
//                kant = node.tilkobletKant.get(i);
//                //hvilken node som har er tilkoblet til kanten
//                for (Node n : kant.tilkobletNode) {
//                    /*
//                    dersom n ligger ikkje ligger i køen eller allerede vert innom bredde
//                    så blir den lagt til i køen
//                    */
//                    if (!bredde.contains(n) || !ko.contains(n)) {
//                        ko.add(n);
//                    }
//                    //legger til node i bredde, dermed fjernes fra ko så den ikkje kan velges igjen
//                    bredde.add(node);
//                    ko.remove(node);
//                }
//            }

        }
        return bredde;
            System.out.println("fullfører breddeførst-metoden");
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
