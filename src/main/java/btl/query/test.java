package btl.query;

import btl.FileHelper;
import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;

import java.io.IOException;

public class test {
    private static final String SERVER_URL = "http://127.0.0.1:10035/";
    private static final String USERNAME = "ahcogn";
    private static final String PASSWORD = "123456";
    private static String[] btl = {"oop_f", "oop_f1", "oop_f2", "oop_f3", "oop_f4"};

    public static void main(String[] args) throws IOException {
        System.out.println("\nStarting run().");
        AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
        AGCatalog catalog = server.getRootCatalog();
        System.out.println(catalog.getRepositoriesURL());
        for (String id : btl) {
            System.out.println();
            AGRepositoryConnection agRepositoryConnection = catalog.openRepository(id).getConnection();
            FileHelper.getList("query").forEach(i -> {
                System.out.println(new Query(agRepositoryConnection).query(i));
            });

        }
    }
}
