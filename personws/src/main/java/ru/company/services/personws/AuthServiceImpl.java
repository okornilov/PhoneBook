package ru.company.services.personws;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.company.services.personws.entity.UserEntity;
import ru.company.services.personws.entity.UserSession;
import ru.company.services.personws.type.TAuthRequest;
import ru.company.services.personws.type.TAuthResponse;
import ru.company.services.personws.type.TResponseStatus;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Date;
import java.util.UUID;

@WebService
public class AuthServiceImpl implements AuthService {

    @WebMethod
    @WebResult(name = "authResponse")
    public TAuthResponse auth(@WebParam(name = "authRequest") TAuthRequest authRequest) {
        Session session = DBSessionFactory.getSession();
        TAuthResponse authResponse = new TAuthResponse();

        try {
            Query<UserEntity> personAuth = session.createNamedQuery("UserAuth");
            personAuth.setParameter("login", authRequest.getLogin());
            personAuth.setParameter("password", authRequest.getPassword());
            UserEntity userEntity = personAuth.uniqueResult();

            if (userEntity != null){
                String token = UUID.randomUUID().toString();
                UserSession userSession = new UserSession();
                userSession.setToken(token);
                userSession.setUser(userEntity);
                userSession.setExpireDate(new Date());

                Session dbSession = DBSessionFactory.getSession();
                Transaction transaction = dbSession.beginTransaction();
                try {
                    dbSession.save(userSession);
                    transaction.commit();
                } catch (Exception e){
                    transaction.rollback();
                } finally {
                    dbSession.close();
                }

                authResponse.setToken(token);
                authResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
            } else {
                authResponse.setResponseStatus(new TResponseStatus(403L, "Incorrect login or password"));
            }
        }catch (HibernateException e){
            authResponse.setResponseStatus(new TResponseStatus(500L, e.getMessage()));
        } finally {
            session.close();
        }
        return authResponse;
    }
}
