package ru.company.services.personws;

import ru.company.services.personws.facade.AuthServiceFacade;
import ru.company.services.personws.facade.AuthServiceFacadeImpl;
import ru.company.services.personws.type.TAuthRequest;
import ru.company.services.personws.type.TAuthResponse;
import ru.company.services.personws.type.TCheckSessionRequest;
import ru.company.services.personws.type.TResponseStatus;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class AuthServiceImpl implements AuthService {

    private AuthServiceFacade authServiceFacade = new AuthServiceFacadeImpl();

    @WebMethod
    @WebResult(name = "authResponse")
    public TAuthResponse auth(@WebParam(name = "authRequest") TAuthRequest authRequest) {
        return authServiceFacade.auth(authRequest);
    }

    @WebMethod
    @WebResult(name = "sessionStatus")
    public TResponseStatus checkSession(@WebParam(name = "checkSessionRequest") TCheckSessionRequest checkSessionRequest) {
        return authServiceFacade.checkSession(checkSessionRequest);
    }
}
