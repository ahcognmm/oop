package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Person;
import btl.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class GeneratePerson extends Generator {

    @Override
    protected String labelGen() {
        return Main.personLabels.get(new Random().nextInt(Main.personLabels.size()));
    }

    @Override
    public Person generator() {
        Person ps = new Person(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
        return ps;
    }

    @Override
    public String descriptionGen() {
        return Main.personDes.get(new java.util.Random().nextInt(Main.personDes.size()));
    }

    public ArrayList<Entity> getListRandom() {
        Person ps;
        ArrayList<Entity> rs = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            ps = generator();
            rs.add(ps);
        }
        return rs;
    }

    public static void main(String[] args) throws IOException {
        new Main();
//        Person ps = new GeneratePerson().generator();
        long x = System.currentTimeMillis();
        ArrayList<Entity> aps = new GeneratePerson().getListRandom();
        long x2 = System.currentTimeMillis();
//        System.out.println(ps.toString());
        aps.forEach(i -> {
            System.out.println(i.toString());
        });
        System.out.println(x2 - x);
    }

}
