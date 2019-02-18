package ru.company.services.personws;

import ru.company.services.personws.type.TAuthRequest;
import ru.company.services.personws.type.TAuthResponse;
import ru.company.services.personws.type.TCheckSessionRequest;
import ru.company.services.personws.type.TResponseStatus;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AuthService {

    @WebMethod
    @WebResult(name = "authResponse")
    TAuthResponse auth(@WebParam(name = "authRequest") TAuthRequest authRequest);

    @WebMethod
    @WebResult(name = "sessionStatus")
    TResponseStatus checkSession(@WebParam(name = "checkSessionRequest") TCheckSessionRequest checkSessionRequest);
}
