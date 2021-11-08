package com.thunderscore.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Engine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(name = "displacement")
    private String displacement;

    @Column(name = "cylinder_count", nullable = false)
    private Integer cylinderCount;

    @Column(name = "voltage")
    private Integer voltage;

    @Column(name = "energy_consumption")
    private Integer energyConsumption;

    @Column(name = "description", length = 128)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Engine engine = (Engine) o;
        return Objects.equals(id, engine.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
