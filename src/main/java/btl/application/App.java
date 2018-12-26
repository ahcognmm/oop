package btl.application;

import btl.insertion.Insertion;
import btl.insertion.InsertionThread;
import btl.entity.Entity;
import btl.generation.GenerateRandom;
import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGServer;
import org.eclipse.rdf4j.model.IRI;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String SERVER_URL = "http://127.0.0.1:10035/";
    private static final String USERNAME = "ahcogn";
    private static final String PASSWORD = "123456";

    /**
     * Creating a Repository
     */
    public static void run(boolean close, int numOfEntity, int numOfRelation, String name) throws Exception {

        System.out.println("\nStarting run().");
        AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
        AGCatalog catalog = server.getRootCatalog();
        System.out.println(catalog.getRepositoriesURL());
        catalog.deleteRepository(name);
        AGRepository myRepository = catalog.createRepository(name);

        Insertion insertion = new Insertion(myRepository.getConnection());
        ArrayList<InsertionThread> insertionThreads = new ArrayList<>();

        while (numOfEntity > 0) {
//            int
            List<IRI> entities_iri = new ArrayList<>();
            GenerateRandom random = new GenerateRandom();
            List<Entity> entities = random.listRandomEntity(numOfEntity > 100 ? 100 : numOfEntity);
            entities.forEach(i -> {
                entities_iri.add(insertion.add(i));
            });
            insertion.insertDatabase();
            while (numOfRelation > 100) {
                InsertionThread thread = new InsertionThread(numOfRelation > 1000 ? 1000 : numOfRelation, entities_iri, myRepository, insertionThreads.size() + 1);
                insertionThreads.add(thread);
                thread.start();
                thread.join();
                numOfRelation -= 1000;
            }
            numOfEntity -= 100;
        }
        System.out.println(insertionThreads.size());
        server.close();
    }

    public static void main(String[] args) throws Exception {
        new Init();
//        System.out.println(Calendar.getInstance().getTime().toString());
//        run(false, 100, 200, "oop_f1");
//        System.out.println("finish r1");
//        run(false, 5000, 7000, "oop_f2");
//        System.out.println("finish r2");
//        run(false, 60000, 80000, "oop_f3");
//        System.out.println("finish r3");
        run(false, 300000, 400000, "oop_f");
        System.out.println("finish r4");
//        run(false, 600000, 1200000, "oop_f4");
//        System.out.println("finish r5");

    }
}