
package ru.company.services.personws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.company.services.personws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TUserUpdateRequest_QNAME = new QName("http://personws.services.company.ru/", "tUserUpdateRequest");
    private final static QName _TUserCreateRequest_QNAME = new QName("http://personws.services.company.ru/", "tUserCreateRequest");
    private final static QName _UserUpdate_QNAME = new QName("http://personws.services.company.ru/", "userUpdate");
    private final static QName _TUserListRequest_QNAME = new QName("http://personws.services.company.ru/", "tUserListRequest");
    private final static QName _UserDelete_QNAME = new QName("http://personws.services.company.ru/", "userDelete");
    private final static QName _UserUpdateResponse_QNAME = new QName("http://personws.services.company.ru/", "userUpdateResponse");
    private final static QName _TUserCreateResponse_QNAME = new QName("http://personws.services.company.ru/", "tUserCreateResponse");
    private final static QName _UserDeleteResponse_QNAME = new QName("http://personws.services.company.ru/", "userDeleteResponse");
    private final static QName _UserGetList_QNAME = new QName("http://personws.services.company.ru/", "userGetList");
    private final static QName _TResponseStatus_QNAME = new QName("http://personws.services.company.ru/", "tResponseStatus");
    private final static QName _TUser_QNAME = new QName("http://personws.services.company.ru/", "tUser");
    private final static QName _TUserDeleteRequest_QNAME = new QName("http://personws.services.company.ru/", "tUserDeleteRequest");
    private final static QName _TUserListResponse_QNAME = new QName("http://personws.services.company.ru/", "tUserListResponse");
    private final static QName _UserCreate_QNAME = new QName("http://personws.services.company.ru/", "userCreate");
    private final static QName _UserCreateResponse_QNAME = new QName("http://personws.services.company.ru/", "userCreateResponse");
    private final static QName _TUserDeleteResponse_QNAME = new QName("http://personws.services.company.ru/", "tUserDeleteResponse");
    private final static QName _UserGetListResponse_QNAME = new QName("http://personws.services.company.ru/", "userGetListResponse");
    private final static QName _TUserUpdateResponse_QNAME = new QName("http://personws.services.company.ru/", "tUserUpdateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.company.services.personws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TUserListRequest }
     * 
     */
    public TUserListRequest createTUserListRequest() {
        return new TUserListRequest();
    }

    /**
     * Create an instance of {@link UserDelete }
     * 
     */
    public UserDelete createUserDelete() {
        return new UserDelete();
    }

    /**
     * Create an instance of {@link UserUpdate }
     * 
     */
    public UserUpdate createUserUpdate() {
        return new UserUpdate();
    }

    /**
     * Create an instance of {@link TUserCreateRequest }
     * 
     */
    public TUserCreateRequest createTUserCreateRequest() {
        return new TUserCreateRequest();
    }

    /**
     * Create an instance of {@link TUserUpdateRequest }
     * 
     */
    public TUserUpdateRequest createTUserUpdateRequest() {
        return new TUserUpdateRequest();
    }

    /**
     * Create an instance of {@link UserGetList }
     * 
     */
    public UserGetList createUserGetList() {
        return new UserGetList();
    }

    /**
     * Create an instance of {@link UserDeleteResponse }
     * 
     */
    public UserDeleteResponse createUserDeleteResponse() {
        return new UserDeleteResponse();
    }

    /**
     * Create an instance of {@link TUserCreateResponse }
     * 
     */
    public TUserCreateResponse createTUserCreateResponse() {
        return new TUserCreateResponse();
    }

    /**
     * Create an instance of {@link UserUpdateResponse }
     * 
     */
    public UserUpdateResponse createUserUpdateResponse() {
        return new UserUpdateResponse();
    }

    /**
     * Create an instance of {@link UserCreateResponse }
     * 
     */
    public UserCreateResponse createUserCreateResponse() {
        return new UserCreateResponse();
    }

    /**
     * Create an instance of {@link UserCreate }
     * 
     */
    public UserCreate createUserCreate() {
        return new UserCreate();
    }

    /**
     * Create an instance of {@link TUserDeleteRequest }
     * 
     */
    public TUserDeleteRequest createTUserDeleteRequest() {
        return new TUserDeleteRequest();
    }

    /**
     * Create an instance of {@link TUserListResponse }
     * 
     */
    public TUserListResponse createTUserListResponse() {
        return new TUserListResponse();
    }

    /**
     * Create an instance of {@link TUser }
     * 
     */
    public TUser createTUser() {
        return new TUser();
    }

    /**
     * Create an instance of {@link TResponseStatus }
     * 
     */
    public TResponseStatus createTResponseStatus() {
        return new TResponseStatus();
    }

    /**
     * Create an instance of {@link TUserUpdateResponse }
     * 
     */
    public TUserUpdateResponse createTUserUpdateResponse() {
        return new TUserUpdateResponse();
    }

    /**
     * Create an instance of {@link UserGetListResponse }
     * 
     */
    public UserGetListResponse createUserGetListResponse() {
        return new UserGetListResponse();
    }

    /**
     * Create an instance of {@link TUserDeleteResponse }
     * 
     */
    public TUserDeleteResponse createTUserDeleteResponse() {
        return new TUserDeleteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserUpdateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserUpdateRequest")
    public JAXBElement<TUserUpdateRequest> createTUserUpdateRequest(TUserUpdateRequest value) {
        return new JAXBElement<TUserUpdateRequest>(_TUserUpdateRequest_QNAME, TUserUpdateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserCreateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserCreateRequest")
    public JAXBElement<TUserCreateRequest> createTUserCreateRequest(TUserCreateRequest value) {
        return new JAXBElement<TUserCreateRequest>(_TUserCreateRequest_QNAME, TUserCreateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userUpdate")
    public JAXBElement<UserUpdate> createUserUpdate(UserUpdate value) {
        return new JAXBElement<UserUpdate>(_UserUpdate_QNAME, UserUpdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserListRequest")
    public JAXBElement<TUserListRequest> createTUserListRequest(TUserListRequest value) {
        return new JAXBElement<TUserListRequest>(_TUserListRequest_QNAME, TUserListRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userDelete")
    public JAXBElement<UserDelete> createUserDelete(UserDelete value) {
        return new JAXBElement<UserDelete>(_UserDelete_QNAME, UserDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userUpdateResponse")
    public JAXBElement<UserUpdateResponse> createUserUpdateResponse(UserUpdateResponse value) {
        return new JAXBElement<UserUpdateResponse>(_UserUpdateResponse_QNAME, UserUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserCreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserCreateResponse")
    public JAXBElement<TUserCreateResponse> createTUserCreateResponse(TUserCreateResponse value) {
        return new JAXBElement<TUserCreateResponse>(_TUserCreateResponse_QNAME, TUserCreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userDeleteResponse")
    public JAXBElement<UserDeleteResponse> createUserDeleteResponse(UserDeleteResponse value) {
        return new JAXBElement<UserDeleteResponse>(_UserDeleteResponse_QNAME, UserDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGetList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userGetList")
    public JAXBElement<UserGetList> createUserGetList(UserGetList value) {
        return new JAXBElement<UserGetList>(_UserGetList_QNAME, UserGetList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TResponseStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tResponseStatus")
    public JAXBElement<TResponseStatus> createTResponseStatus(TResponseStatus value) {
        return new JAXBElement<TResponseStatus>(_TResponseStatus_QNAME, TResponseStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUser")
    public JAXBElement<TUser> createTUser(TUser value) {
        return new JAXBElement<TUser>(_TUser_QNAME, TUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserDeleteRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserDeleteRequest")
    public JAXBElement<TUserDeleteRequest> createTUserDeleteRequest(TUserDeleteRequest value) {
        return new JAXBElement<TUserDeleteRequest>(_TUserDeleteRequest_QNAME, TUserDeleteRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserListResponse")
    public JAXBElement<TUserListResponse> createTUserListResponse(TUserListResponse value) {
        return new JAXBElement<TUserListResponse>(_TUserListResponse_QNAME, TUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserCreate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userCreate")
    public JAXBElement<UserCreate> createUserCreate(UserCreate value) {
        return new JAXBElement<UserCreate>(_UserCreate_QNAME, UserCreate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserCreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userCreateResponse")
    public JAXBElement<UserCreateResponse> createUserCreateResponse(UserCreateResponse value) {
        return new JAXBElement<UserCreateResponse>(_UserCreateResponse_QNAME, UserCreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserDeleteResponse")
    public JAXBElement<TUserDeleteResponse> createTUserDeleteResponse(TUserDeleteResponse value) {
        return new JAXBElement<TUserDeleteResponse>(_TUserDeleteResponse_QNAME, TUserDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGetListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "userGetListResponse")
    public JAXBElement<UserGetListResponse> createUserGetListResponse(UserGetListResponse value) {
        return new JAXBElement<UserGetListResponse>(_UserGetListResponse_QNAME, UserGetListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tUserUpdateResponse")
    public JAXBElement<TUserUpdateResponse> createTUserUpdateResponse(TUserUpdateResponse value) {
        return new JAXBElement<TUserUpdateResponse>(_TUserUpdateResponse_QNAME, TUserUpdateResponse.class, null, value);
    }

}
