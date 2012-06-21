package pl.edu.pjwstk.shopMan.web;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.shopMan.domain.Article;
import pl.edu.pjwstk.shopMan.domain.Bill;
import pl.edu.pjwstk.shopMan.domain.BillSpec;
import pl.edu.pjwstk.shopMan.service.ArticleManager;
import pl.edu.pjwstk.shopMan.service.BillManager;

@SessionScoped
@Named("createBillBean")
public class CreateBillFormBean implements Serializable {

	@Inject
	private BillManager bm;
	@Inject
	private ArticleManager am;
	
	private static final long serialVersionUID = 1L;
	
	private Bill bill = new Bill();
	private BillSpec billSpec = new BillSpec();
	
	private ListDataModel<BillSpec> billspecs = new ListDataModel<BillSpec>();
	private ListDataModel<Article> articles = new ListDataModel<Article>();
	
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	public BillSpec getBillSpec() {
		return billSpec;
	}
	public void setBillSpec(BillSpec billSpec) {
		this.billSpec = billSpec;
	}
	
	public ListDataModel<BillSpec> getBillspecs() {
		billspecs.setWrappedData(bill.getBillSpec());
		return billspecs;
	}
	public ListDataModel<Article> getArticles() {
		articles.setWrappedData(am.getArticleList());
		return articles;
	}
	public void setArticles(ListDataModel<Article> articles) {
		this.articles = articles;
	}


	public void selectArticle(){
		billSpec.setArticle(articles.getRowData());
	}
	
	public void addToBill(BillSpec bs){
		if (bs.getArticle() != null)
		bill.addSpec(bs);
	}
	
	public void addArticleToBill(){
		addToBill(billSpec);		
		billSpec = new BillSpec();
		
	}
	
	public String saveBill(){
		
		float value = 0;

		for (BillSpec bs : bill.getBillSpec())
		{
			value += bs.getQuantity() * bs.getArticle().getCena();
		}
		bill.setBillValue(value);
		Date newDate = new Date();
		bill.setSellDate(newDate);
		
		bm.saveBill(bill);
		bill = new Bill();
		return "createBill";
	}
	
}
