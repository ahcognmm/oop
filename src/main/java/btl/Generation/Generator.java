package btl.Generation;

import btl.Entity.Entity;

public abstract class Generator {

    public Entity generator() {
        return null;
    }

    protected String labelGen(){
        return "";
    }

    public String descriptionGen() {
        return "";
    }
}
