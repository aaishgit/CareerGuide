package com.example.aaishsindwani.careerguide;

/**
 * Created by aaishsindwani on 09/09/16.
 */
public class marks_pojo {
    private int math,sci,eng,sst;


    //Compulsory for firebase
    public marks_pojo() {

    }


    public marks_pojo(int m,int sc,int e,int ss) {

    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSci() {
        return sci;
    }

    public void setSci(int sci) {
        this.sci = sci;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getSst() {
        return sst;
    }

    public void setSst(int sst) {
        this.sst = sst;
    }
}
