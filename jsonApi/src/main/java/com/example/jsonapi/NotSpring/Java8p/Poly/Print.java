package com.example.jsonapi.NotSpring.Java8p.Poly;

public class Print extends TrySomth{

    public Print() {
    }

    public Print(String str, int x, double d) {
        super(str, x, d);
    }

    @Override
    public void run(){
        System.out.println("**************************************************");
        System.out.println("**RUN FROM PRINT CLASS");
        System.out.println("** "+super.toString());
        System.out.println("** "+super.str + " " + super.x + " " + super.d);
        System.out.println("**************************************************");
    }
}
