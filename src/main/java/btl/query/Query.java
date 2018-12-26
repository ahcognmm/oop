package btl.query;

import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGTupleQuery;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQueryResult;

public class Query {

    private AGRepositoryConnection connection;

    public Query(AGRepositoryConnection connection) {
        this.connection = connection;
    }

    public long query(String queryString) {
        AGTupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        long startTime = System.currentTimeMillis();

        TupleQueryResult result = tupleQuery.evaluate();
        long endTime = System.currentTimeMillis();
        result.close();
        
        return endTime - startTime;
    }

}
