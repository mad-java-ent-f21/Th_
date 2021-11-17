package com.thunderscore.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The type Brand.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * Instantiates a new Brand.
     *
     * @param name    the name
     * @param country the country
     */
    public Brand(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    /**
     * Instantiates a new Brand.
     *
     * @param id      the id
     * @param name    the name
     * @param country the country
     */
    public Brand(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
