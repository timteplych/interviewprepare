package ru.ttv.interviewprepare.lesson2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

/**
 * @author Teplykh Timofey  04.09.2019
 */
public class Hero implements Externalizable {

    private static final long serialVersionUID = 1L;

    private String heroClass;

    private String name;

    private int level;

    private int hp;

    private int maxHp;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(heroClass);
        out.writeUTF(name);
        out.writeInt(level);
        out.writeInt(hp);
        out.writeInt(maxHp);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.heroClass = in.readUTF();
        this.name = in.readUTF();
        this.level = in.readInt();
        this.hp = in.readInt();
        this.maxHp = in.readInt();
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "heroClass='" + heroClass + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", maxHp=" + maxHp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return level == hero.level &&
                hp == hero.hp &&
                maxHp == hero.maxHp &&
                heroClass.equals(hero.heroClass) &&
                name.equals(hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroClass, name, level, hp, maxHp);
    }
}
