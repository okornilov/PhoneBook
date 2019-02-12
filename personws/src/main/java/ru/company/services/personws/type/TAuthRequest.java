package ru.company.services.personws.type;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Getter
@Setter
public class TAuthRequest {

    @XmlElement
    private String login;

    @XmlElement
    private String password;

}
