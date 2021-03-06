package models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product extends Model{

	private static final long serialVersionUID = -7881391014358935700L;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_category_id", referencedColumnName="id")
	private ProductCategory productCategory;
	
	@Column(name="price")
	private BigDecimal price;
	
	public Product() {
		super();
	}
	
	public Product(long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return super.getId() + " - " + title + " - "+ description + " - " + price + " - ";
	}
	
	
}
