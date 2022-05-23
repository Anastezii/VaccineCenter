package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import org.hibernate.annotations.Entity;

@Table(name = "veterinarian")
@Entity


public class Veterinarian  implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idveterinarian",nullable = false)
    private Long id_veterinarian;

    @Column(name="veterinarian_name",nullable = false)
    private String name;

    @Column(name="veterinarian_speciality",nullable = false)
    private String speciality;

    @Column(name="veterinarian_age",nullable = false)
    private String age;

    @Column(name="veterinarian_phone_number",nullable = false)
    private String phone;

    @Column(name="veterinarian_sex",nullable = false)
    private String sex;

    @OneToOne
            (mappedBy = "veterinar")
    private User user;

    @OneToMany
            (fetch=FetchType.EAGER,mappedBy = "veterinarian")
    private Set<VaccineTime> vaccineTimes;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<VaccineTime> getVaccineTimes() {
        return vaccineTimes;
    }

    public void setVaccineTimes(Set<VaccineTime> vaccineTimes) {
        this.vaccineTimes = vaccineTimes;
    }

    public Veterinarian() {
    }

    public Veterinarian(Long id_veterinarian, String name, String speciality, String age, String phone) {
        this.id_veterinarian = id_veterinarian;
        this.name = name;
        this.speciality = speciality;
        this.age = age;
        this.phone = phone;
    }

    public Veterinarian(Long id_veterinarian, String name, String speciality, String age, String phone, String sex) {
        this.id_veterinarian = id_veterinarian;
        this.name = name;
        this.speciality = speciality;
        this.age = age;
        this.phone = phone;
        this.sex = sex;
    }

    public Long getId_veterinarian() {
        return id_veterinarian;
    }

    public void setId_veterinarian(Long id_veterinarian) {
        this.id_veterinarian = id_veterinarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id_veterinarian=" + id_veterinarian +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
