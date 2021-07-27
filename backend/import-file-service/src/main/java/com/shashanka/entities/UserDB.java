package com.shashanka.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserDB")
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20)
    private String userName;

    @Column(length = 100)
    private String password;

    @Column(length = 7)
    private String isd;

    @Column(length = 10)
    private String mobile;

    @Column(length = 5)
    private String type;

    @Column(length = 320)
    private String email;

    private boolean confirmed;

    public UserDB(String userName, String password, String isd, String mobile, String type, String email, boolean confirmed) {
        this.userName = userName;
        this.password = password;
        this.isd = isd;
        this.mobile = mobile;
        this.type = type;
        this.email = email;
        this.confirmed = confirmed;
    }

    public UserDB(String userName, String password, String isd, String mobile, String email) {
        this.userName = userName;
        this.password = password;
        this.isd = isd;
        this.mobile = mobile;
        this.email = email;
    }
}
