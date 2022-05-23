package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import org.hibernate.annotations.Entity;

@Table(name = "pet_type")
@Entity

public class PetType implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpet_type",nullable = false)
    private Long id_pet_type;


    @Column(name="pet_type_name",nullable = false)
    private String pet_type_name;

    @OneToOne( mappedBy = "pet_type")
    private Pet pets;


    public PetType() {
    }

    public PetType(Long id_pet_type, String pet_type_name,Pet pets) {
        this.id_pet_type = id_pet_type;
        this.pet_type_name = pet_type_name;
        this.pets = pets;
    }

    public Long getId_pet_type() {
        return id_pet_type;
    }

    public void setId_pet_type(Long id_pet_type) {
        this.id_pet_type = id_pet_type;
    }

    public String getPet_type_name() {
        return pet_type_name;
    }

    public void setPet_type_name(String pet_type_name) {
        this.pet_type_name = pet_type_name;
    }

    public Pet getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "id_pet_type=" + id_pet_type +
                ", pet_type_name='" + pet_type_name + '\'' +
                ", pets=" + pets +
                '}';
    }
}
