package com.alex.atos.entity;

import javax.persistence.*;

/**
 * The type Tutorial.
 */
@Entity
@Table(name = "tutoriales")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "publicado")
    private boolean publicado;

    /**
     * Instantiates a new Tutorial.
     */
    public Tutorial() {
    }

    /**
     * Instantiates a new Tutorial.
     *
     * @param titulo      the titulo
     * @param descripcion the descripcion
     * @param publicado   the publicado
     */
    public Tutorial(String titulo, String descripcion, boolean publicado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.publicado = publicado;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Es publicado boolean.
     *
     * @return the boolean
     */
    public boolean esPublicado() {
        return publicado;
    }

    /**
     * Sets publicado.
     *
     * @param esPublicado the es publicado
     */
    public void setPublicado(boolean esPublicado) {
        this.publicado = esPublicado;
    }
    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", titulo=" + titulo + ", desc=" + descripcion + ", publicado=" + publicado + "]";
    }
}
