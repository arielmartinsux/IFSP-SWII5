package OrderActions;

import java.sql.Date;

public class Order {
	private int ordNo;
	private double purchAmt;
	private Date date;
	private int customerId;
	private int salesmanId;
	
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public double getPurchAmt() {
		return purchAmt;
	}
	public void setPurchAmt(double purchAmt) {
		this.purchAmt = purchAmt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date2) {
		this.date = date2;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
}
