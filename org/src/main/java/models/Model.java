package models;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public abstract class Model implements Serializable {
	
	private static final long serialVersionUID = -5449174010904674060L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	public Model() {}
	
	public Model(long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}