package com.ironhack.homework_2.Classes;

public class Opportunity {
    private long idOpportunity;
    private Enum product;
    private int quantity;
    private Contact decisionMaker;
    private Enum status;

    // Constructor method

    public Opportunity(long idOpportunity, Enum product, int quantity, Contact decisionMaker, Enum status) {
        this.idOpportunity = idOpportunity;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    // Getters and Setters


    public long getIdOpportunity() {
        return idOpportunity;
    }

    public void setIdOpportunity(long idOpportunity) {
        this.idOpportunity = idOpportunity;
    }

    public Enum getProduct() {
        return product;
    }

    public void setProduct(Enum product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
}

