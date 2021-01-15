public class Plateau {
  protected Tuile[][] composition;
  protected int nombreTuileRecto;

  public Plateau() {
    this.nombreTuileRecto = 9;
  }

  public void setTableau() {
    String[] listesuspects = ["rose", "noir", "orange", "violet", "vert", "jaune", "bleu", "blanc", "gris"];
    Tuile[] listeTuiles;
    for (int i = 0; i < listesuspects.size(); i++) {
      listeTuiles.append(new Tuile(listesuspects[i], random.nextInt(4)+1));
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; i++) {
        num = random.nextInt(listeTuiles.size());
        this.composition[i][j] = listeTuiles[num];
        listeTuiles.remove(num);
      }
    }
  }

  public void permuter(int i1, int j1, int i2, int j) {
    Tuile permut = this.composition[i1][j1];
    this.composition[i1][j1] = this.composition[i2][j2];
    this.composition[i2][j2] = permut;
  }
}
