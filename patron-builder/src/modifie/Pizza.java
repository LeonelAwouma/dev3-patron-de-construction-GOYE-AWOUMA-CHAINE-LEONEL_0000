package modifie;

/** Produit : l'objet complexe assemblé partie par partie. */
public class Pizza {
    private String nom = "";
    private String pate = "";
    private String sauce = "";
    private String fromage = "";
    private String garniture = "";

    public void setNom(String nom) { this.nom = nom; }

    public void setPate(String pate) { this.pate = pate; }

    public void setSauce(String sauce) { this.sauce = sauce; }

    public void setFromage(String fromage) { this.fromage = fromage; }

    public void setGarniture(String garniture) { this.garniture = garniture; }

    @Override
    public String toString() {
        return "Pizza " + nom
                + "\n  Pâte      = " + pate
                + "\n  Sauce     = " + sauce
                + "\n  Fromage   = " + fromage
                + "\n  Garniture = " + garniture;
    }

    public void print() {
        System.out.println(this);
    }
}
