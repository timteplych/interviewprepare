package ru.ttv.interviewprepare;

import ru.ttv.interviewprepare.lesson1.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //lesson1
        Person person = new Person.Builder().addFirstName("Tim").addLastName("Teplykh").addAge(34).addCountry("Russia").build();
        System.out.println(person);
    }
}
