package com.gestion.productos.com.gestion.productos.service;

import com.gestion.productos.com.gestion.productos.persistence.entity.Producto;
import com.gestion.productos.com.gestion.productos.persistence.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> listAll(String palabraClave) {
        if(palabraClave != null){
            return productoRepositorio.findAll(palabraClave);
        }
        return productoRepositorio.findAll();
    }

    public void save(Producto producto) {
        productoRepositorio.save(producto);
    }

    public Producto getProductoById(Long id) {
        return productoRepositorio.getById(id);
    }

    public void deleteById(Long id) {
        productoRepositorio.deleteById(id);
    }
}
