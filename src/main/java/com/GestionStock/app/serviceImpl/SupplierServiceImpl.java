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

import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.repository.SupplierRepository;
import com.GestionStock.app.service.SupplierService;


@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService{

	private final Path root = Paths.get("uploads/Suppliers");
	
	@Override
	  public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }
	@Autowired
	private SupplierRepository SupplierRepository;

	@Transactional
	public Supplier addSupplier(Supplier Supplier) {
		return SupplierRepository.save(Supplier);
	}

	@Transactional(readOnly = true)
	public List<Supplier> allSupplier() {
		
		return SupplierRepository.findAll();
	}

	@Transactional
	public Supplier updateSupplier(Supplier Supplier) {
		return SupplierRepository.save(Supplier);
	}

	@Transactional
	public void deleteSupplier(long Supplier) {
		SupplierRepository.deleteById(Supplier);
		
	}

	@Transactional(readOnly = true)
	public Supplier findSupplierById(long id_Supplier) {
		return SupplierRepository.findById(id_Supplier).get();
	}

	@Transactional(readOnly = true)
	public List<Supplier> getSuppliersByTenantId(long tenant_id) {
		return SupplierRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbSuppliersByTenantId(long tenant_id) {
		return SupplierRepository.findBytenantid(tenant_id).size();
	}

	@Override
	public void save(MultipartFile file,long id) {
		init();
		try {
				if(Files.exists(this.root.resolve("Supplier."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()))))
				{Files.delete(this.root.resolve("Supplier."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));}
		      Files.copy  (file.getInputStream(), 
		    		  this.root.resolve("Supplier."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));
		      Supplier sup = SupplierRepository.findById(id).get();
		      sup.setLogo("Supplier."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()));
		      SupplierRepository.save(sup);
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		
	}
	@Override
	  public Resource load(long id) {
	    try {	
	      Path file = root.resolve(SupplierRepository.findById(id).get().getLogo());
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
