package ru.company.services.personws.facade;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import ru.company.services.personws.DBSessionFactory;
import ru.company.services.personws.UserServiceImpl;
import ru.company.services.personws.entity.User;
import ru.company.services.personws.type.*;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserServiceFacadeImpl implements UserServiceFacade {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    public TUserCreateResponse userCreate(TUserCreateRequest userCreateRequest) {
        TUserCreateResponse tUserCreateResponse = new TUserCreateResponse();
        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = remapUser(userCreateRequest);
            user.setPassword(userCreateRequest.getPassword());

            Long id = (Long) session.save(user);
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
    }

    public TUserUpdateResponse userUpdate(TUserUpdateRequest userUpdateRequest) {
        TUserUpdateResponse tUserUpdateResponse = new TUserUpdateResponse();

        if (userUpdateRequest.getUserId() == null){
            tUserUpdateResponse.setResponseStatus(new TResponseStatus(500L, "Missing required param userId"));
            return tUserUpdateResponse;
        }

        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.load(User.class, userUpdateRequest.getUserId());
            if (userUpdateRequest.getFirstName() != null){
                user.setFirstName(userUpdateRequest.getFirstName());
            }
            if (userUpdateRequest.getLastName() != null){
                user.setLastName(userUpdateRequest.getLastName());
            }
            if (userUpdateRequest.getMiddleName() != null){
                user.setMiddleName(userUpdateRequest.getMiddleName());
            }
            if (userUpdateRequest.getBirthDate() != null){
                user.setBirthDate(userUpdateRequest.getBirthDate());
            }
            if (userUpdateRequest.getLogin() != null){
                user.setLogin(userUpdateRequest.getLogin());
            }
            if (userUpdateRequest.getPassword() != null){
                user.setPassword(userUpdateRequest.getPassword());
            }
            if (userUpdateRequest.getPhoneCode() != null){
                user.setPhoneCode(userUpdateRequest.getPhoneCode());
            }
            if (userUpdateRequest.getPhoneNumber() != null){
                user.setPhoneNumber(userUpdateRequest.getPhoneNumber());
            }

            if (userUpdateRequest.getEmail() != null){
                user.setEmail(userUpdateRequest.getEmail());
            }

            if (userUpdateRequest.getImage() != null){
                user.setImage(Base64.decodeBase64(userUpdateRequest.getImage()));
            }

            session.update(user);
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
    }

    public TUserDeleteResponse userDelete(TUserDeleteRequest userDeleteRequest) {
        TUserDeleteResponse tUserDeleteResponse = new TUserDeleteResponse();

        if (userDeleteRequest.getUserId() == null){
            tUserDeleteResponse.setResponseStatus(new TResponseStatus(500L, "Missing required param userId"));
            return tUserDeleteResponse;
        }

        Session session = DBSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query personDelete = session.createNamedQuery("UserDelete");
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
    }

    public TUserListResponse userGetList(TUserListRequest userListRequest) {
        TUserListResponse userListResponse = new TUserListResponse();
        Integer page = userListRequest.getPage();
        Integer rowsCount = userListRequest.getRowsCount();

        if (page == null) {
            page = 1;
        }

        if (rowsCount == null){
            rowsCount = 10;
        }

        Session session = DBSessionFactory.getSession();
        try {
            Query namedQuery = session.createNamedQuery("UserGetList");
            if (userListRequest.getSearchText() != null){
                namedQuery.setParameter("searchText", "%"+ userListRequest.getSearchText().toLowerCase() + "%");
            } else {
                namedQuery.setParameter("searchText", "%");
            }

            namedQuery.setFirstResult(rowsCount * ( (page-1) ) );
            namedQuery.setMaxResults(rowsCount);

            List<User> resultList = namedQuery.getResultList();
            Long count = (Long) session.createCriteria(User.class)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();

            for (User p : resultList) {
                TUser tUser = new TUser();
                tUser.setId(p.getId());
                tUser.setFirstName(p.getFirstName());
                tUser.setLastName(p.getLastName());
                tUser.setMiddleName(p.getMiddleName());
                tUser.setBirthDate(p.getBirthDate());
                tUser.setLogin(p.getLogin());
                tUser.setPhoneCode(p.getPhoneCode());
                tUser.setPhoneNumber(p.getPhoneNumber());
                tUser.setEmail(p.getEmail());
                tUser.setImage(Base64.encodeBase64String(p.getImage()));
                userListResponse.getUsers().add(tUser);
                userListResponse.setTotalCount(count);
            }
            userListResponse.setResponseStatus(new TResponseStatus(0L, "No errors"));
        } catch (Exception e){
            logger.error(e);
            userListResponse.setResponseStatus(new TResponseStatus(500L, e.getMessage()));
        }
        finally {
            session.close();
        }

        return userListResponse;
    }

    private User remapUser(TUserRequestBase userRequest){
        User user = new User();
        user.setBirthDate(userRequest.getBirthDate());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setMiddleName(userRequest.getMiddleName());
        user.setBirthDate(userRequest.getBirthDate());
        user.setLogin(userRequest.getLogin());
        user.setPhoneCode(userRequest.getPhoneCode());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());

        if (userRequest.getImage() != null){
            user.setImage(Base64.decodeBase64(userRequest.getImage()));
        }

        return user;
    }
}
