package in.co.rays.project_3.dto;

public class TypeDTO extends BaseDTO {

	  private String type ;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return type ;
	}
}
