package ru.company.services.personws.type;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
@Setter
public class TResponseStatus {

    @XmlElement
    private Long code;

    @XmlElement
    private String message;

    public TResponseStatus(Long code, String message) {
        this.code = code;
        this.message = message;
    }
}
