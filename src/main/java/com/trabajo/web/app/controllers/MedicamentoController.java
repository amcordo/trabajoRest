package com.trabajo.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.web.app.models.Medicamentos;
import com.trabajo.web.app.services.MedicamentosServices;

@CrossOrigin(origins =  "*")
@RestController
@RequestMapping("/api")
public class MedicamentoController {
	
	@Autowired
	private MedicamentosServices medicamentosServices;
	
	@GetMapping("/medicamentos")
	public List<Medicamentos> getMedicamentos() {
		return medicamentosServices.getMedicamentos();
	}

	@GetMapping("/medicamentos/{medicamentosId}")
	public Medicamentos getMedicamentos(@PathVariable int medicamentosId) {
		Medicamentos medicamentos = medicamentosServices.getMedicamentos(medicamentosId);
		return medicamentos;
	}

	
	@PostMapping("/medicamentos")
	@ResponseStatus(HttpStatus.CREATED)
	public Medicamentos addMedicamentos(@RequestBody Medicamentos medicamentos) {

		medicamentos.setId(null);		
		medicamentosServices.saveMedicamentos(medicamentos);
		return medicamentos;
	}
	
		
	@PutMapping("/medicamentos")
	@ResponseStatus(HttpStatus.CREATED)
	public Medicamentos updateMedicamentos(@RequestBody Medicamentos medicamentos) {
		
		medicamentosServices.saveMedicamentos(medicamentos);
		return medicamentos;
	}
	
	@DeleteMapping("/medicamentos/{medicamentosId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMedicamentos(@PathVariable int medicamentosId) {
		
		medicamentosServices.deleteMedicamentos(medicamentosId);
	}


}
