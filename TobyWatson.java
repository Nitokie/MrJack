public class TobyWatson extends Jetons {

  public TobyWatson() {
    this.nom = "TW";
    this.nomRecto = "Toby";
    this.nomVerso = "Watson";
    this.recto = true;
  }

  public void action(Enqueteurs enquet) {
    if (this.recto) {
      System.out.println("Indiquez de combien de cases bouger Toby");
      int nb =  Integer.parseInt(this.scanner.nextLine());
      enquet.changePosition("Toby", nb);
    }
    else {
      System.out.println("Indiquez de combien de cases bouger Watson");
      int nb =  Integer.parseInt(this.scanner.nextLine());
      enquet.changePosition("Watson", nb);
    }
    this.recto = !this.recto;
  }
}
