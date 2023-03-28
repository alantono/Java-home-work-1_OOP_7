package Unit;
import java.util.ArrayList;

public class Farmer extends Characters {

    // крестьянин
    protected int shots;

    public Farmer(String name, int attack, int defense, int damage_min, int damage_max, float hp, float hp_max,
            int speed, int x, int y, int teams, int shots) {
        super(name, attack, defense, damage_min, damage_max, hp, hp_max, speed, x, y, teams);
        this.shots = shots;
    }
    public Farmer(String name, Vector2D coords) {
        super(name, 1, 1, 1, 1, 1, 1,
                3, coords.x, coords.y, 0);
        this.shots = 1;
    }
    @Override
public void step(ArrayList<Characters> teams_1, ArrayList<Characters> teams_2) {
    if (!this.state.equals("Die")) this.state = "Stand";
}

    public int getShotsFarmer () {
        return this.shots;
    }
    public void setShotsFarmer (int shots) {
        this.shots = shots;
    }
@Override
    public String getInfo() {

        return String.format("%s    ; Team:%d; %s; speed:%d; hp:%.0f;  shots:%d;  state:%s; x:%d; y:%d",
       this.getClass().getSimpleName(), teams, this.name, speed, hp, shots, state, coords.x, coords.y);
   }
}
