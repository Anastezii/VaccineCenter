package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "client")
@Entity


public class Client  implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idclient",nullable = false)
    private Long id_client;

    @Column(name="client_name",nullable = false)
    private String name;

    @Column(name="client_age",nullable = false)
    private String age;

    @Column(name="client_phone",nullable = false)
    private String phone;

    @Column(name="client_address",nullable = false)
    private String address;

    @Column(name="client_sex",nullable = false)
    private String sex;

    @OneToMany
    @JoinColumn(name="petCl",nullable = false)
    private Set<Pet> pets;

    @OneToOne
            (fetch=FetchType.EAGER,mappedBy = "client")
    private User user;

    public Client() {
    }

    public Client(Long id_client, String name, String age, String phone, String address, String sex, Set<Pet> pet, User user) {
        this.id_client = id_client;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.pets = pet;
        this.user = user;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Pet> getPet() {
        return pets;
    }

    public void setPet(Set<Pet> pets) {
        this.pets = pets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", pet=" + pets +
                ", user=" + user +
                '}';
    }
}
