package ru.company.services.personws.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "pb_user_session", indexes = {
        @Index(name = "PB_USER_INDEX_0", columnList = "token")
})
@NamedQueries({
        @NamedQuery(name = "CheckToken", query = "from UserSession where token = :token and expireDate > current_timestamp")
})
@Data
public class UserSession {

    @Id
    @SequenceGenerator(name = "userSessionSeq", sequenceName = "seq_user_session", initialValue = 1000, allocationSize = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userSessionSeq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private Date expireDate;

    public void setExpireDate(@NonNull Date expireDate) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(expireDate);
        calendar.add(Calendar.MINUTE, 5);
        this.expireDate = calendar.getTime();
    }
}
