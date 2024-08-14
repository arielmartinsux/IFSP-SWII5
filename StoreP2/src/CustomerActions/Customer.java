package CustomerActions;

public class Customer {
	private int id;
	private String nomeCustomer;
	private String cidadeCustomer;
	private int gradeCustomer;
	private int salesmanId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCustomer() {
		return nomeCustomer;
	}
	public void setNomeCustomer(String nomeCustomer) {
		this.nomeCustomer = nomeCustomer;
	}
	public int getGradeCustomer() {
		return gradeCustomer;
	}
	public void setGradeCustomer(int gradeCustomer) {
		this.gradeCustomer = gradeCustomer;
	}
	public String getCidadeCustomer() {
		return cidadeCustomer;
	}
	public void setCidadeCustomer(String cidadeCustomer) {
		this.cidadeCustomer = cidadeCustomer;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
	
	
}
