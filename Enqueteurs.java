import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Enqueteurs {
  protected String[] suspect;
  protected boolean visible;
  protected int watson;
  protected int sherlock;
  protected int toby;

  public Enqueteurs(Plateau plat) {
    this.watson = new Random().nextInt(3);
    this.sherlock = this.watson + 4;
    this.toby = this.sherlock + 4;
    Tuile[][] plateau = plat.composition;
    int[] listePos = {this.watson, this.sherlock, this.toby};
    for (int a =0; a < listePos.length; a++) {
      if (listePos[a] < 3) {
        plateau[0][listePos[a]].orientation = "haut";
      }
      else if (listePos[a] < 6) {
        plateau[listePos[a]-3][2].orientation = "droite";
      }
      else if (listePos[a] < 9) {
        plateau[2][8-listePos[a]].orientation = "bas";
      }
      else if (listePos[a] < 12) {
        plateau[11 - listePos[a]][0].orientation = "gauche";
      }
    }
  }

  public void changePosition(String enqueteur, int nb) {
    switch (enqueteur) {
      case "Watson" :
        this.watson = (this.watson + nb) % 12;
        break;
      case "Sherlock" :
        this.sherlock = (this.sherlock + nb) % 12;
        break;
      case "Toby" :
        this.toby = (this.toby + nb) % 12;
        break;
    }
  }

  public boolean isVisible(Plateau plat, MisterJack MrJack) {
    String criminel = MrJack.criminel;
    Tuile[][] plateau = plat.composition;
    int[] listePos = {this.watson, this.sherlock, this.toby};
    List<String> susVisibles = new ArrayList<String>();
    for (int a = 0; a < listePos.length; a++) {
      int cote = listePos[a]/3;
      int emplacement = 2*(1-listePos[a]%3)*(listePos[a]/6)+listePos[a]%3;
      //System.out.println(cote);
      //System.out.println(emplacement);
      switch (cote) {
        case 0:
          for (int i = 0; i < 3; i++) {
            if (plateau[i][emplacement].orientation == "haut") {
              break;
            }
            else if (plateau[i][emplacement].tuileRecto) {
              susVisibles.add(plateau[i][emplacement].suspect);
            }
            if (plateau[i][emplacement].orientation == "bas") {
              break;
            }
          }
          break;
        case 1:
          for (int i = 2; i > -1; i--) {
            if (plateau[emplacement][i].orientation == "droite") {
              break;
            }
            else if (plateau[emplacement][i].tuileRecto) {
              susVisibles.add(plateau[emplacement][i].suspect);
            }
            if (plateau[emplacement][i].orientation == "gauche") {
              break;
            }
          }
          break;
      case 2:
        for (int i = 2; i > -1; i--) {
          if (plateau[i][emplacement].orientation == "bas") {
            break;
          }
          else if (plateau[i][emplacement].tuileRecto) {
            susVisibles.add(plateau[i][emplacement].suspect);
          }
          if (plateau[i][emplacement].orientation == "haut") {
            break;
          }
        }
        break;
      case 3:
        for (int i = 0; i < 3; i++) {
          if (plateau[emplacement][i].orientation == "gauche") {
            break;
          }
          else if (plateau[emplacement][i].tuileRecto) {
            susVisibles.add(plateau[emplacement][i].suspect);
          }
          if (plateau[emplacement][i].orientation == "droite") {
            break;
          }
        }
        break;
      }
    }
    boolean jack = true;
    if (!susVisibles.contains(criminel)) {
      jack = false;
      MrJack.nombreSablier += 1;
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (jack != susVisibles.contains(plateau[i][j].suspect)) {
          plateau[i][j].retourner(plat);
        }
      }
    }
    return jack;
  }
}
