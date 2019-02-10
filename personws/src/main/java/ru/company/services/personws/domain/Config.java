package ru.company.services.personws.domain;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Getter
public class Config {

    @XmlElement
    private DataBase database;

}
