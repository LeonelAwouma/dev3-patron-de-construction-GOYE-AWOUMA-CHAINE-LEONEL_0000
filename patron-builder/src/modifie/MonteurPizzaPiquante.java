package modifie;

public class MonteurPizzaPiquante extends MonteurPizza {

    protected String getNom() { return "Piquante"; }

    public void monterPate() { pizza.setPate("feuilletée"); }

    public void monterSauce() { pizza.setSauce("piquante"); }

    public void monterFromage() { pizza.setFromage("cheddar"); }

    public void monterGarniture() { pizza.setGarniture("pepperoni + salami"); }
}
