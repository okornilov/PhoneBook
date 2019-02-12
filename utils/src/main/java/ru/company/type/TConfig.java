package ru.company.type;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Getter
@Setter
public class TConfig {

    @XmlElement
    private TDataBase database;

    @XmlElement
    private String hostUrl;
}
