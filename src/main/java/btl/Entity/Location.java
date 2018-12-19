package btl.Entity;

public class Location extends Entity {
    public Location(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }
}
