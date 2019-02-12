package ru.company.services.web.beans;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import lombok.Data;
import ru.company.services.personws.Person;
import ru.company.services.web.api.PersonList;
import ru.company.services.web.api.PersonService;
import ru.company.services.web.api.PersonServiceImplService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
@Data
public class UserListBean {

    private List<Person> personList;


    @PostConstruct
    public void init(){
        PersonServiceImplService personService = new PersonServiceImplService();
        PersonService personServiceImplPort = personService.getPersonServiceImplPort();
        PersonList list = personServiceImplPort.getList(new Person());
        personList = list.getPerson();
    }

    @PreDestroy
    public void destroy(){
    }

}
