public class RotationJoker {
  protected boolean recto;

  public void action(Enqueteurs enquet, Plateau plat) {
    Tuile[][] plateau = plat.composition;
    if (this.recto) {
      //Récupérer les coordonnées i et j de la tuile à tourner et le côté du mur
      int i = 0;
      int j = 0;
      String orientation = "bas";
      plateau[i][j].rotation(orientation);
    }
    else {
      //Récupérer le détective à bouger et de combien (1 quand le detective joue, 0 ou 1 quand Jack joue)
      String detective = "sherlock";
      int nb = 1;
      enquet.changePosition(detective, nb);
    }
    this.recto = !this.recto;
  }
}
