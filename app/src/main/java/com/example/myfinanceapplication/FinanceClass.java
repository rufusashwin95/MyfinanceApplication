package com.example.myfinanceapplication;

public class FinanceClass {
    private int id;
    private Double accountNumber;
    private Double paymentAmount;
    private Double initBalance;
    private Double currBalance;
    private Double interestRate;

    public FinanceClass() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getInitBalance() {
        return initBalance;
    }

    public void setInitBalance(Double initBalance) {
        this.initBalance = initBalance;
    }

    public Double getCurrBalance() {
        return currBalance;
    }

    public void setCurrBalance(Double currBalance) {
        this.currBalance = currBalance;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
