package sit.tuvarna.bg.vaccine.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "veterinarian")
@Entity


public class Veterinarian  implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idveterinarian",nullable = false)
    private Long id_veterinarian;



}
