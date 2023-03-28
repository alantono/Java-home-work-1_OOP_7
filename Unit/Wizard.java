package Unit;

public class Wizard extends Mag{

    // Колдун
    public Wizard(String name, Vector2D coords) {
        super(name, 17, 12, -5, -5, 30, 30, 9, coords.x, coords.y, 1, 1, 1);
    }
    public String getInfo() {
        return String.format("%s    ; Team:%d; %s; speed:%d; hp:%.0f; mana :%.0f;  state:%s; x:%d; y:%d",
        this.getClass().getSimpleName(), teams, this.name, speed, hp, mana, state, coords.x, coords.y);
   }
}