package com.GestionStock.app.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.GestionStock.app.model.Product;
import com.GestionStock.app.repository.ProductRepository;
import com.GestionStock.app.service.ProductService;


@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

	
private final Path root = Paths.get("uploads/Products");
	
	@Override
	  public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }
	
	@Autowired
	private ProductRepository ProductRepository;

	@Transactional
	public Product addProduct(Product Product) {
		return ProductRepository.save(Product);
	}

	@Transactional(readOnly = true)
	public List<Product> allProduct() {
		
		return ProductRepository.findAll();
	}

	@Transactional
	public Product updateProduct(Product Product) {
		return ProductRepository.save(Product);
	}

	@Transactional
	public void deleteProduct(long Product) {
		ProductRepository.deleteById(Product);
		
	}

	@Transactional(readOnly = true)
	public Product findProductById(long id_Product) {
		return ProductRepository.findById(id_Product).get();
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByTenantId(long tenant_id) {
		return ProductRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByWarehouse(long warehouse) {
		return ProductRepository.findBywarehouse_Id(warehouse);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByCaterory(long category) {
		return ProductRepository.findBycategory_Id(category);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsBySupplier(long supplier) {
		return ProductRepository.findBysupplier_Id(supplier);
	}

	@Transactional(readOnly = true)
	public long nbProductsByTenantId(long tenant_id) {
		return ProductRepository.findBytenantid(tenant_id).size();
	}
	@Override
	public void save(MultipartFile file,long id) {
		init();
		try {
			if(Files.exists(this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()))))
			{Files.delete(this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));}
				
		      Files.copy  (file.getInputStream(), 
		    		  this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		
	}
	@Override
	  public Resource load(long id) {
	    try {	
	      Path file = root.resolve(ProductRepository.findById(id).get().getPicture());
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	  @Override
	  public Stream<Path> loadAll() {
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }
}
