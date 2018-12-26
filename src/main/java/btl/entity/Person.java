package btl.entity;

import java.util.Random;

public class Person extends Entity {

    private int age;
    private String[] p_pRelation = {"visit", "depend on", "work with", "play with"};
    private String[] p_cRelation = {"live", "leave", "arrive", "travel", "manage"};
    private String[] p_orRelation = {"work at", "manage", "join", "establish"};
    private String[] p_eRelation = {"join", "organize", "destroy", "cook"};

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
    public String getRelationship(Object o) {
        if (o instanceof Person) {
            return p_pRelation[new Random().nextInt(p_pRelation.length)];
        }
        if (o instanceof Organization) {
            return p_orRelation[new Random().nextInt(p_orRelation.length)];
        }
        if (o instanceof Country) {
            return p_cRelation[new Random().nextInt(p_cRelation.length)];
        }
        if (o instanceof Location) {
            return p_cRelation[new Random().nextInt(p_cRelation.length)];
        }
        if (o instanceof Event) {
            return p_eRelation[new Random().nextInt(p_eRelation.length)];
        }
        return super.getRelationship(o);
    }

}
