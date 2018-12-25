package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Event;
import btl.Application.Init;

import java.util.Calendar;
import java.util.Random;

public class GenerateEvent extends Generator {
    @Override
    public Entity generator() {
        return new Event(labelGen(), descriptionGen(), "www.google.com.vn", Calendar.getInstance().getTime().toString());
    }

    @Override
    protected String labelGen() {
        int index = new Random().nextInt(Init.eventLabels.size());
        String s = Init.eventLabels.get(index);
        Init.eventLabels.remove(index);
        return s;
    }

    @Override
    public String descriptionGen() {
        return Init.eventDes.get(new Random().nextInt(Init.eventDes.size() - 1));
    }
}
