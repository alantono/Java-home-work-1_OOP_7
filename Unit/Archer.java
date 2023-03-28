package Unit;

import java.util.ArrayList;

public abstract class Archer extends Characters{

    // Лучник (с подклассами Арбалетчик, Снайпер)
    protected int shots;

public Archer(String name, int attack, int defense, int damage_min, int damage_max, float hp, float hp_max,
            int speed, int x, int y, int teams, int shots) {
        super(name, attack, defense, damage_min, damage_max, hp, hp_max, speed, x, y, teams);
        this.shots = shots;
    }

@Override
public void step(ArrayList<Characters> teams_1, ArrayList<Characters> teams_2) {
    if (state.equals("Die") || shots == 0) return;
    int target = findNearest(teams_2);
    float damage = (teams_2.get(target).defense - attack > 0) ? damage_min : 
    (teams_2.get(target).defense - attack < 0) ? damage_max : 
    (damage_max + damage_min)/2;
    teams_2.get(target).getDamage(damage); // передаем противнику повреждение

    for (int i = 0; i < teams_1.size(); i++) {
        if (teams_1.get(i).getInfo().toString().split(":")[0].equals("Farmer") && teams_1.get(i).state.equals("Stand")) {
            teams_1.get(i).state = "Busy";
            return;
        }
    }
    shots --;
}

// альтернативный вариант приведенному выше методу передачи противнику повреждений
// @Override
// public void step(ArrayList<Characters> teams_1, ArrayList<Characters> teams_2) {
//     if (state.equals("Die") || shots == 0) return;
//     Characters victim = teams_2.get(findNearest(teams_2));
//     float damage = (victim.defense - attack > 0) ? damage_min : 
//     (victim.defense - attack < 0) ? damage_max : 
//     (damage_max + damage_min)/2;
//     victim.getDamage(damage); // передаем противнику повреждение

//     for (Characters human: teams_1) {
//         String s = human.getInfo().split(":")[0];
//         String s1 = human.state
//         if (human.getInfo().toString().split(":")[0].equals("Farmer") && human.state.equals("Stand")) {
//             human.state = "Busy";
//             return;
//         }
//     }
//     shots --;
// }
@Override
public String toString() {
    return name +
            "\t| H:" + Math.round(hp) +
            "\tD:" + defense +
            "\tA:" + attack +
            "\tDmg:" + Math.round(Math.abs((damage_min + damage_max) / 2)) +
            "\tShots:" + shots +
            "  " + state;
}

protected boolean findFarmer(ArrayList<Characters> team) {
    ArrayList <Characters> arrayFarmer = new ArrayList<>();
    for (int i = 0; i < team.size(); i++) {
        if (team.get(i).getClass() == Farmer.class) {
            if(((Farmer) team.get(i)).getShotsFarmer() > 0) {
                arrayFarmer.add(team.get(i));
            }
        }
    }
    switch (arrayFarmer.size()) {
        case (0):
            return false;
        case (1):
            ((Farmer) arrayFarmer.get(0)).setShotsFarmer(0);
            return true;
        default:
            ((Farmer) arrayFarmer.get(findNearest(arrayFarmer))).setShotsFarmer(0);
            return true;
    }
} 


}
