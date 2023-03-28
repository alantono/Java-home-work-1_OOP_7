package Unit;
import java.util.ArrayList;

public class Spearman extends Characters {

// копейщик
    public Spearman(String name, Vector2D coords) {
        super(name, 4, 5, 1, 3, 10, 10, 4, coords.x, coords.y, 2);
                                                }
    @Override
    public void step(ArrayList<Characters> teams_1, ArrayList<Characters> teams_2) {
        if (state.equals("Die")) return;
            Characters victim = teams_2.get(findNearest(teams_2));
             if (coords.getDistanсe(victim.coords) < 2) {
                float damage = (victim.defense - attack > 0) ? damage_min : 
                (victim.defense - attack < 0) ? damage_max : 
                (damage_max + damage_min)/2;
                victim.getDamage(damage); // передаем противнику повреждение
            }
             if (coords.getDown(victim.coords)) {
                    if (coords.y - 1 > victim.coords.y && coords.getEmpty(teams_1, coords.x, coords.y - 1)) {
                    stepDown();
                                }
                    else {
                        sidestep(teams_1, victim);
                        }
                } else {
                    if (coords.y + 1 < victim.coords.y && coords.getEmpty(teams_1, coords.x, coords.y + 1)) {
                        stepUp();}
                    else {
                            sidestep(teams_1, victim);
                        } 
                }
             }
        
        protected void stepDown() {coords.y -= 1;}
        protected void stepUp() {coords.y += 1;}
        protected void sidestep(ArrayList<Characters> team, Characters victim) {
            if (coords.getLeft(victim.coords)) {
                if (coords.getEmpty(team, coords.x - 1, coords.y)) {
                    coords.x -= 1;
                }
            } else {
                if (coords.getEmpty(team, coords.x + 1, coords.y)) {
                    coords.x += 1;
                }
            }
        }

        public String getInfo() {
            return String.format("%s  ; Team:%d; %s; speed:%d; hp:%.0f;           state:%s; x:%d; y:%d",
        this.getClass().getSimpleName(), teams, this.name, speed, hp, state, coords.x, coords.y);
    }
}