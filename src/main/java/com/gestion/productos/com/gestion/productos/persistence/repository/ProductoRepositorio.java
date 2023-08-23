package com.gestion.productos.com.gestion.productos.persistence.repository;

import com.gestion.productos.com.gestion.productos.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository <Producto,Long> {

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1%"
            + " OR p.marca LIKE %?1%"
            + " OR p.hechoEn LIKE %?1%")
    public List<Producto> findAll(String palabraClave);
}
