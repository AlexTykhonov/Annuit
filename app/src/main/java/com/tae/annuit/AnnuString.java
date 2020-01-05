package com.tae.annuit;

public class AnnuString {


    public AnnuString() {
    }

    public AnnuString(Double amount, Double rate, int duration) {
        this.amount = amount;
        this.rate = rate;
        this.duration = duration;
    }

    Double amount;
    int duration;
    Double rate, payment;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }
}
