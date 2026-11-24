package modifie;

/** Nouveau MonteurConcret ajouté sans modifier le Directeur ni les autres monteurs. */
public class MonteurPizzaVegetarienne extends MonteurPizza {

    protected String getNom() { return "Végétarienne"; }

    public void monterPate() { pizza.setPate("fine"); }

    public void monterSauce() { pizza.setSauce("tomate basilic"); }

    public void monterFromage() { pizza.setFromage("chèvre"); }

    public void monterGarniture() { pizza.setGarniture("poivrons + olives + oignons"); }
}
