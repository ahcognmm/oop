package btl.Application;

import btl.Connection.Insertion;
import btl.Connection.InsertionThread;
import btl.Entity.Entity;
import btl.Generation.GenerateRandom;
import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGServer;
import org.eclipse.rdf4j.model.IRI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class App {

    private static final String SERVER_URL = "http://127.0.0.1:10035/";
    private static final String USERNAME = "ahcogn";
    private static final String PASSWORD = "123456";

    /**
     * Creating a Repository
     */
    public static void run(boolean close, int numOfEntity, int numOfRelation) throws Exception {

        System.out.println("\nStarting run().");
        AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
        AGCatalog catalog = server.getRootCatalog();
        System.out.println(catalog.getRepositoriesURL());
        catalog.deleteRepository("oopn");
        AGRepository myRepository = catalog.createRepository("oopn");

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
                InsertionThread thread = new InsertionThread(numOfRelation > 100 ? 100 : numOfRelation, entities_iri, myRepository, insertionThreads.size() + 1);
                insertionThreads.add(thread);
                thread.start();
                thread.join();
                numOfRelation -= 20;
            }
            numOfEntity -= 100;
        }
        System.out.println(insertionThreads.size());
//        for (int i = 0; i < t1.size(); i++) {
//            listEntity.add(insertion.add(t1.get(i)));
//        }
//        insertion.insertDatabase();
//        InsertionThread thread1 = new InsertionThread(Init.relationships.subList(0,99),listEntity,myRepository);
//        thread1.start();
//        thread1.join();
//        InsertionThread thread2 =new InsertionThread(Init.relationships.subList(100,199),listEntity,myRepository);
//        thread2.start();
//        thread2.join();
//        new InsertionThread(Init.relationships.subList(0,100),listEntity,myRepository).start();
    }

    public static void main(String[] args) throws Exception {
        new Init();
        System.out.println(Calendar.getInstance().getTime().toString());
//        GenerateRandom random = new GenerateRandom();
//
//        List<Entity> entities = random.listRandomEntity(1000000);
//        System.out.println(ps.toString());
//        run(false, entities);
        run(false, 200000, 600000);
    }
}