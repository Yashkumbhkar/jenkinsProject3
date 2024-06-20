package in.co.rays.project_3.dto;

public class CategoryDTO  extends BaseDTO{
	
	 private String category ;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return category;
	}

}
