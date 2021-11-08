package com.thunderscore.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@IdClass(TrimPK.class)
public class Trim {

    @EmbeddedId
    private TrimPK trimPK;

    @MapsId("modelId")
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "description", length = 128)
    private String description;

    @Column(name = "fuel_consumption")
    private Integer fuelConsumption;

    @Column(name = "forced_induction", length = 20)
    private String forcedInduction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trim trim = (Trim) o;
        return Objects.equals(trimPK, trim.trimPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trimPK);
    }
}
