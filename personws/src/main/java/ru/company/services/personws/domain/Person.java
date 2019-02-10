package ru.company.services.personws.domain;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(name = "PersonFindByParams",
            query = "from Person order by id"),
    @org.hibernate.annotations.NamedQuery(name = "PersonDelete",
            query = "delete from Person where id=:id")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement
    private Long id;

    @Column(nullable = false)
    @NonNull
    @XmlElement
    private String login;

    @Column(nullable = false)
    @XmlElement
    private String password;

    @Column(nullable = false)
    @NonNull
    @XmlElement
    private String firstName;

    @Column(nullable = false)
    @NonNull
    @XmlElement
    private String lastName;

    @Column
    @XmlElement
    private String middleName;

    @Column
    @XmlElement
    private Date birthDate;

    @Column(nullable = false)
    @NonNull
    @XmlElement
    private String phoneCode;

    @Column(nullable = false)
    @NonNull
    @XmlElement
    private String phoneNumber;

}
