package modifie;

/**
 * Directeur : connaît l'ALGORITHME de construction (ordre des étapes)
 * et le pilote à travers l'interface du MonteurAbstrait. Il ignore
 * quelle pizza concrète est produite.
 */
public class Directeur {
    private MonteurPizza monteur;

    public Directeur(MonteurPizza monteur) {
        this.monteur = monteur;
    }

    public void setMonteur(MonteurPizza monteur) {
        this.monteur = monteur;
    }

    public Pizza construire() {
        monteur.creerNouvellePizza();
        monteur.monterPate();
        monteur.monterSauce();
        monteur.monterFromage();
        monteur.monterGarniture();
        return monteur.getPizza();
    }
}
