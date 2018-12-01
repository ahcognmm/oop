package btl.Entity;

public class Person extends Entity {

    @Override
    public String getRilationship(Object o) {
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
