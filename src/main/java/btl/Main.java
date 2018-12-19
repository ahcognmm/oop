package btl;

import btl.Entity.Entity;
import btl.Generation.FileHelper;
import btl.Generation.GeneratePerson;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> persons;

    static {
        try {
            persons = FileHelper.getList("person");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static ArrayList<String> countries;
//
//    static {
//        try {
//            countries = FileHelper.getList("country");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ArrayList<String> orgs;
//
//    static {
//        try {
//            orgs = FileHelper.getList("orgs");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ArrayList<String> relationships;
//
//    static {
//        try {
//            relationships = FileHelper.getList("person");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ArrayList<String> events;
//
//    static {
//        try {
//            events = FileHelper.getList("person");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ArrayList<String> locations;
//
//    static {
//        try {
//            locations = FileHelper.getList("person");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static ArrayList<Entity> entities = new ArrayList<>();

    public Main() {
        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
//        entities.addAll(new GeneratePerson().getListRandom());
    }
}
