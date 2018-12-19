package btl.Entity;

public class Person extends Entity {

    public Person() {
    }

    public Person(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }

    @Override
    public String getRilationship(Object o) {
        if (o instanceof Person) {
            return "đến thăm";
        }
        if (o instanceof Organization) {
            return "###";
        }
        if (o instanceof Country) {
            return "####";
        }
        if (o instanceof Location) {
            return "####";
        }
        return super.getRilationship(o);
    }

}
