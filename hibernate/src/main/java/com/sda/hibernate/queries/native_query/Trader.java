package com.sda.hibernate.queries.native_query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "findTraderByName",
        query = "SELECT * FROM trader t WHERE t.name = :name",
        resultClass = Trader.class
    )})
@Entity(name = "Trader")
@Table(name = "trader")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Trader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
