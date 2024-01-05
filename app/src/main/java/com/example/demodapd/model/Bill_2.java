package com.example.demodapd.model;

public class Bill_2 {
    private String _id;
    private String accountId;
    private Product productId;
    private Double totalPrice;
    private int quantity;
    private int statusBill;

    public Bill_2(String _id, String accountId, Product productId, Double totalPrice, int quantity, int statusBill) {
        this._id = _id;
        this.accountId = accountId;
        this.productId = productId;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.statusBill = statusBill;
    }

    public Bill_2() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatusBill() {
        return statusBill;
    }

    public void setStatusBill(int statusBill) {
        this.statusBill = statusBill;
    }
}
