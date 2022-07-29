package com.itdib.base.controller;

import java.util.List;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itdib.base.entity.Dsource;
import com.itdib.base.entity.OrgDTO;
import com.itdib.base.entity.OrgEntity;
import com.itdib.base.repository.DsourceRepository;
import com.itdib.base.repository.OrgEntityRepository;


@RestController
@RequestMapping("/base")
public class BaseRestController {
	
	@Autowired
	private DsourceRepository dsourceRepository;
	
	@Autowired
	private OrgEntityRepository orgEntityRepository;
	
	@Autowired                                                            
	private Flyway flyway;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/addsource/{tenant}")
	public ResponseEntity<Object> addDSource(@RequestBody OrgDTO orgDTO, @PathVariable("tenant") String tenant) {
		
		Dsource dsource = new Dsource();
		dsource.setTenantId(tenant);
		dsource.setUsername("root");
		dsource.setPassword("WitchMYSQL");
		dsource.setUrl("jdbc:mysql://localhost:3306/"+tenant+"?useSSL=false");
		dsource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dsourceRepository.save(dsource);
		
		OrgEntity orgEntity = new OrgEntity();
		orgEntity.setEmail(orgDTO.getEmail());
		orgEntity.setOrgName(orgDTO.getOrgName());
		orgEntity.setFirstName(orgDTO.getFirstName());
		orgEntity.setLastName(orgDTO.getLastName());
		orgEntity.setInstanceName(orgDTO.getInstanceName());
		orgEntityRepository.save(orgEntity);
		
		Flyway fly = Flyway.configure()                                                
        .configuration(flyway.getConfiguration())                 
        .schemas(tenant)                                          
        .defaultSchema(tenant)                                    
        .load();
		
		fly.migrate();
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getAll")
	public List<Dsource> getAll() {
		return dsourceRepository.findAll();
	}
}
