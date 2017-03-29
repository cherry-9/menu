package com.example.spectorh.menu;


public class student {

    private int _rNo;
    private String _name;
    private int _branchID;

    student (){}

    student (int rno,String name,int branch)
    {
        this._name=name;
        this._rNo=rno;
        this._branchID=branch;
    }

    public int get_rNo() {
        return _rNo;
    }

    public void set_rNo(int _rNo) {
        this._rNo = _rNo;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_branch() {
        return _branchID;
    }

    public void set_branch(int _branch) {
        this._branchID = _branch;
    }
}
