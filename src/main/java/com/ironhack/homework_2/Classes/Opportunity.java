package com.ironhack.homework_2.Classes;

import com.ironhack.homework_2.Enumerations.ProductEnum;
import com.ironhack.homework_2.Enumerations.StatusEnum;

public class Opportunity {
    private long idOpportunity;
    private ProductEnum productEnum;
    private int quantity;
    private Contact decisionMaker;
    private StatusEnum statusEnum;
    private static long idCounter= 1;

    private long generateIdOpportunity(){

        long idOpportunity = idCounter++;

        return idOpportunity;

    }

    // Constructor method

    public Opportunity(ProductEnum product, int quantity, Contact decisionMaker, StatusEnum status) {
        this.idOpportunity = generateIdOpportunity();
        this.productEnum = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.statusEnum = status;
    }

    // Getters and Setters


    public long getIdOpportunity() {
        return idOpportunity;
    }

    public void setIdOpportunity(long idOpportunity) {
        this.idOpportunity = idOpportunity;
    }

    public ProductEnum getProduct() {
        return productEnum;
    }

    public void setProduct(ProductEnum product) {
        this.productEnum = product;
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

    public StatusEnum getStatus() {
        return statusEnum;
    }

    public void setStatus(StatusEnum status) {
        this.statusEnum = status;
    }
}

