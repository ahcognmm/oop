package btl.Generation;

import btl.Entity.Entity;
import btl.Main;

import java.util.ArrayList;

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
