package ru.company.services.personws;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.company.services.personws.domain.Person;
import ru.company.services.personws.domain.PersonList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "ru.company.services.personws.PersonService")
public class PersonServiceImpl implements PersonService {

    private static Logger logger = Logger.getLogger(PersonServiceImpl.class);

    @WebMethod
    public void create(Person person) {

        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            person.setId(null); //auto generated
            session.save(person);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            logger.error(e);
        } finally {
            session.close();
        }
    }

    @WebMethod
    public void modify(Person person) {
        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(person);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            logger.error(e);
        } finally {
            session.close();
        }
    }

    @WebMethod
    public void delete(Long id) {
        Session session = DBSessionFactory.getSession();
        try {
            if (id == null){
                throw new HibernateException("required param name id");
            }
            Query personDelete = session.createNamedQuery("PersonDelete");
            personDelete.setParameter("id", id);
            personDelete.executeUpdate();
        } catch (HibernateException e){
            logger.error(e);
        }
        finally {
            session.close();
        }
    }

    @WebMethod
    @WebResult(name = "PersonListResponse")
    public PersonList getList(Person person){
        List<Person> personList = new ArrayList<Person>();
        Session session = DBSessionFactory.getSession();
        try {
            personList = session.createNamedQuery("PersonFindByParams").getResultList();
            for (Person p : personList){
                p.setPassword(null);
            }
        } catch (HibernateException e){
            logger.error(e);
        }
        finally {
            session.close();
        }

        PersonList pl = new PersonList();
        pl.setPersonList(personList);
        return pl;

    }

    @PostConstruct
    private void init (){
        DBSessionFactory.init();
    }

    @PreDestroy
    private void destroy(){
        DBSessionFactory.destroy();
    }

}
