package ru.ttv.interviewprepare.lesson2;

import java.io.*;

/**
 * @author Teplykh Timofey  04.09.2019
 */
public class ClassReadWriter {

    public static void saveAsText(Hero hero, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("class: ");
        fileWriter.write(hero.getHeroClass());
        fileWriter.write("\n");
        fileWriter.write("name: ");
        fileWriter.write(hero.getName());
        fileWriter.write("\n");
        fileWriter.write("level: ");
        fileWriter.write(String.valueOf(hero.getLevel()));
        fileWriter.write("\n");
        fileWriter.write("hp: ");
        fileWriter.write(String.valueOf(hero.getHp()));
        fileWriter.write("\n");
        fileWriter.write("maxHP: ");
        fileWriter.write(String.valueOf(hero.getMaxHp()));
        fileWriter.write("\n");
        fileWriter.close();
    }

    public static void saveAsCompressedText(Hero hero, File file) throws IOException{
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(hero.getHeroClass());
        fileWriter.write("\n");
        fileWriter.write(hero.getName());
        fileWriter.write("\n");
        fileWriter.write(String.valueOf(hero.getLevel()));
        fileWriter.write("\n");
        fileWriter.write(String.valueOf(hero.getHp()));
        fileWriter.write("\n");
        fileWriter.write(String.valueOf(hero.getMaxHp()));
        fileWriter.write("\n");
        fileWriter.close();
    }

    public static Hero loadAsCompressedText(File file) throws IOException{
        Hero hero = new Hero();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (int i = 1; i <=5 ; i++) {
            String line = bufferedReader.readLine();
            switch (i){
                case 1: hero.setHeroClass(line);
                break;
                case 2: hero.setName(line);
                break;
                case 3: hero.setLevel(Integer.parseInt(line));
                break;
                case 4: hero.setHp(Integer.parseInt(line));
                break;
                case 5: hero.setMaxHp(Integer.parseInt(line));
            }
        }
        bufferedReader.close();
        fileReader.close();
        return hero;
    }
}
