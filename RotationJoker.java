public class RotationJoker extends Jetons {

  public RotationJoker() {
    this.nom = "RJ";
    this.nomRecto = "Rotation";
    this.nomVerso = "Joker";
    this.recto = true;
  }


  public void action(Enqueteurs enquet, Plateau plat) {
    Tuile[][] plateau = plat.composition;
    if (this.recto) {
      //Récupérer les coordonnées i et j de la tuile à tourner et le côté du mur
      System.out.println("Rentrez la nouvelle orientation du mur (bas, haut, gauche, droite)");
      String orientation = this.scanner.nextLine();
      System.out.println("Rentrez les coord i et j (de 0 a 2) de la tuile");
      int i =  Integer.parseInt(this.scanner.nextLine());
      int j =  Integer.parseInt(this.scanner.nextLine());
      plateau[i][j].rotation(orientation);
    }
    else {
      //Récupérer le détective à bouger et de combien (1 quand le detective joue, 0 ou 1 quand Jack joue)
      System.out.println("Indiquez quel detective bouger (Toby, Watson, Sherlock)");
      String detective = this.scanner.nextLine();
      System.out.println("Indiquez de combien de cases bouger le detective");
      int nb = Integer.parseInt(this.scanner.nextLine());
      enquet.changePosition(detective, nb);
    }
    this.recto = !this.recto;
  }
}
