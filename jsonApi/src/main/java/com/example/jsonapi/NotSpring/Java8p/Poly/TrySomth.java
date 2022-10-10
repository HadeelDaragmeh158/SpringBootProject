package com.example.jsonapi.NotSpring.Java8p.Poly;

public class TrySomth {

    String str = "Hadeel Just Tring now ";
    int x ;
    double d;

    public TrySomth(){}
    public TrySomth(String str, int x, double d) {
        this.str = str;
        this.x = x;
        this.d = d;
    }

    public void run (){
        System.out.println("RUN");
    }
    @Override  // Its from Object class this class is Parent for all classes in java
    public String toString() {
        return "TrySomth{" +
                "str='" + str + '\'' +
                ", x=" + x +
                ", d=" + d +
                '}';
    }
}