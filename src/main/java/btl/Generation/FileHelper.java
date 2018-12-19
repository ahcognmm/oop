package btl.Generation;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    private static String pathPerson = "/home/ahcogn/tx1_name.txt";
    private static String pathCountry = "";
    private static String pathOrg = "";
    private static String pathEvent = "";
    private static String pathRelationship = "";
    private static String pathUrl = "";
    private static String pathDescription = "";
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
            case "description":
                file = new File(pathDescription);
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
