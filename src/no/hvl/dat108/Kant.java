package no.hvl.dat108;

import java.util.ArrayList;
//må implemente comparable?
public class Kant implements Comparable<Kant> {

    int vekt;
    ArrayList<Node> tilkobletNode;


    public Kant(int vekt) {
        this.vekt = vekt;
        this.tilkobletNode = new ArrayList<Node>();
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



    public void kobleSammen(Node n, Node n1){
        this.tilkobletNode.add(n);
        this.tilkobletNode.add(n1);
    }

    @Override
    public int compareTo(Kant kant){
        return Double.compare(this.getVekt(), kant.getVekt());
    }


}
