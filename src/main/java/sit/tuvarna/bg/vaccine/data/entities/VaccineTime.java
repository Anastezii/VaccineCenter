package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table(name="vaccine_time")
@Entity
public class VaccineTime implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvaccine_time", nullable = false)
    private Long id_user;

    @Column(name="vaccine_time_date",nullable = false)
    private String vaccine_name;

    @Column(name="vaccine_time_price",nullable = false)
    private String vaccine_price;

    @ManyToOne
    @JoinColumn(name="pet",nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="client",nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name="veterinarian",nullable = false)
    private Veterinarian veterinarian;


    public VaccineTime() {
    }

    public VaccineTime(Long id_user, String vaccine_name, String vaccine_price, Pet pet, Client client, Veterinarian veterinarian) {
        this.id_user = id_user;
        this.vaccine_name = vaccine_name;
        this.vaccine_price = vaccine_price;
        this.pet = pet;
        this.client = client;
        this.veterinarian = veterinarian;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    public String getVaccine_price() {
        return vaccine_price;
    }

    public void setVaccine_price(String vaccine_price) {
        this.vaccine_price = vaccine_price;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    @Override
    public String toString() {
        return "VaccineTime{" +
                "id_user=" + id_user +
                ", vaccine_name='" + vaccine_name + '\'' +
                ", vaccine_price='" + vaccine_price + '\'' +
                ", pet=" + pet +
                ", client=" + client +
                ", veterinarian=" + veterinarian +
                '}';
    }
}
