package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Location;
import btl.Main;

import java.util.Calendar;
import java.util.Random;

public class GenerateLocation extends Generator {

    @Override
    public Entity generator() {
        return new Location(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Main.locationLabels.size());
        String s = Main.locationLabels.get(index);
        Main.locationLabels.remove(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Main.locationDes.get(new Random().nextInt(Main.locationDes.size()));
    }
}
