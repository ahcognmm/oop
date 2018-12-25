package btl.Entity;

public class Organization extends Entity {
    public Organization() {
    }

    public Organization(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }

    @Override
    public String getRilationship(Object o) {
        if (o instanceof Country) {
            return "####";
        }
        if (o instanceof Event) {
            return "####";
        }
        return super.getRilationship(o);
    }
}
