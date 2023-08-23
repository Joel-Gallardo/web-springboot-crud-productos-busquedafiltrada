package com.gestion.productos.com.gestion.productos.controller;

import com.gestion.productos.com.gestion.productos.persistence.entity.Producto;
import com.gestion.productos.com.gestion.productos.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductoServicio productoServicio;

    @RequestMapping("/")
    public String verPaginaPrincipal(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Producto> listaProductos = productoServicio.listAll(palabraClave);
        modelo.addAttribute("listaProductos", listaProductos);
        modelo.addAttribute("palabraClave", palabraClave);

        return "index";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo) {
       Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "nuevo_producto";
    }

    @RequestMapping(value = "/guardar" , method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoServicio.save(producto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id) {
       ModelAndView modelo = new ModelAndView("editar_producto");
        Producto producto = productoServicio.getProductoById(id);
        modelo.addObject("producto", producto);
        return modelo;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id) {
        productoServicio.deleteById(id);
        return "redirect:/";
    }
}
