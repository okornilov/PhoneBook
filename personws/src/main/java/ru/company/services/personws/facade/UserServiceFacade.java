package ru.company.services.personws.facade;

import ru.company.services.personws.type.*;

public interface UserServiceFacade {

    TUserCreateResponse userCreate(TUserCreateRequest userCreateRequest);

    TUserUpdateResponse userUpdate(TUserUpdateRequest userUpdateRequest);

    TUserDeleteResponse userDelete(TUserDeleteRequest userDeleteRequest);

    TUserListResponse userGetList(TUserListRequest userListRequest);
}
