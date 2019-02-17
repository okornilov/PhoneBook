package ru.company.services.personws;

import ru.company.services.personws.type.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

    @WebMethod
    @WebResult(name = "userCreateResponse")
    TUserCreateResponse userCreate(@WebParam(name = "userCreateRequest") TUserCreateRequest userCreateRequest);

    @WebMethod
    @WebResult(name = "userUpdateResponse")
    TUserUpdateResponse userUpdate(@WebParam(name = "userUpdateRequest") TUserUpdateRequest userUpdateRequest);

    @WebMethod
    @WebResult(name = "userDeleteResponse")
    TUserDeleteResponse userDelete(@WebParam(name = "userDeleteRequest") TUserDeleteRequest userDeleteRequest);

    @WebMethod
    @WebResult(name = "userListResponse")
    TUserListResponse userGetList(@WebParam(name = "userRequest") TUserListRequest userListRequest);

}
