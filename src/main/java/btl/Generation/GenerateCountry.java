package btl.Generation;

import btl.Entity.Country;
import btl.Entity.Entity;
import btl.Main;

import java.util.Calendar;
import java.util.Random;

public class GenerateCountry extends Generator {
    @Override
    public Entity generator() {
        return new Country(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Main.countryLabels.size());
        String s = Main.countryLabels.get(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Main.countryDes.get(Main.countryDes.size());
    }
}
