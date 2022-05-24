package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Table(name = "user_type")
@Entity


public class UserType  implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser_type",nullable = false)
    private Long id_user_type;


    @Column(name="user_type_name",nullable = false)
    private String type_name;

    @OneToOne
    (mappedBy = "user_type")
    private User users;


    public UserType() {
    }

    public UserType(Long id_user_type, String type_name,  User users) {
        this.id_user_type = id_user_type;
        this.type_name = type_name;
        this.users = users;
    }

    public Long getId_user_type() {
        return id_user_type;
    }

    public void setId_user_type(Long id_user_type) {
        this.id_user_type = id_user_type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public  User getUsers() {
        return users;
    }

    public void setUsers( User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id_user_type=" + id_user_type +
                ", type_name='" + type_name + '\'' +
                ", users=" + users +
                '}';
    }
}
