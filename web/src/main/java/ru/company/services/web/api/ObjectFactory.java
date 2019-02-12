
package ru.company.services.web.api;

import ru.company.services.personws.Person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.company.services.personws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Person_QNAME = new QName("http://personws.services.company.ru/", "person");
    private final static QName _PersonList_QNAME = new QName("http://personws.services.company.ru/", "personList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.company.services.personws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PersonList }
     * 
     */
    public PersonList createPersonList() {
        return new PersonList();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "personList")
    public JAXBElement<PersonList> createPersonList(PersonList value) {
        return new JAXBElement<PersonList>(_PersonList_QNAME, PersonList.class, null, value);
    }

}
