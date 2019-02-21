package ru.company.services.personws;

import ru.company.services.personws.facade.UserServiceFacade;
import ru.company.services.personws.facade.UserServiceFacadeImpl;
import ru.company.services.personws.type.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.*;

@WebService
@HandlerChain(file = "handlers.xml")
public class UserServiceImpl implements UserService {

    private UserServiceFacade userServiceFacade = new UserServiceFacadeImpl();

    @WebMethod
    @WebResult(name = "userCreateResponse")
    public TUserCreateResponse userCreate(@WebParam(name = "userCreateRequest") TUserCreateRequest userCreateRequest){
        return userServiceFacade.userCreate(userCreateRequest);
    }

    @WebMethod
    @WebResult(name = "userUpdateResponse")
    public TUserUpdateResponse userUpdate(@WebParam(name = "userUpdateRequest") TUserUpdateRequest userUpdateRequest){
        return userServiceFacade.userUpdate(userUpdateRequest);
    }

    @WebMethod
    @WebResult(name = "userDeleteResponse")
    public TUserDeleteResponse userDelete(@WebParam(name = "userDeleteRequest") TUserDeleteRequest userDeleteRequest){
        return userServiceFacade.userDelete(userDeleteRequest);
    }

    @WebMethod
    @WebResult(name = "userListResponse")
    public TUserListResponse userGetList(@WebParam(name = "userRequest") TUserListRequest userListRequest) {
        return userServiceFacade.userGetList(userListRequest);
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
