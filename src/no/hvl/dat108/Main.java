package no.hvl.dat108;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graf g = new Graf();
        ArrayList<Node> liste = null;
        ArrayList<Kant> liste2 = null;
        ArrayList<Node> noder = g.lagNodene();
        ArrayList<Kant> kanter = g.lagKantene();
        Node a = noder.get(0);

        g.connect();

        liste = g.breddeFørst(noder.get(0));
        liste2 = g.prim(a);


        System.out.println("Breddeførst gjennomgang:");
        for (int i = 0; i < liste.size(); i++) {
            System.out.println("besøkt node: " + liste.get(i).getId());
        }

        System.out.println("\nPrims algoritme: ");
        for (int i = 0; i < liste2.size(); i++) {
            Kant k = liste2.get(i);
            Node n0 = k.getTilkobletNode().get(0);
            Node n1 = k.getTilkobletNode().get(1);
            System.out.println("   " + k.getVekt());
            System.out.println(n0.getId() + " ---- " + n1.getId() + "\n");
        }
    }
}


