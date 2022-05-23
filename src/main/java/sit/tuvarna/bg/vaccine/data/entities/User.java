package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import org.hibernate.annotations.Entity;

@Table(name = "user")
@Entity

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser",nullable = false)
    private Long id_user;

    @Column(name="user_login",nullable = false)
    private String login;

    @Column(name="user_pass",nullable = false)
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(name="user_type",nullable = false,referencedColumnName="iduser_type")
    private UserType user_type;

    @OneToOne(optional = false)
    @JoinColumn(name="clientId",nullable = true)
    private Client client;

    @OneToOne(optional = false)
    @JoinColumn(name="veterinarianId",nullable = true,referencedColumnName = "idveterinarian")
    private Veterinarian veterinar;


    public User() {
    }

    public User(Long id_user, String login, String password, UserType user_type, Client client, Veterinarian veterinar) {
        this.id_user = id_user;
        this.login = login;
        this.password = password;
        this.user_type = user_type;
        this.client = client;
        this.veterinar = veterinar;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Veterinarian getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinarian veterinar) {
        this.veterinar = veterinar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", user_type=" + user_type +
                ", client=" + client +
                ", veterinar=" + veterinar +
                '}';
    }
}
