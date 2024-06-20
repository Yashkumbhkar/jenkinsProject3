package in.co.rays.project_3.dto;

public class SalaryDTO  extends BaseDTO{

	private String employe;
	private String amount;
	private String appledDate;

	private String status;

	public String getEmploye() {
		return employe;
	}

	public void setEmploye(String employe) {
		this.employe = employe;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAppledDate() {
		return appledDate;
	}

	public void setAppledDate(String appledDate) {
		this.appledDate = appledDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
