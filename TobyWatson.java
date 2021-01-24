public class TobyWatson {
  protected boolean recto;

  public void action(Enqueteurs enquet) {
    int nb = 1; //Demander au joueur 1 ou 2
    if (this.recto) {
      enquet.changePosition("toby", nb);
    }
    else {
      enquet.changePosition("watson", nb);
    }
    this.recto = !this.recto;
  }
}
