package btl.Entity;

public class Organization extends Entity {
    @Override
    public String getRilationship(Object o) {
        if(o instanceof Country){
            return "####";
        }
        if( o instanceof Event){
            return "####";
        }
        return super.getRilationship(o);
    }
}
