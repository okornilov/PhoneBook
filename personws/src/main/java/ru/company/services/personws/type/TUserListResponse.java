package ru.company.services.personws.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class TUserListResponse {

    @XmlElement
    TResponseStatus responseStatus;

    @XmlElement(name = "user")
    List<TUser> users;

    @XmlElement
    Long totalCount;

    public TUserListResponse() {
        this.users = new ArrayList<TUser>();
    }
}
