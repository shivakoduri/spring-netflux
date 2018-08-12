package com.myproject.examples.springnetflux;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FunctionalProgrammingExamples {

    /* 4 properties of a function
     * 1. name
     * 2. return type
     * 3. parameter list
     * 4. body
     */
    @Test
    public void functionWith4Things() throws Exception {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In thread t1");
            }
        });
        t1.start();
        System.out.println("In Main Test");
    }

    @Test
    public void lambdaExpression() throws Exception {
         /*
         //lambda expression
        // (parameter list) -> body
             * 1. name - anonymous
             * 2. return type - can be inferred
             * 3. parameter list
             * 4. body
         */
         Thread t1 = new Thread(() -> System.out.println("Silence of the Lambdas"));
        // ^ Constructor is a higher order function,
        // function is a first class citizen
        t1.start();
        System.out.println("In Main Test");
    }

    @Test
    public void listIterator() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        System.out.println("--very complex, requires a lot of knowledge of code, a lot to go wrong");
        for(int i=0; i<dogs.size(); i++){
            System.out.println(dogs.get(i));
        }

        System.out.println("--simpler, still using external iterator");
        for(String doggy: dogs){
            System.out.println(doggy);
        }

        System.out.println("--list internal iterator consumer");
        dogs.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("--internal iterator lambda method type inference");
        dogs.forEach((String s) -> System.out.println(s));

        System.out.println("--internal iterator lambda method type inference just one");
        dogs.forEach((s) -> System.out.println(s));

        System.out.println("--internal iterator lambda method type java8 method ref");
        dogs.forEach(System.out::println);

        //Get count of dogs with 6 char in name
        System.out.println(
                dogs.stream().filter(dog -> dog.length() ==6).collect(Collectors.toList()).size());
    }
}
