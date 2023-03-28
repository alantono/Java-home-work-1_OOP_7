package Unit;

import java.util.ArrayList;

public abstract class Characters implements GameInterface{
    protected String name;
    protected int attack;
    protected int defense;
    protected int damage_min;
    protected int damage_max;
    protected float hp;
    protected float hp_max;
    protected int speed;
    protected int teams;
    public Vector2D coords;
    public String state;
    protected static int heroCnt; // счетчик героев

    @Override
    public String toString() {
        return name +
                "\t| H:" + Math.round(hp) +
                "\tD:" + defense +
                "\tA:" + attack +
                "\tDmg:" + Math.round(Math.abs((damage_min + damage_max) / 2)) +
                "\t         " + state;
    }

    public int[] getCoords() {return new int[]{coords.x, coords.y};}

    public Characters(String name, int attack, int defense, int damage_min, int damage_max, float hp, float hp_max, int speed, int x,
            int y, int teams) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage_min = damage_min;
        this.damage_max = damage_max;
        this.hp = hp;
        this.hp_max = hp_max;
        this.speed = speed;
        this.teams = teams;
        state = "Stand";
        coords = new Vector2D(x, y);
        heroCnt ++;
    }

    // получаем индекс ближайшего противника
    protected int findNearest(ArrayList<Characters> team) {
        double min = 100;
        int index = 0;
        for (int i = 0; i < team.size(); i++) {
                if (min > coords.getDistanсe(team.get(i).coords) & team.get(i).hp != 0) {
                index = i;
                min = coords.getDistanсe(team.get(i).coords);
            }
            }
            
        return index;    
        }
    
    public float getHp() { return hp; } // нужны для сортировки
    public int getSpeed() { return speed; } // нужны для сортировки

    @Override
    public void step(ArrayList<Characters>teams_1, ArrayList<Characters>teams_2) {}// можно будет убрать когда step появится у всех наследников данного класса

    protected void getDamage(float damage){
        this.hp -= damage;
        if (hp > hp_max) hp = hp_max;
        if (hp <= 0) {hp = 0; state = "Die";}
    }
    @Override
    public String getInfo() {
        return new String("");
    }

    public char[] charAt(int i) {
        return null;
    }
    }

