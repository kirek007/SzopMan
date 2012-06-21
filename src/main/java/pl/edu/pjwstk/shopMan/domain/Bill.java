package pl.edu.pjwstk.shopMan.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "bill.all", query = "Select b from Bill b")
public class Bill {
	
	private Long id;
	private Date sellDate;
	private float billValue;
	private List<BillSpec> billSpec = new ArrayList<BillSpec>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public float getBillValue() {
		return billValue;
	}
	public void setBillValue(float billValue) {
		this.billValue = billValue;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public List<BillSpec> getBillSpec() {
		return billSpec;
	}
	
	public void setBillSpec(List<BillSpec> billSpec) {
		this.billSpec = billSpec;
	}
	
	public void addSpec(BillSpec bs){
		this.billSpec.add(bs);
	}
	
	
	
}
