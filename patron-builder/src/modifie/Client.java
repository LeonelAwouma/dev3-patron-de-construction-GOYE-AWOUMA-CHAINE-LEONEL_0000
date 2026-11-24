package modifie;

/**
 * Client : choisit le monteur concret (éventuellement à l'exécution)
 * et le confie au Directeur.
 *   java modifie.Client              -> fabrique les trois pizzas
 *   java modifie.Client vegetarienne -> fabrique seulement la pizza choisie
 */
public class Client {

    public static void main(String[] args) {
        String[] commandes = args.length > 0 ? args
                : new String[] {"reine", "piquante", "vegetarienne"};

        Directeur directeur = new Directeur(new MonteurPizzaReine());
        for (String commande : commandes) {
            directeur.setMonteur(choisirMonteur(commande));
            System.out.println("............ Pizza fabriquée ............");
            directeur.construire().print();
        }
    }

    private static MonteurPizza choisirMonteur(String type) {
        switch (type.toLowerCase()) {
            case "reine":        return new MonteurPizzaReine();
            case "piquante":     return new MonteurPizzaPiquante();
            case "vegetarienne": return new MonteurPizzaVegetarienne();
            default: throw new IllegalArgumentException("Type de pizza inconnu : " + type);
        }
    }
}
