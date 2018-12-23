package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Event;
import btl.Main;

import java.util.Calendar;
import java.util.Random;

public class GenerateEvent extends Generator {
    @Override
    public Entity generator() {
        return new Event(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Main.eventLabels.size());
        String s = Main.eventLabels.get(index);
        Main.eventLabels.remove(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return super.descriptionGen();
    }
}
