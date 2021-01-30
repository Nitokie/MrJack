import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private boolean victoireJack = false;
  private boolean victoireDetective = false;
  private int tour;
  protected boolean tourJack = false;
  private Map<String, Integer> cartes = new HashMap<String, Integer>();
  private String[] suspects = {"rose", "noir", "orange", "violet", "vert", "jaune", "bleu", "blanc", "gris"};
  protected Plateau plat = new Plateau();
  protected Enqueteurs enquet = new Enqueteurs(plat);
  protected MisterJack MrJack = new MisterJack(suspects[new Random().nextInt(suspects.length)]);
  protected Jetons jetonAlibiSher = new AlibiSherlock();
  protected Jetons jetonRotationJoker = new RotationJoker();
  protected Jetons jetonTobyWatson = new TobyWatson();
  protected Jetons jetonRotationPermuter = new RotationPermuter();
  protected boolean jackvisible;

  protected ArrayList<Jetons> listeAct = new ArrayList<Jetons>();
  protected Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Main main = new Main();
    main.run();
  }

  public void run() {
    cartes = initCartes();
    cartes.remove(MrJack.criminel);
    tour = 1;
    while (tour < 9 && (victoireJack == victoireDetective)) {
      if (tour%2 == 1) {
        melanger();
      }

      listeAct.add(jetonAlibiSher);
      listeAct.add(jetonTobyWatson);
      listeAct.add(jetonRotationJoker);
      listeAct.add(jetonRotationPermuter);

      //Gérer les actions des boutons
      //à l'action 2 et 4, inverser le joueur avec tourJack = !tourJack;

      for (int aRest = 4; aRest > 0; aRest--) {
        printboard(plat);
        //changer le tour
        if (aRest == 3 || aRest == 1) {
          tourJack = !tourJack;
        }
        //tour de :
        if (tourJack) {
          System.out.println("Tour de Jack\n");
          System.out.println("Jack est : " + MrJack.criminel);
          System.out.println("Nombre de sabliers de MrJack : " + MrJack.nombreSablier + "\n");
        }
        else {
          System.out.println("Tour des Detectives\n");
          System.out.println("Nombre de suspects restants : " + plat.nombreTuileRecto + "\n");
        }
        //Print des actions
        for (int iListeAct = 0; iListeAct < listeAct.size(); iListeAct++) {
          System.out.println(iListeAct + " : " + listeAct.get(iListeAct).getNom());
        }
        //Selection action + parametres
        System.out.println("Choix de l'action : ");
        int choixAct = scanner.nextInt();
        //Faisage action
        switch (listeAct.get(choixAct).getType()) {
          case "AS":
            listeAct.get(choixAct).action(tourJack, cartes, MrJack, plat, enquet);
            break;
          case "TW":
            listeAct.get(choixAct).action(enquet);
            break;
          case "RJ":
            listeAct.get(choixAct).action(enquet, plat);
            break;
          case "RP":
            listeAct.get(choixAct).action(plat);
            break;
        }
        listeAct.remove(choixAct);
        //Réaffichage
      }

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
      plat.clearpivotee();
    }
    printboard(plat);
    if (victoireJack && victoireDetective && !jackvisible) {
      victoireDetective = false;
    }
    if (victoireDetective) {
      //Afficher victoire detective
      System.out.println("Victoire des detectives !");
    }
    else {
      //Afficher victoire Jack
      System.out.println("Victoire de Jack !");
    }
  }


  public Map<String, Integer> initCartes() {
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

  public void printboard(Plateau plat) {
    String espace = " ";
    String perso = new String();
    String dir = new String();
    String rect = new String();
    System.out.println("    0" + espace.repeat(9) + "1" + espace.repeat(9) + "2");
    for (int i = 0; i < 3; i++) {
      perso = (char) 11-i + espace.repeat(2 + i/2);
      dir = "    ";
      for (int j = 0; j < 3; j++) {
        dir += plat.composition[i][j].orientation + espace.repeat(10-plat.composition[i][j].orientation.length());
        if (plat.composition[i][j].tuileRecto) {
          perso += plat.composition[i][j].suspect + espace.repeat(10-plat.composition[i][j].suspect.length());
        }
        else {
          perso += "VERSO " + espace.repeat(10-5);
        }
      }
      System.out.println("\n" + perso + "  " + (3+i));
      System.out.println(dir);
    }
    System.out.println("    8" + espace.repeat(9) + "7" + espace.repeat(9) + "6");
    System.out.println();
    System.out.println("Position des enqueteurs :");
    System.out.println("Sherlock : " + enquet.sherlock + " Watson : " + enquet.watson + " Toby : " + enquet.toby);
    System.out.println();
  }
}
