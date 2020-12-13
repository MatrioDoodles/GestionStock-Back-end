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

import com.GestionStock.app.model.Company;
import com.GestionStock.app.repository.CompanyRepository;
import com.GestionStock.app.service.CompanyService;

@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService {

private final Path root = Paths.get("uploads/Comapnies");
	
	@Override
	  public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }
	@Autowired
	private CompanyRepository CompanyRepository;

	@Transactional
	public Company addCompany(Company Company) {
		return CompanyRepository.save(Company);
	}

	@Transactional(readOnly = true)
	public List<Company> allCompany() {
		
		return CompanyRepository.findAll();
	}

	@Transactional
	public Company updateCompany(Company Company) {
		return CompanyRepository.save(Company);
	}

	@Transactional
	public void deleteCompany(long Company) {
		CompanyRepository.deleteById(Company);
		
	}

	@Transactional(readOnly = true)
	public Company findCompanyById(long id_Company) {
		return CompanyRepository.findById(id_Company).get();
	}

	@Transactional(readOnly = true)
	public Company getCompanyByTenantId(long tenant_id) {
		return CompanyRepository.findBytenantid(tenant_id);
	}
	@Override
	public void save(MultipartFile file,long id) {
		init();
		try {
			if(Files.exists(this.root.resolve("Company."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()))))
			{Files.delete(this.root.resolve("Company."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));}
				
		      Files.copy  (file.getInputStream(), 
		    		  this.root.resolve("Company."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		
	}
	@Override
	  public Resource load(long id) {
	    try {	
	      Path file = root.resolve(CompanyRepository.findById(id).get().getLogo());
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
