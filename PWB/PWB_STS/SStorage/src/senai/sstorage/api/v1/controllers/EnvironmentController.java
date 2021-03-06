package senai.sstorage.api.v1.controllers;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senai.sstorage.api.TemplateController;
import senai.sstorage.authentication.Authority;
import senai.sstorage.authentication.JwtManager;
import senai.sstorage.exceptions.EntityNotFoundException;
import senai.sstorage.exceptions.UnauthorizedException;
import senai.sstorage.exceptions.ValidationException;
import senai.sstorage.models.Environment;
import senai.sstorage.service.EnvironmentService;
import senai.sstorage.utils.WebUtils;

@RestController
@RequestMapping(TemplateController.API_V1 + EnvironmentController.ADDRESS)
public class EnvironmentController extends TemplateController {
	
	public static final String ADDRESS = "/environments";
	
	@Autowired
	private EnvironmentService service;
	
	@Autowired
	private WebUtils webUtils;
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid Environment env, BindingResult br) {
		try {
			// Creating
			try {
				service.create(env, br);
				try {
					return ResponseEntity.created(webUtils.getUri(API_V1 + ADDRESS + "/" + env.getId())).body(env);
				} catch (URISyntaxException e) {
					return internalError(e);
				}
			} catch (ValidationException e) {
				return validationError(e, br);
			}
		} catch (Exception e) {
			return internalError(e);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
		try {
			try {
				service.delete(id);
				return ResponseEntity.ok().build();
			} catch (EntityNotFoundException e) {
				return entityNotFound(e);
			}
		} catch (Exception e) {
			return internalError(e);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> get() {
		try {
			return ResponseEntity.ok(service.read());
		} catch (Exception e) {
			return internalError(e);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable(name = "id") Long id) {
		try {
			try {
				Environment obj = service.read(id);
				return ResponseEntity.ok(obj);
			} catch (EntityNotFoundException e) {
				return entityNotFound(e);
			}
		} catch (Exception e) {
			return internalError(e);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Long id, @RequestBody @Valid Environment env, BindingResult br) {
		try {
			try {
				Environment updated = service.update(id, env, br);
				return ResponseEntity.ok(updated);
			} catch (ValidationException e) {
				return validationError(e, br);
			} catch (EntityNotFoundException e) {
				return entityNotFound(e);
			}
		} catch (Exception e) {
			return internalError(e);
		}
	}

}
