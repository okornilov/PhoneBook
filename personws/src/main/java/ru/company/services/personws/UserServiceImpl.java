package ru.company.services.personws;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.company.services.personws.entity.UserEntity;
import ru.company.services.personws.type.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @WebMethod
    @WebResult(name = "userCreateResponse")
    public TUserCreateResponse userCreate(@WebParam(name = "userCreateRequest") TUserCreateRequest userCreateRequest){
        TUserCreateResponse tUserCreateResponse = new TUserCreateResponse();
        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(userCreateRequest.getFirstName());
            userEntity.setLastName(userCreateRequest.getLastName());
            userEntity.setMiddleName(userCreateRequest.getMiddleName());
            userEntity.setBirthDate(userCreateRequest.getBirthDate());
            userEntity.setLogin(userCreateRequest.getLogin());
            userEntity.setPassword(userCreateRequest.getPassword());
            userEntity.setPhoneCode(userCreateRequest.getPhoneCode());
            userEntity.setPhoneNumber(userCreateRequest.getPhoneNumber());
            Long id = (Long) session.save(userEntity);
            transaction.commit();
            tUserCreateResponse.setUserId(id);
            tUserCreateResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
        } catch (HibernateException e){
            transaction.rollback();
            logger.error(e);
            tUserCreateResponse.setResponseStatus(new TResponseStatus(500L, e.getMessage()));
        } finally {
            session.close();
        }

        return tUserCreateResponse;
    };

    @WebMethod
    @WebResult(name = "userUpdateResponse")
    public TUserUpdateResponse userUpdate(@WebParam(name = "userUpdateRequest") TUserUpdateRequest userUpdateRequest){
        TUserUpdateResponse tUserUpdateResponse = new TUserUpdateResponse();

        if (userUpdateRequest.getUserId() == null){
            tUserUpdateResponse.setResponseStatus(new TResponseStatus(500L, "Missing required param userId"));
            return tUserUpdateResponse;
        }

        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserEntity userEntity = session.load(UserEntity.class, userUpdateRequest.getUserId());
            if (userUpdateRequest.getFirstName() != null){
                userEntity.setFirstName(userUpdateRequest.getFirstName());
            }
            if (userUpdateRequest.getLastName() != null){
                userEntity.setLastName(userUpdateRequest.getLastName());
            }
            if (userUpdateRequest.getMiddleName() != null){
                userEntity.setMiddleName(userUpdateRequest.getMiddleName());
            }
            if (userUpdateRequest.getBirthDate() != null){
                userEntity.setBirthDate(userUpdateRequest.getBirthDate());
            }
            if (userUpdateRequest.getLogin() != null){
                userEntity.setLogin(userUpdateRequest.getLogin());
            }
            if (userUpdateRequest.getPassword() != null){
                userEntity.setPassword(userUpdateRequest.getPassword());
            }
            if (userUpdateRequest.getPhoneCode() != null){
                userEntity.setPhoneCode(userUpdateRequest.getPhoneCode());
            }
            if (userUpdateRequest.getPhoneNumber() != null){
                userEntity.setPhoneNumber(userUpdateRequest.getPhoneNumber());
            }
            session.update(userEntity);
            transaction.commit();
            tUserUpdateResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
        } catch (HibernateException e){
            transaction.rollback();
            logger.error(e);
            tUserUpdateResponse.setResponseStatus(new TResponseStatus(500L, e.getMessage()));
        } finally {
            session.close();
        }
        return tUserUpdateResponse;
    };

    @WebMethod
    @WebResult(name = "userDeleteResponse")
    public TUserDeleteResponse userDelete(@WebParam(name = "userDeleteRequest") TUserDeleteRequest userDeleteRequest){
        TUserDeleteResponse tUserDeleteResponse = new TUserDeleteResponse();

        if (userDeleteRequest.getUserId() == null){
            tUserDeleteResponse.setResponseStatus(new TResponseStatus(500L, "Missing required param userId"));
            return tUserDeleteResponse;
        }

        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query personDelete = session.createNamedQuery("PersonDelete");
            personDelete.setParameter("id", userDeleteRequest.getUserId());
            personDelete.executeUpdate();
            transaction.commit();
            tUserDeleteResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
        } catch (HibernateException e){
            logger.error(e);
            transaction.rollback();
            tUserDeleteResponse.setResponseStatus(new TResponseStatus(500L, e.getMessage()));
        }
        finally {
            session.close();
        }
        return tUserDeleteResponse;
    };

    @WebMethod
    @WebResult(name = "userListResponse")
    public TUserListResponse userGetList(@WebParam(name = "userRequest") TUser user) {
        TUserListResponse userListResponse = new TUserListResponse();

        Session session = DBSessionFactory.getSession();
        try {
            List<UserEntity> resultList = session.createNamedQuery("PersonFindByParams", UserEntity.class).getResultList();
            for (UserEntity p : resultList) {
                TUser tUser = new TUser();
                tUser.setId(p.getId());
                tUser.setFirstName(p.getFirstName());
                tUser.setLastName(p.getLastName());
                tUser.setMiddleName(p.getMiddleName());
                tUser.setBirthDate(p.getBirthDate());
                tUser.setLogin(p.getLogin());
                tUser.setPhoneCode(p.getPhoneCode());
                tUser.setPhoneNumber(p.getPhoneNumber());
                userListResponse.getUsers().add(tUser);
                userListResponse.setTotalCount(resultList.size());
            }
            userListResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
        } catch (HibernateException e){
            logger.error(e);
            userListResponse.setResponseStatus(new TResponseStatus(500L, e.getMessage()));
        }
        finally {
            session.close();
        }

        return userListResponse;
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
