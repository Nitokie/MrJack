public class Tuile {
  protected String suspect;
  protected boolean tuileRecto;
  protected String orientation; //haut, droite, bas, gauche
  protected boolean pivotee;

  public Tuile(String suspect,  String orientation) {
    this.suspect = suspect;
    this.tuileRecto = true;
    this.orientation = orientation;
    this.pivotee = false;
  }

//Impossible de pivoter deux fois la même tuile dans le même tour -> Retourner erreur ?
  public void rotation(String orientation) {
    if (this.suspect == "gris" && !this.tuileRecto) {
      orientation = "none";
    }
    if (!this.pivotee) {
      this.orientation = orientation;
      this.pivotee = true;
    }
  }

  public void retourner(Plateau plat) {
    if (this.tuileRecto) {
      plat.nombreTuileRecto -= 1;
      this.tuileRecto = false;
      if (this.suspect == "gris") {
        this.orientation = "none";
      }
    }
  }
}
