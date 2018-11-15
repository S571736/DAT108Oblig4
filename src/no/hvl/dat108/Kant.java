package no.hvl.dat108;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kant {

    int vekt;
    ArrayList<Node> tilkobletNode;

    public Kant(int vekt, ArrayList<Node> tilkobletNode){

        this.vekt = vekt;
        this.tilkobletNode = tilkobletNode;
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

}
