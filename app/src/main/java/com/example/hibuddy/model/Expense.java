package com.example.hibuddy.model;

public class Expense {
    String ExpName;
    String ExpDate;
    float ExpValue;
    int ExpQty;

    public Expense(String expName, String expDate, float expValue, int expQty) {
        ExpName = expName;
        ExpDate = expDate;
        ExpValue = expValue;
        ExpQty = expQty;
    }

    public Expense() {
    }

    public String getExpName() {
        return ExpName;
    }

    public void setExpName(String expName) {
        ExpName = expName;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public float getExpValue() {
        return ExpValue;
    }

    public void setExpValue(float expValue) {
        ExpValue = expValue;
    }

    public int getExpQty() {
        return ExpQty;
    }

    public void setExpQty(int expQty) {
        ExpQty = expQty;
    }
}
