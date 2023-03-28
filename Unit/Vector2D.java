package Unit;

import java.util.ArrayList;

public class Vector2D {
    public int x;
    public int y;
    
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
// вычисляем дистанцию
    public Double getDistanсe (Vector2D opponent) {
        return Math.sqrt(Math.pow(x - opponent.x, 2) + Math.pow(y - opponent.y, 2));

    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
     public boolean getLeft(Vector2D opponent) {
        return opponent.x < x;
    }
    public boolean getDown(Vector2D opponent) {
        return opponent.y < y;
    }
   
    public boolean getEmpty(ArrayList<Characters> team, int x, int y) {
        boolean bool = true;
        for (Characters human: team) {
            if (human.coords.x == x & human.coords.y == y) {
                bool = false;
                break;
            }
        }
return bool;
    }

}
