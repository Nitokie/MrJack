import java.util.Map;
import java.util.Scanner;

public abstract class Jetons {
  protected String nomRecto, nomVerso, nom;
  protected boolean recto;
  protected Scanner scanner = new Scanner(System.in);

  public String getNom() {
    if (this.recto) {
      return nomRecto;
    }
    else {
      return nomVerso;
    }
  }

  public String getType() {
    return nom;
  }

  public Map<String, Integer> action(boolean tourJack, Map<String, Integer> cartes, MisterJack MrJack, Plateau plat, Enqueteurs enquet) {
    return null;
  }

  public void action(Enqueteurs enquet, Plateau plat) {

  }

  public void action(Plateau plat) {

  }

  public void action(Enqueteurs enquet) {

  }
}
