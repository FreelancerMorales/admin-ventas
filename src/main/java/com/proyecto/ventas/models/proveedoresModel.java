package com.proyecto.ventas.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "proveedores")
public class proveedoresModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false, length = 75)
    private String nombre;

    @Column(name = "nit", unique = true, nullable = false, length = 15)
    private String nit;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 8)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    // Relacion de uno a muchos con la tabla Productos
    @JsonIgnore
    @OneToMany(mappedBy = "proveedor")
    private List<productosModel> productos;

    // Relacion de uno a muchos con la tabla Compras
    @JsonIgnore
    @OneToMany(mappedBy = "proveedor")
    private List<comprasModel> compras;
}
