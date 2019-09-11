package ru.ttv.interviewprepare;

import ru.ttv.interviewprepare.lesson1.Person;
import ru.ttv.interviewprepare.lesson2.ClassReadWriter;
import ru.ttv.interviewprepare.lesson2.Hero;
import ru.ttv.interviewprepare.lesson3.Counter;
import ru.ttv.interviewprepare.lesson3.CounterLockThread;
import ru.ttv.interviewprepare.lesson3.PingPongMonitor;
import ru.ttv.interviewprepare.lesson3.PingPongThread;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        //lesson1
//        Person person = new Person.Builder().addFirstName("Tim").addLastName("Teplykh").addAge(34).addCountry("Russia").build();
//        System.out.println(person);
//
//        //leeson2
//        File file = new File("D:\\hero.txt");
//        File fileCompressed = new File("D:\\herocompressed.txt");
//        File fileExternalizable = new File("D:\\heroexternalizable.txt");
//        Hero hero = new Hero();
//        hero.setHeroClass("Warrior");
//        hero.setName("Axe");
//        hero.setHp(20);
//        hero.setLevel(5);
//        hero.setMaxHp(50);
//        try {
//            ClassReadWriter.saveAsText(hero, file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //записываем и читаем данные без лишней метаинформации
//        try {
//            ClassReadWriter.saveAsCompressedText(hero, fileCompressed);
//            Hero hero1 = ClassReadWriter.loadAsCompressedText(fileCompressed);
//            System.out.println(hero1.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //читаем/записываем файл при помощи интерфейса externalizable
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(fileExternalizable);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            hero.writeExternal(objectOutputStream);
//
//            objectOutputStream.flush();
//            objectOutputStream.close();
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Hero hero2 = null;
//        try {
//            FileInputStream fileInputStream
//                    = new FileInputStream(fileExternalizable);
//            ObjectInputStream objectInputStream
//                    = new ObjectInputStream(fileInputStream);
//
//            hero2 = new Hero();
//            hero2.readExternal(objectInputStream);
//
//            objectInputStream.close();
//            fileInputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(hero2);
//        if(hero.hashCode() != hero2.hashCode()){
//            System.out.println("hero changed!");
//        }

        //lesson3
        PingPongMonitor pingPongMonitor = new PingPongMonitor();
        pingPongMonitor.currentWord = "Ping";
        Thread thread1 = new PingPongThread("Ping", "Pong", pingPongMonitor);
        thread1.start();
        Thread thread2 = new PingPongThread("Pong", "Ping", pingPongMonitor);
        thread2.start();

        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        Thread lockCounterThread1 = new CounterLockThread(counter, lock);
        Thread lockCounterThread2 = new CounterLockThread(counter, lock);
        lockCounterThread1.start();
        lockCounterThread2.start();
    }
}
