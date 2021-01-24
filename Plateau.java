import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
  protected Tuile[][] composition;
  protected int nombreTuileRecto;

  public Plateau() {
    this.nombreTuileRecto = 9;
  }


//ordre des suspects à rendre aléatoire
  public void setTableau() {
    ArrayList<String> listesuspects = new ArrayList<String>(
      Arrays.asList("rose", "noir", "orange", "violet", "vert", "jaune", "bleu", "blanc", "gris"));
    ArrayList<Tuile> listeTuiles = new ArrayList<Tuile>();
    String[] direction = {"haut", "droite", "bas", "gauche"};
    for (int i = 0; i < listesuspects.size(); i++) {
      int susRandom = new Random().nextInt(listesuspects.size());
      listeTuiles.add(new Tuile(listesuspects.get(susRandom), direction[(new Random().nextInt(4))+1]));
      listesuspects.remove(susRandom);
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; i++) {
        int num = new Random().nextInt(listeTuiles.size());
        this.composition[i][j] = listeTuiles.get(num);
        listeTuiles.remove(num);
      }
    }
  }

  public void permuter(int i1, int j1, int i2, int j2) {
    Tuile permut = this.composition[i1][j1];
    this.composition[i1][j1] = this.composition[i2][j2];
    this.composition[i2][j2] = permut;
  }

  public void clearpivotee() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (composition[i][j].pivotee) {
          composition[i][j].pivotee = false;
        }
      }
    }
  }

}
