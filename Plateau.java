import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Plateau {
  protected Tuile[][] composition;
  protected int nombreTuileRecto;

  public Plateau() {
    this.nombreTuileRecto = 9;
  }

  public void setTableau() {
    String[] listesuspects = {"rose", "noir", "orange", "violet", "vert", "jaune", "bleu", "blanc", "gris"};
    ArrayList<Tuile> listeTuiles = new ArrayList<Tuile>();
    String[] direction = {"haut", "droite", "bas", "gauche"};
    for (int i = 0; i < listesuspects.length; i++) {
      listeTuiles.add(new Tuile(listesuspects[i], direction[(new Random().nextInt(4))+1]));
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
}
