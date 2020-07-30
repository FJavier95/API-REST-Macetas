package com.tfg.maceteros.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACTION")
public class Actions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String actionDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "id=" + id +
                ", actionDesc='" + actionDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actions)) return false;
        Actions actions = (Actions) o;
        return Objects.equals(id, actions.id) &&
                Objects.equals(actionDesc, actions.actionDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionDesc);
    }
}
