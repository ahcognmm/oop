package btl.Application;

import btl.Entity.Entity;
import btl.Generation.FileHelper;
import btl.Generation.GeneratePerson;

import java.io.IOException;
import java.util.ArrayList;

public class Init {
    public static ArrayList<String> personLabels;
    public static ArrayList<String> countryLabels;
    public static ArrayList<String> orgLabels;
    public static ArrayList<String> relationships;
    public static ArrayList<String> eventLabels;
    public static ArrayList<String> locationLabels;
    public static ArrayList<String> personDes;
    public static ArrayList<String> countryDes;
    public static ArrayList<String> orgDes;
    public static ArrayList<String> eventDes;
    public static ArrayList<String> locationDes;

    public static ArrayList<Entity> entities = new ArrayList<>();

    public Init() throws IOException {

        personLabels = FileHelper.getList("person");
        locationLabels = FileHelper.getList("location");
        eventLabels = FileHelper.getList("event");
        relationships = FileHelper.getList("relationship");
        orgLabels = FileHelper.getList("org");
        countryLabels = FileHelper.getList("country");
        personDes = FileHelper.getList("description_person");
        countryDes = FileHelper.getList("description_country");
        eventDes = FileHelper.getList("description_event");
        locationDes = FileHelper.getList("description_location");
        orgDes= FileHelper.getList("description_org");

//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
    }
}
