package ru.company.services.personws.entity;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;

@Entity
@Table(name = "pb_user")
@Data
@NoArgsConstructor
@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(name = "UserGetList",
            query = "from User where lower(firstName) like :searchText or lower(lastName) " +
                    "like :searchText or lower(middleName) like :searchText order by id"),
    @org.hibernate.annotations.NamedQuery(name = "UserGetListCount",
            query = "select count(*) from User where lower(firstName) like :searchText or lower(lastName) " +
                    "like :searchText or lower(middleName) like :searchText order by id"),
    @org.hibernate.annotations.NamedQuery(name = "UserDelete",
            query = "delete from User where id=:id"),
    @org.hibernate.annotations.NamedQuery(name = "UserAuth",
            query = "from User where login=:login and password=:password")
})
public class User {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "seq_user", initialValue = 1000, allocationSize = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userSeq")
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

    @Column
    private byte[] image;

}
