package btl.Generation;

import btl.Connection.Insertion;
import btl.Entity.*;
import btl.Application.Init;
import org.eclipse.rdf4j.model.IRI;

import java.util.Random;

public class GenerateRelationship {

    private static Person ps = new Person();
    private static Country co = new Country();
    private static Event ev = new Event();
    private static Location lo = new Location();
    private static Organization org = new Organization();


    public static String getRalationship(IRI en1, IRI en2) {
        if (en1.getNamespace().equals(Insertion.getPersonNamespace()) && en2.getNamespace().equals(Insertion.getPersonNamespace())) {
            return ps.getRelationship(ps);
        } else if (en1.getNamespace().equals(Insertion.getPersonNamespace()) && en2.getNamespace().equals(Insertion.getCountryNamespace())) {
            return ps.getRelationship(co);
        } else
            return Init.relationships.get(new Random().nextInt(Init.relationships.size()));
    }

}
