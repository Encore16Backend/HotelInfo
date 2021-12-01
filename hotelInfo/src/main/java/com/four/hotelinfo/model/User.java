package com.four.hotelinfo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER_TBL")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long seq;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String password;
    // 0 = 관리자, 1 = 일반사용자
    @Column(nullable = false, updatable = false)
    private int login_status;

    public User() {

    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    @Override
    public String toString() {
        return "user{" +
                "seq=" + seq +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", login_status=" + login_status +
                '}';
    }
}
