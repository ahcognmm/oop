package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Location;
import btl.Application.Init;

import java.util.Calendar;
import java.util.Random;

public class GenerateLocation extends Generator {

    @Override
    public Entity generator() {
        return new Location(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Init.locationLabels.size()-1);
        String s = Init.locationLabels.get(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Init.locationDes.get(new Random().nextInt(Init.locationDes.size()));
    }
}
