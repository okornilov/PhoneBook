package ru.company.services.personws;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.company.services.personws.entity.UserEntity;
import ru.company.services.personws.type.TAuthRequest;
import ru.company.services.personws.type.TAuthResponse;
import ru.company.services.personws.type.TResponseStatus;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.UUID;

@WebService
public class AuthServiceImpl implements AuthService {

    @WebMethod
    @WebResult(name = "authResponse")
    public TAuthResponse auth(@WebParam(name = "authRequest") TAuthRequest authRequest) {
        Session session = DBSessionFactory.getSession();
        TAuthResponse authResponse = new TAuthResponse();
        UserEntity userEntity = null;

        try {
            Query<UserEntity> personAuth = session.createNamedQuery("PersonAuth", UserEntity.class);
            personAuth.setParameter("login", authRequest.getLogin());
            personAuth.setParameter("password", authRequest.getPassword());
            userEntity = personAuth.uniqueResult();
        } finally {
            session.close();
            if (userEntity != null){
                authResponse.setToken(UUID.randomUUID().toString());
                authResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
            } else {
                authResponse.setResponseStatus(new TResponseStatus(403L, "Unauthorized"));
            }
        }
        return authResponse;
    }
}
