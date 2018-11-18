package no.hvl.dat108;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Graf {
    ArrayList<Node> noder = new ArrayList<>();
    ArrayList<Kant> kanter = new ArrayList<>();
    Kant kant;
    Node node;


    public ArrayList<Node> lagNodene() {

        noder.add(new Node("a")); //0
        noder.add(new Node("b")); //1
        noder.add(new Node("c")); //2
        noder.add(new Node("d")); //3
        noder.add(new Node("e")); //4
        noder.add(new Node("f")); //5

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
        kanter.get(0).kobleSammen(noder.get(0), noder.get(1)); //ab
        kanter.get(1).kobleSammen(noder.get(0), noder.get(2)); //ac
        kanter.get(2).kobleSammen(noder.get(0), noder.get(3)); //ad
        kanter.get(3).kobleSammen(noder.get(0), noder.get(5)); //af
        kanter.get(4).kobleSammen(noder.get(1), noder.get(2)); //bc
        kanter.get(5).kobleSammen(noder.get(1), noder.get(4)); //be
        kanter.get(6).kobleSammen(noder.get(2), noder.get(3)); //cd
        kanter.get(7).kobleSammen(noder.get(3), noder.get(5)); //df
        kanter.get(8).kobleSammen(noder.get(4), noder.get(5)); //ef

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


    public ArrayList<Node> breddeFørst(Node node) {
        ArrayList<Node> ko = new ArrayList<>();
        ArrayList<Node> bredde = new ArrayList<>();
        ko.add(node);
        bredde.add(node);

        //mens køen ikkje er tom og breddegjennomgangen ikkje har vert innom alle noder
        while (ko.size() != 0 && !(bredde.size() == noder.size())) {
            //finner første node i køen
            Node besokt = ko.get(0);
            //finner kantene som er tilkoblet første i køen
            for (Kant k : besokt.getTilkobletKant()) {
                //finner nodene som første node er tilkoblet
                for (Node n : k.getTilkobletNode()) {

                    if (!n.equals(besokt)) {
                        //sjekker at noden ikkje har er behandlet
                        ko.remove(besokt);
                        if (!bredde.contains(n)) {
                            //legger noden til i koen og behandler
                            ko.add(n);
                            ko.remove(besokt);
                            bredde.add(n);
                        }
                    }
                }
                /*
                TODO
                til den som evaluerer:
                bare slette alt dette ettersom det skal bli brukt til å forklare medlem av gruppen hva som var feilen
                */

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
        }
        //System.out.println("fullfører breddeførst-metoden");
        return bredde;
    }

    public ArrayList<Kant> prim(Node node) {
        ArrayList<Node> brukt = new ArrayList<>();
        ArrayList<Kant> MST = new ArrayList<>();
        Node n = null;
        PriorityQueue<Kant> haug = new PriorityQueue<Kant>();


        for (int i = 0; i < node.tilkobletKant.size(); i++) {
            haug.add(node.tilkobletKant.get(i));
        }
        brukt.add(node);
        while (!haug.isEmpty()) {
            Kant k = haug.poll();
            for (int j = 0; j < k.tilkobletNode.size(); j++) {
                n = k.tilkobletNode.get(j);
                if (!brukt.contains(n)) {
                    brukt.add(n);
                    MST.add(k);
                    for (int i = 0; i < n.tilkobletKant.size(); i++) {
                        haug.add(n.tilkobletKant.get(i));
                    }
                }
            }
        }
        return MST;
    }

}
