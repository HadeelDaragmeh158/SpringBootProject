package com.example.jsonapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JsonApiApplication {
    static int b;
    public static void main(String[] args) {
        SpringApplication.run(JsonApiApplication.class, args);


        String h1 = "Hadeel";
        String h2 = "Maria";
        String h3 = "Hadeel";
        String h4 = new String ("Maria");
        String h5 = new String ("Maria");
        System.out.println(h2 == h4); //TODO different pointers it will give false
        System.out.println(h4 == h5); //different pointer in heap
        System.out.println(h1 == h2);
        System.out.println(h1 == h3);
        h1 = "MEME";
        System.out.println(h1 +" "+h3);  // its not like pointer h3 saved Hadeel and h1 changed to MEME


//            mapStream();
//        String[] arrayStr = {"Hadeel", "Maria" , "Leen"};
//        ClassImpForInterfaec c = new ClassImpForInterfaec();
//        c.forEachTryStatic(arrayStr);

//        String s1 ="Hello Method One";
//        String s2 ="Hello Method Log";
//        String[] arrayStr = {"Hadeel", "Maria" , "Leen"};
//        ClassImpForInterfaec c =new ClassImpForInterfaec();
//        c.method1(s1);
//        c.method2();
//        c.log(s2);
//
//        c.normalMethod(arrayStr);

//        mapForEach();
//        listForEach();
//        MultilevelInheritance m = new MultilevelInheritance();
//        m.CheckMultiValue();

//        System.out.println("Data Member: ");
//        TrySomth obj  =  new Polymorphsim();
//        System.out.println(obj.str);
//        obj.run();
//        System.out.println("____________");
//
//
//        System.out.println();
//        TrySomth somth = new Polymorphsim("Hadeel",1,3 ,2,"Daragmeh");
//        somth.run();
//
//        System.out.println();
//        TrySomth somth1 = new Print("Hadeel",1,3 );
//        somth1.run();
//
//
//        System.out.println("Runtime : ");
//        TrySomth all ;
//        all= new Print("Hadeeeel" , 1,2);
//        all.run();
//
//
//        System.out.println();
//        all = new Polymorphsim("Hadeel", 1,2,3,"Maria");
//        all.run();
//        System.out.println("____________");
//
//        System.out.println();
//        TrySomth t = new TrySomth();
//        System.out.println( t.toString());
//
//        System.out.println();
//        String s1 = "Hello";
//        String s2 = s1;
//        String s3 = "Hi";
//        s1 = "Hi" ;
//        System.out.println(s2);
//
//        System.out.println();
//        Integer i1 = 1;
//        Integer i2 = i1;
//        Integer i3 = 2;
//        i1 = 50 ;
//        System.out.println(i2);
//
//        System.out.println();
//        System.out.println(b+"");
//
//        System.out.println();
//        String s4 = new String("Hello");
//        String s5 = new String(s4);
//        String s6 = new String("Hi");
//        s4 = "Hi" ;
//        System.out.println(s5);
    }

    public static void mapForEach(){
        Map<String , String > myMap = new HashMap<>();
        myMap.put("Hadeel","Daragmeh");
        myMap.put("Maria","MEME");
        myMap.put("Faris","Aseel");

        myMap.forEach((String key ,String value)->{  // I USED LAMBDA IN MY CODE
            System.out.println(key  +   "  ->  "+ value);
        });
    }

    public static void listForEach(){
        List<Integer> myList = new ArrayList<>();
        myList.add(27);
        myList.add(1);
        myList.add(8);
        myList.add(5);
        System.out.println(" { ");
        myList.forEach((Integer x)->{
            System.out.print( x + "-");
        } );
        System.out.println();
        for (Integer i:
                myList) {
            System.out.print(i + " -> ");
        }
    }

    public void lambdaInt (){
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);


    }
//Empty Stream   //TODO Stream
    public Stream<String> emptyList(List<String>list){
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

//Stream of Collection
    public Stream<String> collectionStream (){
        Collection<String> coll = Arrays.asList("a","b","c");
        Stream<String> stream = coll.stream();
        return stream;
    }

//Stream of Array
    public Stream<String> arrayStream (){
        String[] coll = new String[]{"a","b","c"};
        Stream<String> stream = Arrays.stream(coll);
        return stream;

        // OR
//      Stream<String> streamOfArray = Stream.of("a", "b", "c");
    }

//Stream of Builder
    public void streamBulilder(){
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();
    }

    public static void mapStream (){
        List<Integer> list = Arrays.asList(27,1,2021);
        List<Integer> sequare =  list.stream().map(x->x*x).collect(Collectors.toList());
        List<String>  str = Arrays.asList("Maria","meme","Hadeel");

        List<String>  sequareStr =  str.stream().filter(s->s.startsWith("M")).collect(Collectors.toList());
        System.out.println(sequareStr);

        sequareStr=str.stream().sorted().collect(Collectors.toList());


        System.out.println(sequareStr);
        System.out.println(sequare);
        System.out.println(list);

    }
}
