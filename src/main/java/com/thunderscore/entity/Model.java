package com.thunderscore.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Column(name = "description", length = 128)
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "model_color",
            joinColumns = { @JoinColumn(name = "model_id") },
            inverseJoinColumns = { @JoinColumn(name = "color_id") }
    )
    @ToString.Exclude
    private Set<Color> colors = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Model model = (Model) o;
        return Objects.equals(id, model.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
