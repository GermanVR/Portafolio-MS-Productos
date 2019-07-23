package com.ms.project.portafolio.app.productos.models.service;

import java.util.List;

import com.ms.project.portafolio.commons.entity.ProductoEntity;

/**
 * @author German Vazquez Renteria 
 * Date: 19 jul. 2019 
 * Package Name: com.ms.project.portafolio.app.productos.models.service 
 * Project Name: ms-productos
 */
public interface IProductoService {

	public List<ProductoEntity> findAll();

	public ProductoEntity findById(Long id);

	public ProductoEntity save(ProductoEntity producto);

	public void deleteById(Long id);
}
