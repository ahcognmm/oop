package btl.Entity;

public class Country extends Entity {

    public Country() {
    }

    public Country(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }
}
