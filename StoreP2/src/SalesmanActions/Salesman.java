package SalesmanActions;

public class Salesman {
	private int id;
	private String nomeSalesman;
	private String cidadeSalesman;
	private double comissaoSalesman;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeSalesman() {
		return nomeSalesman;
	}
	public void setNomeSalesman(String nomeSalesman) {
		this.nomeSalesman = nomeSalesman;
	}
	public String getCidadeSalesman() {
		return cidadeSalesman;
	}
	public void setCidadeSalesman(String cidadeSalesman) {
		this.cidadeSalesman = cidadeSalesman;
	}
	public double getComissaoSalesman() {
		return comissaoSalesman;
	}
	public void setComissaoSalesman(double comissaoSalesman) {
		this.comissaoSalesman = comissaoSalesman;
	}
}
