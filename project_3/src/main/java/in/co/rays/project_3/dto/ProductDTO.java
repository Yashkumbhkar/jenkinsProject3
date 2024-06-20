package in.co.rays.project_3.dto;

import java.util.Date;

public class ProductDTO  extends BaseDTO{

	  
	   private  String name ;
	   private String price ;
	   private String type;
	   private Date expireDate ;
	   
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return type;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return type;
	}
	   
	   
}
