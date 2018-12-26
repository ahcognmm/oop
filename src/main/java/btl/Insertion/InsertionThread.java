package btl.Insertion;

import btl.Generation.GenerateRelationship;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import org.eclipse.rdf4j.model.IRI;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class InsertionThread extends Thread {

    private int nuRelationship;
    private List<IRI> listEntities;
    private AGRepositoryConnection connection;
    private Insertion insertion;
    private int no;

    public InsertionThread(int nuRelationship, List<IRI> listEntities, AGRepository connection, int no) {
        this.connection = connection.getConnection();
        this.listEntities = listEntities;
        this.nuRelationship = nuRelationship;
        insertion = new Insertion(this.connection);
        this.no = no;

    }

    @Override
    public void run() {
        int size = listEntities.size();
        for (int i = 0; i < nuRelationship; i++) {
            IRI entity1 = listEntities.get(new Random().nextInt(size));
            IRI entity2 = listEntities.get(new Random().nextInt(size));
            IRI relationship = insertion.createRelationship(GenerateRelationship.getRalationship(entity1, entity2));
            insertion.insertRelationship(entity1, relationship, entity2);
        }
        insertion.insertDatabase();
        System.out.println("finish>>" + no + " " + Calendar.getInstance().getTime().toString());
    }
}
