package btl.Entity;

public class Event extends Entity{

    public Event(String label, String description, String url, String crawlTime ) {
        super(label, description, url, crawlTime);
        increaseNo();
    }

    @Override
    public String getRilationship(Object o) {
        if(o instanceof Location || o instanceof Country){
            return "####";
        }
        return super.getRilationship(o);
    }
}
