package entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "UserDB")
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String username;

    @Column(length = 20)
    private String password;

    @Column(length = 7)
    private String isd;

    @Column(length = 5)
    private String type;

    @Column(length = 320)
    private String email;

    @Column(length = 13)
    private String mobile;

    private boolean confirmed;

    public UserDB(){}

    public UserDB(String username, String password, String isd, String type, String email, String mobile, boolean confirmed) {
        this.username = username;
        this.password = password;
        this.isd = isd;
        this.type = type;
        this.email = email;
        this.mobile = mobile;
        this.confirmed = confirmed;
    }
}
