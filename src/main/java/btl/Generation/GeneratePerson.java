package btl.Generation;

import btl.Entity.Entity;
import btl.Entity.Person;
import btl.Main;

import java.util.ArrayList;

public class GeneratePerson {

    //    private GeneratePerson ps = new GeneratePerson();
//    private String person;
//    private String descriptions;
//    private String location;
//    private String organization;
//
//    public String getPerson() {
//        return person;
//    }
//
//    public void setPerson(String person) {
//        this.person = person;
//    }
//
//    public String getDesciptions() {
//        return descriptions;
//    }
//
//    public void setDesciptions(String desciptions) {
//        this.descriptions = desciptions;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(String organization) {
//        this.organization = organization;
//    }
//
//    private GeneratePerson person() {
//        ps.setPerson(random("person"));
//        return ps;
//    }
//
//    private GeneratePerson descriptions() {
//        ps.setDesciptions(random("descriptions"));
//        return ps;
//    }
//
//    private GeneratePerson location() {
//        ps.setDesciptions(random("location"));
//        return ps;
//    }
//
//    private GeneratePerson organization() {
//        ps.setOrganization(random("organization"));
//        return ps;
//    }
//
//    @Override
//    public String random(String param) {
//        switch (param){
//            case "person":
//
//                break;
//        }
//        return "";
//    }
//
//    @Override
//    public String generator() {
//
//        //Sinh du lieu tai day
//        ps.person().organization().location().descriptions();
//        String rs1 = ps.person() + " " + ps.getLocation();
//        return "";
//    }
    private Person ps;

    public GeneratePerson() {
    }

    public ArrayList<Entity> getListRandom() {
        ArrayList<Entity> rs = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            ps = new Person();
            int x = new java.util.Random().nextInt(25);
            ps.setLabel(Main.persons.get(x));
            rs.add(ps);
        }
        return rs;
    }


}
