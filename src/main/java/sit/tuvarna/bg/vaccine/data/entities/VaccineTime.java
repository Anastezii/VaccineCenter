package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Table(name="vaccine_time")
@Entity

public class VaccineTime implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvaccine_time", nullable = false)
    private Long id_vaccine_time;

    @Column(name="vaccine_time_date",nullable = false)
    private LocalDate vaccine_date;

    @Column(name="vaccine_time_price",nullable = false)
    private String vaccine_price;

    @ManyToOne
    @JoinColumn(name="pet",nullable = false,referencedColumnName = "idpet")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="client",nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name="veterinarian",nullable = false)
    private Veterinarian veterinarian;

    @OneToOne
    @JoinColumn(name="vaccine_name",nullable = false)
    private Vaccine vaccineSet;


    public VaccineTime() {
    }

    public VaccineTime(Long id_vaccine_time, LocalDate vaccine_date, String vaccine_price, Client client, Veterinarian veterinarian, Vaccine vaccineSet) {
        this.id_vaccine_time = id_vaccine_time;
        this.vaccine_date = vaccine_date;
        this.vaccine_price = vaccine_price;
        this.pet = pet;
        this.client = client;
        this.veterinarian = veterinarian;
        this.vaccineSet = vaccineSet;
    }

    public Long getId_vaccine_time() {
        return id_vaccine_time;
    }

    public void setId_vaccine_time(Long id_vaccine_time) {
        this.id_vaccine_time = id_vaccine_time;
    }

    public LocalDate getVaccine_date() {
        return vaccine_date;
    }

    public void setVaccine_date(LocalDate vaccine_date) {
        this.vaccine_date = vaccine_date;
    }

    public Vaccine getVaccineSet() {
        return vaccineSet;
    }

    public void setVaccineSet(Vaccine vaccineSet) {
        this.vaccineSet = vaccineSet;
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
                "id_vaccine_time=" + id_vaccine_time +
                ", vaccine_date=" + vaccine_date +
                ", vaccine_price='" + vaccine_price + '\'' +
                ", pet=" + pet +
                ", client=" + client +
                ", veterinarian=" + veterinarian +
                ", vaccineSet=" + vaccineSet +
                '}';
    }
}
