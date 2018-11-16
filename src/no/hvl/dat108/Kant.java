package no.hvl.dat108;

import java.util.ArrayList;

public class Kant {

    int vekt;
    ArrayList<Node> tilkobletNode;

    public Kant(int vekt, ArrayList<Node> tilkobletNode) {

        this.vekt = vekt;
        this.tilkobletNode = tilkobletNode;
    }

    public Kant(int vekt) {
        this.vekt = vekt;
    }

    public int getVekt() {
        return vekt;
    }

    public void setVekt(int vekt) {
        this.vekt = vekt;
    }

    public ArrayList<Node> getTilkobletNode() {
        return tilkobletNode;
    }

    public void setTilkobletNode(ArrayList<Node> tilkobletNode) {
        this.tilkobletNode = tilkobletNode;
    }

    /*
    public void lagKobling(Kant k) {
        for (int i = 0; i < tilkobletNode.size(); i++) {
            k.tilkobletNode.get(0).lagKobling(k);
        }
    }
    */

    public void kobleSammen(Node n, Node n1){
        this.tilkobletNode.add(n);
        this.tilkobletNode.add(n1);
    }


}
