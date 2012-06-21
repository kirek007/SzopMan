package pl.edu.pjwstk.shopMan.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.shopMan.domain.Bill;
import pl.edu.pjwstk.shopMan.domain.BillSpec;
import pl.edu.pjwstk.shopMan.service.BillManager;

@SessionScoped
@Named("billBean")
public class BillFormBean implements Serializable {

	@Inject
	private BillManager bm;
	
	private static final long serialVersionUID = 1L;

	private Bill bill = new Bill();
	private ListDataModel<Bill> bills = new ListDataModel<Bill>();
	
	private Bill billToShow = new Bill();
	private ListDataModel<BillSpec> billspec = new ListDataModel<BillSpec>();



	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public ListDataModel<Bill> getBills() {
		bills.setWrappedData(bm.getBillList());
		return bills;
		
	}

	public ListDataModel<BillSpec> getBillspec() {
		billspec.setWrappedData(bm.getBillSpecList(getBillToShow()));
		return billspec;
	}
	
	public String selectBill(){
		setBillToShow(bills.getRowData());
		return null;
	}

	public Bill getBillToShow() {
		return billToShow;
	}

	public void setBillToShow(Bill billToShow) {
		this.billToShow = billToShow;
	}




	 
}
 