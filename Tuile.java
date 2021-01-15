public class Tuile {
  private String suspect;
  private boolean tuileRecto;
  protected int orientation; //1 pour en haut, +1 sens horaire, 0 inexistant;

  public Tuile(String suspect,  int orientation) {
    this.suspect = suspect;
    this.tuileRecto = true;
    this.orientation = orientation;
  }

//A voir si on garde orientation + mur -> redondance
  public void rotation(int orientation, String mur) {
    if (this.suspect == "gris") {
      orientation = 0;
    }
    else if (mur == "haut") {
      orientation = 1;
    }
    else if (mur == "droite") {
      orientation = 2;
    }
    else if (mur == "bas") {
      orientation = 3;
    }
    else if (mur == "gauche") {
      orientation = 4;
    }
    this.orientation = orientation;
  }

  public void retourner(suspect) {
    this.tuileRecto = false;
    this.suspect = "none";
    if (this.suspect == "gris") {
      this.orientation = 0;
    }
  }
}
