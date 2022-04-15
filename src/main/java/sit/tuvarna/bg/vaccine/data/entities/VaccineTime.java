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
    @Column(name="pet",nullable = false)
    private Pet pet;

    @ManyToOne
    @Column(name="client",nullable = false)
    private Client client;

    @ManyToOne
    @Column(name="veterinarian",nullable = false)
    private Veterinarian veterinarian;
}
