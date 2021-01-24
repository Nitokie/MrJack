import java.util.Dictionary;
import java.util.Random;

public class Main {
  private boolean victoireJack = false;
  private boolean victoireDetective = false;
  private int tour;
  protected boolean tourJack = false;
  private Dictionary cartes;
  private String[] suspects = {"rose", "noir", "orange", "violet", "vert", "jaune", "bleu", "blanc", "gris"};
  protected Plateau plat = new Plateau();
  protected Enqueteurs enquet = new Enqueteurs(plat);
  protected MisterJack MrJack = new MisterJack(suspects[new Random().nextInt(suspects.length)]);
  protected AlibiSherlock jetonAlibiSher = new AlibiSherlock();
  protected RotationJoker jetonRotationJoker = new RotationJoker();
  protected TobyWatson jetonTobyWatson = new TobyWatson();
  protected RotationPermuter jetonRotationPermuter = new RotationPermuter();
  protected boolean jackvisible;

  public static void main(String[] args) {
    Main main = new Main();
    main.run();
  }

  public void run() {
    cartes = initCartes();
    plat.setTableau();
    cartes.remove(MrJack.criminel);
    tour = 1;
    while (tour < 9 && (victoireJack == victoireDetective)) {
      melanger();
      printboard();
      //Gérer les actions des boutons
      //à l'action 2 et 4, inverser le joueur avec tourJack = !tourJack;
      jackvisible = enquet.isVisible(plat, MrJack);
      if (plat.nombreTuileRecto == 1) {
        victoireDetective = true;
      }
      if (MrJack.nombreSablier > 5) {
        victoireJack = true;
      }
      if (victoireJack && victoireDetective && jackvisible) {
        victoireJack = false;
      }
      tour += 1;
    }
    if (victoireJack && victoireDetective && !jackvisible) {
      victoireDetective = false;
    }
    if (victoireDetective) {
      //Afficher victoire detective
    }
    else {
      //Afficher victoire Jack
    }
  }


  public Dictionary initCartes() {
    cartes.put("rose", 2);
    cartes.put("noir", 0);
    cartes.put("orange", 1);
    cartes.put("violet", 1);
    cartes.put("vert", 1);
    cartes.put("jaune", 1);
    cartes.put("bleu", 0);
    cartes.put("blanc", 1);
    cartes.put("gris", 1);
    return cartes;
  }

  public void melanger() {
    jetonAlibiSher.recto = new Random().nextBoolean();
    jetonTobyWatson.recto = new Random().nextBoolean();
    jetonRotationJoker.recto = new Random().nextBoolean();
    jetonRotationPermuter.recto = new Random().nextBoolean();
  }

  public void printboard() {

  }
}
