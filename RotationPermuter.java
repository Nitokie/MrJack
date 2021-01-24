public class RotationPermuter {
  protected boolean recto;

  public void action(Plateau plat) {
    Tuile[][] plateau = plat.composition;
    if (this.recto) {
      //Récupérer les coordonnées i et j de la tuile à tourner et le côté du mur
      int i = 0;
      int j = 0;
      String orientation = "bas";
      plateau[i][j].rotation(orientation);
    }
    else {
      //Récupérer les coordonnées i et j des tuiles à permuter
      int i1 = 0;
      int j1 = 0;
      int i2 = 2;
      int j2 = 2;
      plat.permuter(i1, j1, i2, j2);
    }
    this.recto = !this.recto;
  }
}
