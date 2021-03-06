package btl.generation;

import btl.entity.Country;
import btl.entity.Entity;
import btl.application.Init;

import java.util.Calendar;
import java.util.Random;

public class GenerateCountry extends Generator {
    @Override
    public Entity generator() {
        return new Country(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Init.countryLabels.size());
        String s = Init.countryLabels.get(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Init.countryDes.get(new Random().nextInt(Init.countryDes.size() - 1));
    }
}
