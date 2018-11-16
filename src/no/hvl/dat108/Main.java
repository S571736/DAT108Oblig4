package no.hvl.dat108;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graf g = new Graf();

        ArrayList<Node> noder = g.lagNodene();
        ArrayList<Kant> kanter = g.lagKantene();

        g.connect();


    }
}
