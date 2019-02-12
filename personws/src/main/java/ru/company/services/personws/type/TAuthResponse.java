package ru.company.services.personws.type;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Setter
@Getter
public class TAuthResponse {

    @XmlElement
    private TResponseStatus responseStatus;

    @XmlElement
    private String token;
}