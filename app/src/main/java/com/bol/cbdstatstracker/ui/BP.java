package com.bol.cbdstatstracker.ui;

public class BP {
    private String date;
    private String diastolic;
    private String systolic;

    public BP(String uDate, String uDia,String uSys){
        this.date = uDate;
        this.diastolic = uDia;
        this.systolic = uSys;
    }

    public String getDate(){
        return this.date;
    }

    public String getDiastolic(){
        return this.diastolic;
    }

    public String getSystolic(){
        return this.systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public void setDate(String date){
        this.date =date;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }
}
