import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import Unit.*;

public class Main {
    public static ArrayList<Characters> allTeam = new ArrayList<>();
    public static ArrayList<Characters> teams_1 = new ArrayList<>(10);
    public static ArrayList<Characters> teams_2 = new ArrayList<>(10);

    public static void main(String[] args) {
            
// получаю список из 7 героев - teams
            ArrayList<Characters> teams = new ArrayList<>();
            teams.add(new Rogue(getName(), new Vector2D(0, 0)));
            teams.add(new Sniper(getName(), new Vector2D(0, 0)));
            teams.add(new Farmer(getName(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
            teams.add(new Monk(getName(), new Vector2D(0, 0)));
            teams.add(new Spearman(getName(), new Vector2D(0, 0)));
            teams.add(new Wizard(getName(), new Vector2D(0, 0)));
            teams.add(new Arbalester(getName(), new Vector2D(0, 0)));

// формирую первую команду teams-1 из 10ти героев (из крестьян, разбойников, снайперов и колдунов)
            Random rnd = new Random();
            int count = 1;
            while (count <= 10) {
            if (((teams.get(rnd.nextInt(0,7))).getClass().getSimpleName()).equals("Rogue") && count <= 10 ) {
                 teams_1.add(new Rogue(getName(), new Vector2D(0, 0))); count ++;}
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Sniper") && count <= 10 ) {
                 teams_1.add(new Sniper(getName(), new Vector2D(0, 0))); count ++;}
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Wizard") && count <= 10 ) {
                teams_1.add(new Wizard(getName(), new Vector2D(0, 0))); count ++;}
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Farmer") && count <= 10 ) {
                teams_1.add(new Farmer(getName(), 1, 1, 1, 1, 1, 1, 3, 0, 0, 1, 1)); count ++;}
            }

// и сортирую первую команду teams-1 по скорости героев 
            teams_1.sort(new Comparator<Characters>(){
                @Override
                public int compare(Characters o1, Characters o2) {
                        if (o2.getSpeed() == o1.getSpeed()) {
                        return (int) (o1.getHp() - o2.getHp());
                    }
                        return o2.getSpeed() - o1.getSpeed();    }      }
   );
//  добавляю начальные координаты для каждого героя команды 1 (х, у): (1,1) (1,2) (1,3) (1,4) ... (1,9) (1,10)
                for (int i = 0; i < (teams_1.size()); i++) {
                        teams_1.get(i).coords.y = 1;  // присвоили 1 координате х игроку с инд i
                        int s = rnd.nextInt(1, 11);
                        int k = 0;
                        while (k < 10) {
                            if (teams_1.get(k).coords.x == s) {
                                s = rnd.nextInt(1, 11);
                                k = (-1);              }
                            k++;       }
                        teams_1.get(i).coords.x = s;                }


// формирую вторую команду teams-2 из 10ти героев (крестьян, копейщиков, арбалетчиков, монахов)
            int count2 = 1;
            while (count2 <= 10) {
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Monk") && count2 <= 10 ) {
                teams_2.add(new Monk(getName(), new Vector2D(0, 0))); count2 ++;}
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Farmer") && count2 <= 10 ) {
                teams_2.add(new Farmer(getName(), 1, 1, 1, 1, 1, 1, 3, 0, 0, 2, 1)); count2 ++;}
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Spearman") && count2 <= 10 ) {
                teams_2.add(new Spearman(getName(), new Vector2D(0, 0))); count2 ++;}
            if (((teams.get(rnd.nextInt(0, 7))).getClass().getSimpleName()).equals("Arbalester") && count2 <= 10 ) {
                teams_2.add(new Arbalester(getName(), new Vector2D(0, 0))); count2 ++;}
            }
// и сортирую вторую команду teams-2 по скорости героев 
            teams_2.sort(new Comparator<Characters>(){
                @Override
                public int compare(Characters o1, Characters o2) {
                        if (o2.getSpeed() == o1.getSpeed()) {
                        return (int) (o1.getHp() - o2.getHp());                    }
                        return o2.getSpeed() - o1.getSpeed();    }     }   );
//  добавляю начальные координаты для каждого героя команды 2 (х, у): (10,1) (10,2) (10,3) (10,4) ... (10,9) (10,10)

for (int i = 0; i < (teams_2.size()); i++) {
   teams_2.get(i).coords.y = 10;  //  x = 10 для всех членов второй команды
   int s = rnd.nextInt(1, 11);
   int k = 0;
   while (k < 10) {
            if (teams_2.get(k).coords.x == s) {
                s = rnd.nextInt(1, 11);
                k = (-1);              }
            k++;       }
   teams_2.get(i).coords.x = s;}
 
// объединяю обе команды в один список
    allTeam.addAll(teams_1);
    allTeam.addAll(teams_2);
    System.out.println("++++ Total team ++++");
    for (Characters item : allTeam) {
            System.out.println(item.getInfo()); }

// Хожу
    try (Scanner user_input = new Scanner(System.in)) {
        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        int dieCount_1 = 1;
        int dieCount_2 = 1;

    while (true){
            
            // проверяю наличие живых игроков в первой команде
            for (int i = 0; i < 10; i++) { 
                if (allTeam.get(i).getInfo().contains("Die")) 
                {dieCount_1++;}}
            if (dieCount_1 == 10) {
                    System.out.println(""); 
                    System.out.println("++++++++++++ выиграла команда 2 ++++++++++++");
                    View.view();
                break; }  
            else dieCount_1 = 1;             
            // проверяю наличие живых игроков во второй команде
            for (int i = 10; i < 19; i++) { 
                if (allTeam.get(i).getInfo().contains("Die")) 
                {dieCount_2++;}}
            if (dieCount_2 == 10) {
                    System.out.println(""); 
                    System.out.println("++++++++++++ выиграла команда 1 ++++++++++++");
                    View.view();    
                break; }  
            else dieCount_2 = 1;


        View.view();                               
        user_input.nextLine();

    for (Characters hero: allTeam) {
        System.out.println(hero.getInfo());
        if (teams_1.contains(hero)) hero.step(teams_1, teams_2);
        else hero.step(teams_2, teams_1);                                    }
            }
        }  
    }   
    private static String getName(){
        String name = String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
        return name; }
}

