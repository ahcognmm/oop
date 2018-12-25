package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Organization;
import btl.Main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class GenerateOrganization extends Generator {
    @Override
    public Entity generator() {
        return new Organization(labelGen(), descriptionGen(), "wwww.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Main.orgLabels.size());
        String s = Main.orgLabels.get(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Main.orgDes.get(new Random().nextInt(Main.orgDes.size()));
    }

    public static void main(String[] args) throws IOException {
        new Main();
        System.out.println(new GenerateOrganization().generator().toString());
    }
}
