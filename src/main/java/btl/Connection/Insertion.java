package btl.Connection;

import btl.Entity.Organization;
import btl.Entity.Person;
import com.franz.agraph.repository.AGRepositoryConnection;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.RDF;

public class Insertion {
    private AGRepositoryConnection connection;
    private ValueFactory valueFactory;

    private static String ontologyNamespace = "http://www.aaa.com/ontology/";

    private static String personNamespace = "http://www.aaa.com/person/";
    private static String organizationNamespace = "http://www.aaa.com/organization/";
    private static String locationNamespace = "http://www.aaa.com/location/";
    private static String countryNamespace = "http://www.aaa.com/country/";
    private static String timeNamespace = "http://www.aaa.com/time/";
    private static String eventNamespace = "http://www.aaa.com/event/";
    private static String relationshipNamespace = "http://www.aaa.com/relationship/";

    private IRI labelOntology;
    private IRI descriptionOntology;
    private IRI extractedLinkOntology;
    private IRI extractedDateOntology;
    private IRI ageOntology;

    private IRI personType;
    private IRI organizationType;
    private IRI locationType;
    private IRI countryType;
    private IRI eventType;

    private Literal label;
    private Literal description;
    private Literal extractedLink;
    private Literal extractedDate;
    private Literal age;

    private ModelBuilder modelBuilder;

    public Insertion(AGRepositoryConnection connection) {
        this.connection = connection;
        this.valueFactory = connection.getValueFactory();

        connection.setNamespace("ns", ontologyNamespace);
        connection.setNamespace("relationship", relationshipNamespace);

        labelOntology = valueFactory.createIRI(ontologyNamespace, "label");
        descriptionOntology = valueFactory.createIRI(ontologyNamespace, "description");
        extractedDateOntology = valueFactory.createIRI(ontologyNamespace, "extractedDate");
        extractedLinkOntology = valueFactory.createIRI(ontologyNamespace, "extractedLink");
        ageOntology = valueFactory.createIRI(ontologyNamespace, "age");

        personType = valueFactory.createIRI(ontologyNamespace, "Person");
        organizationType = valueFactory.createIRI(ontologyNamespace, "Organization");
        locationType = valueFactory.createIRI(ontologyNamespace, "Location");
        countryType = valueFactory.createIRI(ontologyNamespace, "Country");
        eventType = valueFactory.createIRI(ontologyNamespace, "Event");

        modelBuilder = new ModelBuilder();
    }

    public IRI addPerson(Person person) {
        IRI iri = valueFactory.createIRI(personNamespace, person.getId());
        label = valueFactory.createLiteral(person.getLabel());
        description = valueFactory.createLiteral(person.getDescription());
        extractedLink = valueFactory.createLiteral(person.getUrl());
        extractedDate = valueFactory.createLiteral(person.getCrawlTime());
        age = valueFactory.createLiteral(person.getAge());

        modelBuilder.add(iri, RDF.TYPE, personType);
        modelBuilder.add(iri, labelOntology, label);
        modelBuilder.add(iri, descriptionOntology, description);
        modelBuilder.add(iri, extractedDateOntology, extractedDate);
        modelBuilder.add(iri, extractedLinkOntology, extractedLink);
        modelBuilder.add(iri, ageOntology, age);

        return iri;
    }

    private IRI addOrgnization(Organization org) {
        IRI iri = valueFactory.createIRI(personNamespace, org.getId());
        label = valueFactory.createLiteral(org.getLabel());
        description = valueFactory.createLiteral(org.getDescription());
        extractedLink = valueFactory.createLiteral(org.getUrl());
        extractedDate = valueFactory.createLiteral(org.getCrawlTime());

        modelBuilder.add(iri, RDF.TYPE, personType);
        modelBuilder.add(iri, labelOntology, label);
        modelBuilder.add(iri, descriptionOntology, description);
        modelBuilder.add(iri, extractedDateOntology, extractedDate);
        modelBuilder.add(iri, extractedLinkOntology, extractedLink);

        return iri;
    }

    public IRI createRelationship(String relationshipDescription) {
        return valueFactory.createIRI(relationshipNamespace, relationshipDescription);
    }

    public void insertStatement(IRI entity1, IRI relationship, IRI entity2) {
        modelBuilder.add(entity1, relationship, entity2);
    }

}
