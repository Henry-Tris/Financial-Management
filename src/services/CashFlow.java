package services;

import java.util.ArrayList;
import java.util.List;

import entities.Bills;
import entities.Deal;
import entities.sellOnCredit;
import enumEntities.PaymentStatus;
import enumEntities.TypeStatus;

public class CashFlow {

	private List<Deal> deals;
	private List<Bills> bills;

	public CashFlow() {
		this.deals = new ArrayList<>();
		this.bills = new ArrayList<>();
	}

	public void addDeal(Deal deal) {
		deals.add(deal);
	}

	public void addBill(Bills bill) {
		bills.add(bill);
	}

	public double currentBalance() {
		double balance = 0;

		for (Deal deal : deals) {
			if (deal instanceof sellOnCredit) {
				sellOnCredit sale = (sellOnCredit) deal;
				if (sale.getStatus() == PaymentStatus.PAID) {
					balance += sale.getValue();
				}
			} else {
				if (deal.getType() == TypeStatus.RECEITA) {
					balance += deal.getValue();
				} else {
					balance -= deal.getValue();
				}
			}
		}

		return balance;
	}

	public double expectedIncome() {
		double total = 0;

		for (Deal deal : deals) {
			if (deal instanceof sellOnCredit) {
				sellOnCredit sale = (sellOnCredit) deal;
				if (sale.getStatus() == PaymentStatus.PENDENT) {
					total += sale.getValue();
				}
			}
		}

		return total;
	}
	
	public double expectedExpenses() {
	    double total = 0;

	    for (Bills bill : bills) {
	        if (bill.getStatus() == PaymentStatus.PENDENT) {
	            total += bill.getValue();
	        }
	    }

	    return total;
	}
	
	public List<Deal> getDeals() {
        return deals;
    }

    public List<Bills> getBills() {
        return bills;
    }
}