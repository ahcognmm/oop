package btl.Entity;

public class Event extends Entity{
    @Override
    public String getRilationship(Object o) {
        if(o instanceof Location || o instanceof Country){
            return "####";
        }
        return super.getRilationship(o);
    }
}
