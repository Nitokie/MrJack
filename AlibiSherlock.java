import java.util.Random;
import java.util.Map;
import java.util.ArrayList;

public class AlibiSherlock extends Jetons {

  public AlibiSherlock() {
    this.nom = "AS";
    this.nomRecto = "Alibi";
    this.nomVerso = "Sherlock";
    this.recto = true;
  }

  //Définir qui joue (string/boolean)
  public Map<String, Integer> action(boolean tourJack, Map<String, Integer> cartes, MisterJack MrJack, Plateau plat, Enqueteurs enquet) {
    Tuile[][] plateau = plat.composition;
    if (this.recto) {
      //Piocher une carte Alibi
      ArrayList<String> listeSus = new ArrayList<String>();
      for ( String key : cartes.keySet() ) {
    	  listeSus.add(String.valueOf(key));
    	}

      String carteTiree = listeSus.get(new Random().nextInt(cartes.size()));
      System.out.println("Carte tiree : " + carteTiree + " : " + cartes.get(carteTiree) + " sablier(s)");
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
      System.out.println("Indiquez de combien de cases bouger Sherlock");
      int nb = Integer.parseInt(this.scanner.nextLine());
      enquet.changePosition("Sherlock", nb);
    }
    this.recto = !this.recto;
    return cartes;
  }
}
