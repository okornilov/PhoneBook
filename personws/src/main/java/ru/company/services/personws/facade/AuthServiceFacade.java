package ru.company.services.personws.facade;

import ru.company.services.personws.type.TAuthRequest;
import ru.company.services.personws.type.TAuthResponse;
import ru.company.services.personws.type.TCheckSessionRequest;
import ru.company.services.personws.type.TResponseStatus;

public interface AuthServiceFacade {

    TAuthResponse auth(TAuthRequest authRequest);

    TResponseStatus checkSession(TCheckSessionRequest checkSessionRequest);
}
