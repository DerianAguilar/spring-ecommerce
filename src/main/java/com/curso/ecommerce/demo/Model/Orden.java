package com.curso.ecommerce.demo.Model;

import java.util.Date;

public class Orden {

    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaReibido;

    private double total;

    public Orden() {
    }

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaReibido, double total) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaReibido = fechaReibido;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaReibido() {
        return fechaReibido;
    }

    public void setFechaReibido(Date fechaReibido) {
        this.fechaReibido = fechaReibido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaReibido=" + fechaReibido +
                ", total=" + total +
                '}';
    }
}
