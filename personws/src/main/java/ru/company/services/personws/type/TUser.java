package ru.company.services.personws.type;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class TUser {

    @XmlElement
    private Long id;

    @XmlElement
    private String login;

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElement
    private String middleName;

    @XmlElement
    private Date birthDate;

    @XmlElement
    private String phoneCode;

    @XmlElement
    private String phoneNumber;

    @XmlElement
    private String email;
}
