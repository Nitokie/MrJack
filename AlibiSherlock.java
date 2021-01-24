import java.util.Random;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.ArrayList;

public class AlibiSherlock {
  protected boolean recto;

  //Définir qui joue (string/boolean)
  public Dictionary action(boolean tourJack, Dictionary cartes, MisterJack MrJack, Plateau plat, Enqueteurs enquet) {
    Tuile[][] plateau = plat.composition;
    if (this.recto) {
      //Piocher une carte Alibi
      ArrayList<String> listeSus = new ArrayList<String>();
      Enumeration enu = cartes.keys();
      while (enu.hasMoreElements()) {
        listeSus.add(String.valueOf(enu.nextElement()));
      }

      String carteTiree = listeSus.get(new Random().nextInt(cartes.size()));
      if (tourJack) {
        MrJack.nombreSablier += (int) cartes.get(carteTiree);
      }
      else {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            if (plateau[i][j].suspect == carteTiree) {
                plateau[i][j].retourner(plat);
            }
          }
        }
      }
      cartes.remove(carteTiree);
    }
    else {
      int nb = 1; //Demander au joueur 1 ou 2
      enquet.changePosition("sherlock", nb);
    }
    this.recto = !this.recto;
    return cartes;
  }
}
