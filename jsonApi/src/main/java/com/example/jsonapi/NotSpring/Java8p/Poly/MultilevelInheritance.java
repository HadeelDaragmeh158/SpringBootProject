package com.example.jsonapi.NotSpring.Java8p.Poly;

public class MultilevelInheritance extends Polymorphsim{
    public void CheckMultiValue(){
        TrySomth pol ,pol2;
        pol= new Polymorphsim("Hadeel", 1,2,4,"Poly");
        pol2 = new Print();


        Polymorphsim p = new Polymorphsim();
        MultilevelInheritance b = new MultilevelInheritance();

        p = b;
        p.toString();
        pol.run();
        pol2.run();
    }
}
