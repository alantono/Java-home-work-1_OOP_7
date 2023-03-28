package Unit;
public class Sniper extends Archer {

    // Снайпер
    public Sniper(String name, Vector2D coords) {
        super(name, 12, 10, 8, 10, 15, 15,
                9, coords.x, coords.y, 1, 32);
    }        
    
    public String getInfo() {
        return String.format("%s    ; Team:%d; %s; speed:%d; hp:%.0f; shots:%d; state:%s; x:%d; y:%d",
    this.getClass().getSimpleName(), teams, this.name, speed, hp, shots, state, coords.x, coords.y);
}
}

