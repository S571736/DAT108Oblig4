package no.hvl.dat108;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graf g = new Graf();
        ArrayList<Node> liste = null;
        ArrayList<Node> noder = g.lagNodene();
        ArrayList<Kant> kanter = g.lagKantene();

        g.connect();

        liste = g.breddeFørst(noder.get(0));

        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(0).getId());

        }
    }
}


