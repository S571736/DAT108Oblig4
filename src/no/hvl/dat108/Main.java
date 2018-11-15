package no.hvl.dat108;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Node> noder = new ArrayList<>();
        ArrayList<Kant> kanter = new ArrayList<>();

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        Kant ac = new Kant(1);
        Kant ab = new Kant(1);
        Kant cb = new Kant(2);
        Kant be = new Kant(2);
        Kant ef = new Kant(1);
        Kant fd = new Kant(4);
        Kant cd = new Kant(8);
        Kant ad = new Kant(3);
        Kant af = new Kant(5);

        noder.add(a);
        noder.add(b);
        noder.add(c);
        noder.add(d);
        noder.add(e);
        noder.add(f);

        a.lagKobling(ac);
        a.lagKobling(ab);
        a.lagKobling(ad);
        a.lagKobling(af);


    }
}
