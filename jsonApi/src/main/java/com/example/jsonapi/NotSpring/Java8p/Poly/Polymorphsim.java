package com.example.jsonapi.NotSpring.Java8p.Poly;

public class Polymorphsim extends TrySomth{

    int x ;
    String str= "Hadeel do well";

    public Polymorphsim(){

    }
    public Polymorphsim(int x, String str) {
        this.x = x;
        this.str = str;
    }

    public Polymorphsim(String str, int x, double d, int x1, String str1) {
        super(str, x, d);
        this.x = x1;
        this.str = str1;
    }

    @Override
    public void run(){

        System.out.println("**************************************************");
        System.out.println("ITS RUN FROM POLY CLASS ");
        System.out.println("** "+super.toString());
        System.out.println("** "+super.str + " " + super.x + " " + super.d);
        System.out.println("**************************************************");
    }
}
