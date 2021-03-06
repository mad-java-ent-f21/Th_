package com.thunderscore.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

/**
 * The type Model.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "model")
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "model_color", joinColumns = {
            @JoinColumn(name = "model_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "color_id", referencedColumnName = "id") })
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

    public Model(String name, Integer year, Integer seats, String description, Brand brand, Set<Color> colors) {
        this.name = name;
        this.year = year;
        this.seats = seats;
        this.description = description;
        this.brand = brand;
        this.colors = colors;
    }
}
