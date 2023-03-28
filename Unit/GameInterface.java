package Unit;

import java.util.ArrayList;

public interface GameInterface {
    
    void step(ArrayList<Characters>teams_1, ArrayList<Characters>teams_2);
    String getInfo();
}
