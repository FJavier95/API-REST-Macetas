package com.tfg.maceteros.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EVENTS")
public class Events implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Actions action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", cliente=" + cliente +
                ", action=" + action +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Events)) return false;
        Events events = (Events) o;
        return Objects.equals(id, events.id) &&
                Objects.equals(timestamp, events.timestamp) &&
                Objects.equals(cliente, events.cliente) &&
                Objects.equals(action, events.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, cliente, action);
    }
}

