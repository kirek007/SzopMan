package pl.edu.pjwstk.shopMan.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.edu.pjwstk.shopMan.domain.Bill;
import pl.edu.pjwstk.shopMan.domain.BillSpec;


@Stateless
public class BillManager {

		@PersistenceContext
		EntityManager em;
		
		public void addBill(Bill bill){
			bill.setId(null);
			em.persist(bill);
		}
		
		@SuppressWarnings("unchecked")
		public List<Bill> getBillList(){
			return em.createNamedQuery("bill.all").getResultList();
		}
		
		public Bill getDefBill(){
			return em.find(Bill.class, 0);
		}
		
		public List<BillSpec> getBillSpecList(Bill bill){
			List<BillSpec> spec;
			if (bill.getId() != null){
				bill = em.find(Bill.class, bill.getId());
				spec = new ArrayList<BillSpec>(bill.getBillSpec());
			} else {
				spec = new ArrayList<BillSpec>();	
			}
			
			return spec;
		}
		
		public void saveBill(Bill bill){
			bill.setId(null);
			em.merge(bill);
		}
}
