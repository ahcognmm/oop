package btl.Generation;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    private static String pathPerson = "personLabel.txt";
    private static String pathCountry = "countryLabel.txt";
    private static String pathOrg = "organizationLabel.txt";
    private static String pathEvent = "eventLabel.txt";
    private static String pathRelationship = "relationshipDescription.txt";
    private static String pathUrl = "";
    private static String pathDescription_person = "personDescription.txt";
    private static String pathDescription_country = "countryDescription.txt";
    private static String pathDescription_org = "organizationDescription.txt";
    private static String pathDescription_event = "eventDescription.txt";
    private static String pathDescription_location = "locationDescription.txt";
    private static File file;
    private static BufferedReader bufferedReader;

    public static ArrayList<String> getList(String entity) throws IOException {
        ArrayList<String> rs = new ArrayList<>();
        switch (entity) {
            case "person":
                file = new File(pathPerson);
                break;
            case "country":
                file = new File(pathCountry);
                break;
            case "org":
                file = new File(pathOrg);
                break;
            case "event":
                file = new File(pathEvent);
                break;
            case "relationship":
                file = new File(pathRelationship);
                break;
            case "url":
                file = new File(pathUrl);
                break;
            case "description_person":
                file = new File(pathDescription_person);
                break;
            case "description_country":
                file = new File(pathDescription_country);
                break;
            case "description_event":
                file = new File(pathDescription_event);
                break;
            case "description_location":
                file = new File(pathDescription_location);
                break;
            case "description_org":
                file = new File(pathDescription_org);
                break;
            default:
                break;
        }
        bufferedReader = new BufferedReader(new FileReader(file));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            rs.add(s);
        }
        return rs;
    }

}
