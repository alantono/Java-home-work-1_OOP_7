package Unit;
import java.util.ArrayList;

import Unit.Characters;
public abstract class Mag extends Characters {
    protected float mana;
    protected float mana_max;
    @Override
    public String toString() {
        return name +
                "\t| H:" + Math.round(hp) +
                "\tD:" + defense +
                "\tA:" + attack +
                "\tDmg:" + Math.round(Math.abs((damage_min + damage_max) / 2)) + 
                "\tMana:" + Math.round(mana) +
                "\t  " + state;
    }
    public Mag(String name, int attack, int defense, int damage_min, int damage_max, float hp, float hp_max, int speed,
            int x, int y, int teams, float mana, float mana_max) {
        super(name, attack, defense, damage_min, damage_max, hp, hp_max, speed, x, y, teams);
        this.mana = mana;
        this.mana_max = mana_max;
        
    }
    @Override
    public void step(ArrayList<Characters> teams_1, ArrayList<Characters> teams_2) {
        if (state.equals("Die") || mana <= 0) return;
    // если не труп то найти среди своих персонажа с здоровьем меньше максимального и вылечить его!
        for (int i = 0; i < teams_1.size(); i++) {
            if (teams_1.get(i).hp < teams_1.get(i).hp_max) {
                teams_1.get(i).hp++; 
                break;
            }
                }
            mana --;
        }
    // альтернативный вариант лечения персонажа среди своих
    // @Override
    // public void step(ArrayList<Characters> teams_1, ArrayList<Characters> teams_2) {
    //     if (state.equals("Die") || mana <= 0) return;
    // // если не труп то найти среди своих персонажа с здоровьем меньше максимального и вылечить его!
    //     for (Characters human: teams_1) {
    //         if (human.hp < human.hp_max) {
    //             human.getDamage(damage_max); 
    //             break;
    //         }
    //             }
    //         mana --;
    //     }
}
