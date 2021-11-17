package com.thunderscore.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Trim.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "trim")
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "description", length = 128)
    private String description;

    @Column(name = "fuel_consumption")
    private Integer fuelConsumption;

    @Column(name = "forced_induction", length = 20)
    private String forcedInduction;

    @ManyToOne
    @JoinColumn(name="engine_id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name="drivetrain_id")
    private DriveTrain driveTrain;

    @ManyToOne
    @JoinColumn(name="transmission_id")
    private Transmission transmission;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trim trim = (Trim) o;
        return Objects.equals(id, trim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Trim(Model model, String name, String description, Integer fuelConsumption, String forcedInduction, Engine engine, DriveTrain driveTrain, Transmission transmission) {
        this.model = model;
        this.name = name;
        this.description = description;
        this.fuelConsumption = fuelConsumption;
        this.forcedInduction = forcedInduction;
        this.engine = engine;
        this.driveTrain = driveTrain;
        this.transmission = transmission;
    }
}
