package com.thunderscore.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class TrimPK implements Serializable {

    @Column(name = "model_id", nullable = false)
    private Integer modelId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrimPK trimPK = (TrimPK) o;
        return Objects.equals(modelId, trimPK.modelId)
                && Objects.equals(name, trimPK.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelId, name);
    }
}
