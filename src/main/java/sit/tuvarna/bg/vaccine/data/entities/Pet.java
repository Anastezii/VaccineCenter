package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import org.hibernate.annotations.Entity;

@Table(name = "pet")
@Entity

public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpet",nullable = false)
    private Long id_pet;

    @Column(name="pet_name",nullable = false)
    private String pet_name;

    @Column(name="pet_weight",nullable = false)
    private String pet_weight;

    @Column(name="pet_year_birth",nullable = false)
    private int pet_year_birth;

    @ManyToOne(optional = false)
    @JoinColumn(name="pet_type",nullable = false)
    private PetType pet_type;

    @Column(name="pet_sex",nullable = false)
    private String pet_sex;

    @Column(name="pet_category",nullable = false)
    private String pet_category;

    @ManyToOne
            (fetch = FetchType.LAZY)
    private Client client;

    @OneToMany
            (fetch=FetchType.EAGER,mappedBy = "pet")
    private Set<VaccineTime> vaccineTimes;

    public Set<VaccineTime> getVaccineTimes() {
        return vaccineTimes;
    }

    public void setVaccineTimes(Set<VaccineTime> vaccineTimes) {
        this.vaccineTimes = vaccineTimes;
    }

    public Pet(Long id_pet, String pet_name, String pet_weight, int pet_year_birth, PetType pet_type, String pet_sex, String pet_category, Client client) {
        this.id_pet = id_pet;
        this.pet_name = pet_name;
        this.pet_weight = pet_weight;
        this.pet_year_birth = pet_year_birth;
        this.pet_type = pet_type;
        this.pet_sex = pet_sex;
        this.pet_category = pet_category;
        this.client = client;
    }

    public Pet() {

    }

    public Long getId_pet() {
        return id_pet;
    }

    public void setId_pet(Long id_pet) {
        this.id_pet = id_pet;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getPet_weight() {
        return pet_weight;
    }

    public void setPet_weight(String pet_weight) {
        this.pet_weight = pet_weight;
    }

    public int getPet_year_birth() {
        return pet_year_birth;
    }

    public void setPet_year_birth(int pet_year_birth) {
        this.pet_year_birth = pet_year_birth;
    }

    public PetType getPet_type() {
        return pet_type;
    }

    public void setPet_type(PetType pet_type) {
        this.pet_type = pet_type;
    }

    public String getPet_sex() {
        return pet_sex;
    }

    public void setPet_sex(String pet_sex) {
        this.pet_sex = pet_sex;
    }

    public String getPet_category() {
        return pet_category;
    }

    public void setPet_category(String pet_category) {
        this.pet_category = pet_category;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id_pet=" + id_pet +
                ", pet_name='" + pet_name + '\'' +
                ", pet_weight='" + pet_weight + '\'' +
                ", pet_year_birth=" + pet_year_birth +
                ", pet_type=" + pet_type +
                ", pet_sex='" + pet_sex + '\'' +
                ", pet_category='" + pet_category + '\'' +
                ", client=" + client +
                '}';
    }
}
