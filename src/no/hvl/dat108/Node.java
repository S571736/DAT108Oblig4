package no.hvl.dat108;

import java.util.ArrayList;

public class Node {

    String Id;
    ArrayList<Kant> tilkobletKant;

    public Node(String Id) {
        this.Id = Id;
        this.tilkobletKant = new ArrayList<Kant>();
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public ArrayList<Kant> getTilkobletKant() {
        return tilkobletKant;
    }

    public void setTilkoblet(ArrayList<Kant> tilkobletKant) {
        this.tilkobletKant = tilkobletKant;
    }

    public void lagKobling(Kant k) {
        tilkobletKant.add(k);
    }

    public boolean equals(Node n){
        return Id.equals(n.getId());
    }
}
