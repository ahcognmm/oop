package btl.Connection;

import btl.Entity.*;
import com.franz.agraph.repository.AGRepositoryConnection;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.RDF;

import java.util.Random;

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

    private IRI addPerson(Person person) {
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
        IRI iri = valueFactory.createIRI(organizationNamespace, org.getId());
        label = valueFactory.createLiteral(org.getLabel());
        description = valueFactory.createLiteral(org.getDescription());
        extractedLink = valueFactory.createLiteral(org.getUrl());
        extractedDate = valueFactory.createLiteral(org.getCrawlTime());

        modelBuilder.add(iri, RDF.TYPE, organizationType);
        modelBuilder.add(iri, labelOntology, label);
        modelBuilder.add(iri, descriptionOntology, description);
        modelBuilder.add(iri, extractedDateOntology, extractedDate);
        modelBuilder.add(iri, extractedLinkOntology, extractedLink);

        return iri;
    }

    private IRI addEvent(Event event) {
        IRI iri = valueFactory.createIRI(eventNamespace, event.getId());
        label = valueFactory.createLiteral(event.getLabel());
        description = valueFactory.createLiteral(event.getDescription());
        extractedLink = valueFactory.createLiteral(event.getUrl());
        extractedDate = valueFactory.createLiteral(event.getCrawlTime());

        modelBuilder.add(iri, RDF.TYPE, eventType);
        modelBuilder.add(iri, labelOntology, label);
        modelBuilder.add(iri, descriptionOntology, description);
        modelBuilder.add(iri, extractedDateOntology, extractedDate);
        modelBuilder.add(iri, extractedLinkOntology, extractedLink);

        return iri;
    }

    private IRI addLocation(Location location) {
        IRI iri = valueFactory.createIRI(locationNamespace, location.getId());
        label = valueFactory.createLiteral(location.getLabel());
        description = valueFactory.createLiteral(location.getDescription());
        extractedLink = valueFactory.createLiteral(location.getUrl());
        extractedDate = valueFactory.createLiteral(location.getCrawlTime());

        modelBuilder.add(iri, RDF.TYPE, locationType);
        modelBuilder.add(iri, labelOntology, label);
        modelBuilder.add(iri, descriptionOntology, description);
        modelBuilder.add(iri, extractedDateOntology, extractedDate);
        modelBuilder.add(iri, extractedLinkOntology, extractedLink);

        return iri;
    }

    private IRI addCountry(Country country) {
        IRI iri = valueFactory.createIRI(countryNamespace, country.getId());
        label = valueFactory.createLiteral(country.getLabel());
        description = valueFactory.createLiteral(country.getDescription());
        extractedLink = valueFactory.createLiteral(country.getUrl());
        extractedDate = valueFactory.createLiteral(country.getCrawlTime());

        modelBuilder.add(iri, RDF.TYPE, countryType);
        modelBuilder.add(iri, labelOntology, label);
        modelBuilder.add(iri, descriptionOntology, description);
        modelBuilder.add(iri, extractedDateOntology, extractedDate);
        modelBuilder.add(iri, extractedLinkOntology, extractedLink);

        return iri;
    }

    public IRI add(Entity entity) {
        if (entity instanceof Person) {
            return addPerson((Person) entity);
        } else if (entity instanceof Organization) {
            return addOrgnization((Organization) entity);
        } else if (entity instanceof Event) {
            return addEvent((Event) entity);
        } else if (entity instanceof Location) {
            return addLocation((Location) entity);
        } else if (entity instanceof Country) {
            return addCountry((Country) entity);
        }
        return null;
    }

    public void insertDatabase() {
        connection.add(modelBuilder.build());
        modelBuilder = new ModelBuilder();
    }

    public IRI createRelationship(String relationshipDescription) {
        return valueFactory.createIRI(relationshipNamespace, relationshipDescription);
    }

    public void insertRelationship(IRI entity1, IRI relationship, IRI entity2) {
        modelBuilder.add(entity1, relationship, entity2);
    }

}
