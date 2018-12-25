package btl.Entity;

public class Event extends Entity {

    public Event() {
    }

    public Event(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }

    @Override
    public String getRelationship(Object o) {
        if (o instanceof Location || o instanceof Country) {
            return "takes place";
        }
        return super.getRelationship(o);
    }
}
