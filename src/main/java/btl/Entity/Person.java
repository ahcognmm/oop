package btl.Entity;

public class Person extends Entity {

    private int age;

    public Person() {
    }

    public Person(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
