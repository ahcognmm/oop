package btl.generation;

import btl.entity.Entity;
import btl.entity.Organization;
import btl.application.Init;

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
        int index = new Random().nextInt(Init.orgLabels.size());
        String s = Init.orgLabels.get(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Init.orgDes.get(new Random().nextInt(Init.orgDes.size()));
    }

    public static void main(String[] args) throws IOException {
        new Init();
        System.out.println(new GenerateOrganization().generator().toString());
    }
}
