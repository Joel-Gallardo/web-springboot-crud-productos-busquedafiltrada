package com.gestion.productos.com.gestion.productos.persistence.repository;

import com.gestion.productos.com.gestion.productos.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository <Producto,Long> {
}
