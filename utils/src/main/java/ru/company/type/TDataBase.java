package ru.company.type;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "database")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Getter
@Setter
public class TDataBase {

    @XmlElement
    @NonNull
    private String url;

    @XmlElement
    @NonNull
    private String user;

    @XmlElement
    @NonNull
    private String password;

}
