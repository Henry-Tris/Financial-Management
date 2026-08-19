package entities;

import java.time.LocalDate;

import enumEntities.PaymentStatus;

public class sellOnCredit extends Deal {

    private Client client;      
    private Product product;
    private PaymentStatus status;      

    public sellOnCredit(Client client, Product product, double value, LocalDate date, String name, Category category) {
        super(value, date, enumEntities.TypeStatus.RECEITA, name, category, enumEntities.ExpenseContext.EMPRESARIAL); 
        this.client = client;
        this.product = product;
        this.status = PaymentStatus.PENDENT;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}