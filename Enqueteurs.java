public class Enqueteurs {
  protected String[] suspect;
  protected boolean visible;
  protected String joueur;
  protected int watson;
  protected int sherlock;
  protected int toby;

  public Enqueteurs(String joueur) {
    this.joueur = joueur;
    this.watson = random.nextInt(6);
    this.sherlock = this.watson + 3;
    this.toby = this.sherlock + 3;
  }

  public void changePosition(String enqueteur, int nb) {
    switch (enqueteur) {
      case watson :
        this.watson += nb;
        break;
      case sherlock :
        this.sherlock += nb;
        break;
      case toby :
        this.toby += nb;
        break;
    }
  }

  public void isVisible() {
    int[] listePos = [this.watson, this.sherlock, this.toby];
    String[] susVisibles;
    for (int i = 0; i < listePos.size(); i++) {
      int cote = listePos[i]/3;
      int emplacement = 2*(listePos[i]/6)-listePos[i]%3;
      //REMPLACER
      //NOM
      //PLATEAU !!!
      switch (cote) {
        case 0:
          for (int i = 0; i < 3; i++) {
            if (plateau[emplacement][i].orientation != 3) {
              if (plateau[emplacement][i].suspect != "none") {
                susVisibles.append(plateau[emplacement][i].suspect);
              }
            }
            else {
              i = 3;
            }
          }
          break;
        case 1:
          for (int i = 2; i > -1; i--) {
            if (plateau[i][emplacement].orientation != 4) {
              if (plateau[i][emplacement].suspect != "none") {
                susVisibles.append(plateau[i][emplacement].suspect);
              }
            }
            else {
              i = -1;
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
          if (plateau[emplacement][i].orientation != 1) {
            if (plateau[emplacement][i].suspect != "none") {
              susVisibles.append(plateau[emplacement][i].suspect);
            }
          }
          else {
            i = -1;
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
          if (plateau[i][emplacement].orientation != 2) {
            if (plateau[i][emplacement].suspect != "none") {
              susVisibles.append(plateau[i][emplacement].suspect);
            }
          }
          else {
            i = 3;
          }
        }
        break;
      }
    }

    //REGARDER SI MR JACK DANS LISTE SUS
    

  }
}
