public class RotationPermuter extends Jetons {

  public RotationPermuter() {
    this.nom = "RP";
    this.nomRecto = "Rotation";
    this.nomVerso = "Permuter";
    this.recto = true;
  }

  public void action(Plateau plat) {
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
      //Récupérer les coordonnées i et j des tuiles à permuter
      System.out.println("Rentrez les coord i et j (de 0 a 2) de la premiere tuile");
      int i1 =  Integer.parseInt(this.scanner.nextLine());
      int j1 =  Integer.parseInt(this.scanner.nextLine());
      System.out.println("Rentrez les coord i et j (de 0 a 2) de la deuxieme tuile");
      int i2 =  Integer.parseInt(this.scanner.nextLine());
      int j2 =  Integer.parseInt(this.scanner.nextLine());
      plat.permuter(i1, j1, i2, j2);
    }
    this.recto = !this.recto;
  }
}
