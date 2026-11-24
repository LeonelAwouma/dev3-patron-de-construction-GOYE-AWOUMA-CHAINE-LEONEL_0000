package cours;

/** MonteurAbstrait (code du cours). */
public abstract class MonteurPizza {
    protected Pizza pizza = new Pizza();

    public Pizza getPizza() {
        // appel des méthodes pour construire respectivement la pâte, la sauce et la garniture
        monterPate();
        monterSauce();
        monterGarniture();
        return pizza;
    }

    public abstract void monterPate();

    public abstract void monterSauce();

    public abstract void monterGarniture();
}
