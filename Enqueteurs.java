import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Enqueteurs {
  protected String[] suspect;
  protected boolean visible;
  protected String joueur;
  protected int watson;
  protected int sherlock;
  protected int toby;

  public Enqueteurs(String joueur) {
    this.joueur = joueur;
    this.watson = new Random().nextInt(6);
    this.sherlock = this.watson + 3;
    this.toby = this.sherlock + 3;
  }

  public void changePosition(String enqueteur, int nb) {
    switch (enqueteur) {
      case "watson" :
        this.watson = (this.watson + nb) % 12;
        break;
      case "sherlock" :
        this.sherlock = (this.sherlock + nb) % 12;
        break;
      case "toby" :
        this.toby = (this.toby + nb) % 12;
        break;
    }
  }

  public void isVisible(Plateau plat, String criminel) {
    Tuile[][] plateau = plat.composition;
    int[] listePos = {this.watson, this.sherlock, this.toby};
    List<String> susVisibles = new ArrayList<String>();
    for (int a = 0; a < listePos.length; a++) {
      int cote = listePos[a]/3;
      int emplacement = 2*(listePos[a]/6)-listePos[a]%3;
      //REMPLACER
      //NOM
      //PLATEAU !!!
      switch (cote) {
        case 0:
          for (int i = 0; i < 3; i++) {
            if (plateau[emplacement][i].orientation != "haut") {
              break;
            }
            else if (plateau[emplacement][i].orientation != "bas") {
              if (plateau[emplacement][i].suspect != "none") {
                susVisibles.add(plateau[emplacement][i].suspect);
              }
            }
            else {
              break;
            }
          }
          break;
        case 1:
          for (int i = 2; i > -1; i--) {
            if (plateau[emplacement][i].orientation != "droite") {
              break;
            }
            else if (plateau[i][emplacement].orientation != "gauche") {
              if (plateau[i][emplacement].suspect != "none") {
                susVisibles.add(plateau[i][emplacement].suspect);
              }
            }
            else {
              break;
            }
          }
          break;
      case 2:
        if (emplacement == 0) {
          emplacement = 2;
        }
        else if (emplacement == 2) {
          emplacement = 0;
        }
        for (int i = 2; i > -1; i--) {
          if (plateau[emplacement][i].orientation != "bas") {
            break;
          }
          else if (plateau[emplacement][i].orientation != "haut") {
            if (plateau[emplacement][i].suspect != "none") {
              susVisibles.add(plateau[emplacement][i].suspect);
            }
          }
          else {
            break;
          }
        }
        break;
      case 3:
        if (emplacement == 0) {
          emplacement = 2;
        }
        else if (emplacement == 2) {
          emplacement = 0;
        }
        for (int i = 0; i < 3; i++) {
          if (plateau[emplacement][i].orientation != "gauche") {
            break;
          }
          else if (plateau[i][emplacement].orientation != "droite") {
            if (plateau[i][emplacement].suspect != "none") {
              susVisibles.add(plateau[i][emplacement].suspect);
            }
          }
          else {
            break;
          }
        }
        break;
      }
    }

    //REGARDER SI MR JACK DANS LISTE SUS
    boolean jack = false;
    if (susVisibles.contains(criminel)) {
      //parcourt le plateau et retourner() les tuiles pas dans la liste
      jack = true;
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (jack != susVisibles.contains(plateau[i][j].suspect)) {
          plateau[i][j].retourner(plat);
        }
      }
    }
  }
}
