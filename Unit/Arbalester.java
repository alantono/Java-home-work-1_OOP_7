package Unit;
public class Arbalester extends Archer {

// Арбалетчик

    public Arbalester(String name, Vector2D coords) {
        super(name, 6, 3, 2, 3, 10, 10,
                4, coords.x, coords.y, 2,16);
    }

    @Override
    public String getInfo() {
        return String.format("%s; Team:%d; %s; speed:%d; hp:%.0f; shots:%d; state:%s; x:%d; y:%d",
       this.getClass().getSimpleName(), teams, this.name, speed, hp, shots, state, coords.x, coords.y);
   }
}

