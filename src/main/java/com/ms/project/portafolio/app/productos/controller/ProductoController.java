package com.ms.project.portafolio.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ms.project.portafolio.app.productos.models.service.IProductoService;
import com.ms.project.portafolio.commons.entity.ProductoEntity;

/**
 * @author German Vazquez Renteria
 * Date:  19 jul. 2019
 * Package Name: com.ms.project.portafolio.app.productos.controllers
 * Project Name: ms-productos
 */
@RestController
public class ProductoController {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private IProductoService productoService;

	@GetMapping("/listar")
	public List<ProductoEntity> listar() {
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public ProductoEntity detalle(@PathVariable Long id) {
		ProductoEntity producto = productoService.findById(id);
		producto.setPort(port);
		return producto;
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoEntity crear(@RequestBody ProductoEntity producto) {
		return productoService.save(producto);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoEntity editar(@RequestBody ProductoEntity producto, @PathVariable Long id) {
		ProductoEntity productoDb = productoService.findById(id);
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
		return productoService.save(productoDb);
	}

	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		productoService.deleteById(id);
	}

}
