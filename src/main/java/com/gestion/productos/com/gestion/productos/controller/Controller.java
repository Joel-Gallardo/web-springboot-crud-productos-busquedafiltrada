package com.gestion.productos.com.gestion.productos.controller;

import com.gestion.productos.com.gestion.productos.persistence.entity.Producto;
import com.gestion.productos.com.gestion.productos.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ServicioProducto servicioProducto;

    @RequestMapping("/")
    public String verPaginaPrincipal(Model modelo) {
        List<Producto> listaProductos = servicioProducto.listAll();
        modelo.addAttribute("listaProductos", listaProductos);
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
        servicioProducto.save(producto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id) {
       ModelAndView modelo = new ModelAndView("editar_producto");
        Producto producto = servicioProducto.getProductoById(id);
        modelo.addObject("producto", producto);
        return modelo;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id) {
        servicioProducto.deleteById(id);
        return "redirect:/";
    }
}
