package com.projet.consultoria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "clientes")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 12L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="PESO")
    private String peso;

    @Column(name="PRODUCT")
    private String product;

    @Column(name="VAL_PRODUCT")
    private Double valProd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getValProd() {
        return valProd;
    }

    public void setValProd(Double valProd) {
        this.valProd = valProd;
    }
}
