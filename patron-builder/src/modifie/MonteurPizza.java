package modifie;

/**
 * MonteurAbstrait : déclare une méthode par partie du produit.
 * Il ne décide PAS de l'ordre d'assemblage : c'est le rôle du Directeur.
 */
public abstract class MonteurPizza {
    protected Pizza pizza;

    /** Démarre la construction d'une nouvelle pizza (un monteur est réutilisable). */
    public void creerNouvellePizza() {
        pizza = new Pizza();
        pizza.setNom(getNom());
    }

    /** Renvoie le produit une fois assemblé. */
    public Pizza getPizza() {
        return pizza;
    }

    protected abstract String getNom();

    public abstract void monterPate();

    public abstract void monterSauce();

    public abstract void monterFromage();

    public abstract void monterGarniture();
}
