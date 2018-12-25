//package btl.Generation;
//
//import btl.Entity.Entity;
//import btl.Main;
//
//import java.io.IOException;
//
//public class GenerateTriple  {
//
//    public String generator() {
//        int x1 = new java.util.Random().nextInt(25);
//        int x2 = new java.util.Random().nextInt(25);
//        Entity e1 = Main.entities.get(x1);
//        Entity e2 = Main.entities.get(x2);
//        return e1.getLabel() + " " + e1.getRelationship(e2) + " " + e2.getLabel();
//    }
//
//    public static void main(String[] args) throws IOException {
//        new Main();
//        System.out.println(new GenerateTriple().generator());
//    }
//}
