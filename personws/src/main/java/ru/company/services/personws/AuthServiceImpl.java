package ru.company.services.personws;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.company.services.personws.entity.User;
import ru.company.services.personws.entity.UserSession;
import ru.company.services.personws.type.TAuthRequest;
import ru.company.services.personws.type.TAuthResponse;
import ru.company.services.personws.type.TCheckSessionRequest;
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
            Query<User> personAuth = session.createNamedQuery("UserAuth");
            personAuth.setParameter("login", authRequest.getLogin());
            personAuth.setParameter("password", DigestUtils.md5Hex(authRequest.getPassword()));
            User user = personAuth.uniqueResult();

            if (user != null){
                String token = UUID.randomUUID().toString();
                UserSession userSession = new UserSession();
                userSession.setToken(token);
                userSession.setUser(user);
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

    @WebMethod
    @WebResult(name = "sessionStatus")
    public TResponseStatus checkSession(@WebParam(name = "checkSessionRequest") TCheckSessionRequest checkSessionRequest) {
        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNamedQuery("CheckToken");
        query.setParameter("token", checkSessionRequest.getToken());

        UserSession userSession = (UserSession) query.uniqueResult();
        TResponseStatus responseStatus = new TResponseStatus();

        try {
            if (userSession != null){
                userSession.setExpireDate(new Date()); //обновляем срок действия сессии
                session.update(userSession);
                transaction.commit();
                responseStatus.setCode(0L);
                responseStatus.setMessage("Success");
            } else {
                responseStatus.setCode(403L);
                responseStatus.setMessage("Token is not valid");
            }
        } catch (Exception e){
            transaction.rollback();
        } finally {
            session.close();
        }


        return responseStatus;
    }
}
