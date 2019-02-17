package ru.company.services.personws.entity;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(name = "UserGetList",
            query = "from UserEntity where lower(firstName) like :searchText or lower(lastName) " +
                    "like :searchText or lower(middleName) like :searchText order by id"),
    @org.hibernate.annotations.NamedQuery(name = "UserGetListCount",
            query = "select count(*) from UserEntity where lower(firstName) like :searchText or lower(lastName) " +
                    "like :searchText or lower(middleName) like :searchText order by id"),
    @org.hibernate.annotations.NamedQuery(name = "UserDelete",
            query = "delete from UserEntity where id=:id"),
    @org.hibernate.annotations.NamedQuery(name = "UserAuth",
            query = "from UserEntity where login=:login and password=:password")
})
public class UserEntity {

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

    @Column
    private byte[] image;

}
