package Unit;

public class Monk extends Mag{
    
    // монах
    public Monk(String name, Vector2D coords) {
        super(name, 12, 7, -4, -4, 30, 30, 5, coords.x, coords.y, 2, 1, 1);
    }

    public String getInfo() {
        return String.format("%s      ; Team:%d; %s; speed:%d; hp:%.0f; mana :%.0f;  state:%s; x:%d; y:%d",
        this.getClass().getSimpleName(), teams, this.name, speed, hp, mana, state, coords.x, coords.y);
   }
}
