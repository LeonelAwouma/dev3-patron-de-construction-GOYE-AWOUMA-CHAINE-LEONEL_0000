package modifie;

public class MonteurPizzaReine extends MonteurPizza {

    protected String getNom() { return "Reine"; }

    public void monterPate() { pizza.setPate("croisée"); }

    public void monterSauce() { pizza.setSauce("douce"); }

    public void monterFromage() { pizza.setFromage("mozzarella"); }

    public void monterGarniture() { pizza.setGarniture("jambon + champignon"); }
}
