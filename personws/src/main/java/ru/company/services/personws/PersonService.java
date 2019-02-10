package ru.company.services.personws;

import ru.company.services.personws.domain.Person;
import ru.company.services.personws.domain.PersonList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonService {

    @WebMethod
    void create(@WebParam Person person);

    @WebMethod
    void modify(@WebParam Person person);

    @WebMethod
    void delete(@WebParam(name = "id") Long id);

    @WebMethod
    PersonList getList(@WebParam Person person);

}
