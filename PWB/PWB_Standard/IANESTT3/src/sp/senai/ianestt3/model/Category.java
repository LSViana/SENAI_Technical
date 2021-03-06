package sp.senai.ianestt3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {
	
	@Id
	private Long id;
	@Column(nullable = false, unique = true, length = 32)
	@NotNull
	@Size(min = 1, max = 30)
	private String name;
	@OneToMany(mappedBy = "category", targetEntity = Patrimony.class)
	private List<Patrimony> patrimonies;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
