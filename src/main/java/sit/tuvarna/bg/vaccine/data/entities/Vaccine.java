package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table(name="vaccine")
@Entity
public class Vaccine implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvaccine", nullable = false)
    private Long id_vaccine;

    @Column(name="vaccine_name",nullable = false)
    private String vaccine_name;

    public Vaccine() {
    }

    public Vaccine(Long id_user, String vaccine_name) {
        this.id_vaccine = id_user;
        this.vaccine_name = vaccine_name;
    }

    public Long getId_vaccine() {
        return id_vaccine;
    }

    public void setId_vaccine(Long id_vaccine) {
        this.id_vaccine = id_vaccine;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id_user=" + id_vaccine +
                ", vaccine_name='" + vaccine_name + '\'' +
                '}';
    }
}
