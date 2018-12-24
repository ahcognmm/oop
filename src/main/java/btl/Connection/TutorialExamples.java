package btl.Connection;

import btl.Entity.Entity;
import btl.Entity.Person;
import btl.Generation.GeneratePerson;
import btl.Generation.GenerateRandom;
import btl.Main;
import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;
import org.eclipse.rdf4j.model.IRI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TutorialExamples {

    private static final String SERVER_URL = "http://127.0.0.1:10035/";
    private static final String USERNAME = "ahcogn";
    private static final String PASSWORD = "123456";

    /**
     * Creating a Repository
     */
    public static void example1(boolean close, List<Entity> t1) throws Exception {
        // Tests getting the repository up.
        System.out.println("\nStarting example1().");
        AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
        System.out.println("Available catalogs: " + server.listCatalogs());
        AGCatalog catalog = server.getRootCatalog();
        System.out.println("Available repositories in catalog " +
                (catalog.getCatalogName()) + ": " +
                catalog.listRepositories());
        catalog.deleteRepository("oop");
        AGRepository myRepository = catalog.createRepository("oop");
        Insertion insertion = new Insertion(myRepository.getConnection());
        ArrayList<IRI> listEntity = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listEntity.add(insertion.add(t1.get(i)));
        }
        int size = listEntity.size();
        Main.relationships.subList(0, 199).forEach(i -> {
            IRI relationship = insertion.createRelationship(i);
            insertion.insertRelationship(listEntity.get(new Random().nextInt(size)), relationship, listEntity.get(new Random().nextInt(size)));
        });
        insertion.insertDatabase();
    }

    public static void main(String[] args) throws Exception {
        new Main();
        GenerateRandom random = new GenerateRandom();

        List<Entity> entities = random.listRandomEntity(100);
//        System.out.println(ps.toString());
        example1(false, entities);
    }
}