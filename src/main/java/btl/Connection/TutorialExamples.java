import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;

import java.io.File;

public class TutorialExamples {

    private static final String SERVER_URL = "http://13.228.48.221:10035/";
    private static final String USERNAME = "ahcogn";
    private static final String PASSWORD = "123456";

    /**
     * Creating a Repository
     */
    public static void example1(boolean close) throws Exception {
        // Tests getting the repository up.
        System.out.println("\nStarting example1().");
        AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
        System.out.println("Available catalogs: " + server.listCatalogs());
        AGCatalog catalog = server.getRootCatalog();
        System.out.println("Available repositories in catalog " +
                (catalog.getCatalogName()) + ": " +
                catalog.listRepositories());
    }

    public static void main(String[] args) throws Exception {
        example1(false);
    }
}