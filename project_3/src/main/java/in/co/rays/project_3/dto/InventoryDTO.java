package in.co.rays.project_3.dto;

import java.util.Date;

public class InventoryDTO extends BaseDTO {

	private String supplierName;
	private Date lastUpatedDate;
	private Integer quantity;
	private String product;

	public String getSupplierName() {

		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Date getLastUpatedDate() {
		return lastUpatedDate;
	}

	public void setLastUpatedDate(Date lastUpatedDate) {
		this.lastUpatedDate = lastUpatedDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
