package btl.Connection;

import btl.Entity.Entity;
import btl.Entity.Person;
import btl.Generation.GeneratePerson;
import btl.Main;
import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;

import java.io.File;

public class TutorialExamples {

    private static final String SERVER_URL = "http://127.0.0.1:10035/";
    private static final String USERNAME = "ahcogn";
    private static final String PASSWORD = "123456";

    /**
     * Creating a Repository
     */
    public static void example1(boolean close, Entity... t1) throws Exception {
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
        insertion.addPerson((Person) t1[0]);
        insertion.addPerson((Person) t1[1]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
        Person ps = new GeneratePerson().generator();
        System.out.println(ps.toString());
        example1(false, ps);
    }
}