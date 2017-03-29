package com.example.spectorh.menu;


public class Product {
    private int _id;
    private String _name;
    // private static int count;

    public Product(int count,String _name) {
        this._name = _name;
        this._id=count;
    }
    public Product(){}

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
