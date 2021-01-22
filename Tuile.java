public class Tuile {
  protected String suspect;
  private boolean tuileRecto;
  protected String orientation; //haut, droite, bas, gauche

  public Tuile(String suspect,  String orientation) {
    this.suspect = suspect;
    this.tuileRecto = true;
    this.orientation = orientation;
  }

//A voir si on garde orientation + mur -> redondance
//A voir avec interface graphique
  public void rotation(String orientation) {
    if (this.suspect == "gris" && !this.tuileRecto) {
      orientation = "none";
    }
    this.orientation = orientation;
  }

  public void retourner() {
    this.tuileRecto = false;
    this.suspect = "none";
    if (this.suspect == "gris") {
      this.orientation = "none";
    }
  }
}
