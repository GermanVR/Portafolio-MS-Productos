package com.ms.project.portafolio.app.productos.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.project.portafolio.app.productos.models.repository.ProductoRepository;
import com.ms.project.portafolio.app.productos.models.service.IProductoService;
import com.ms.project.portafolio.commons.entity.ProductoEntity;

/**
 * @author German Vazquez Renteria
 * Date:  19 jul. 2019
 * Package Name: com.ms.project.portafolio.app.productos.models.service.impl
 * Project Name: ms-productos
 */
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoRepository productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductoEntity> findAll() {
		return (List<ProductoEntity>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoEntity findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ProductoEntity save(ProductoEntity producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

}
