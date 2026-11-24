package cours.exemple1;

/**
 * Exemple 1 du cours (INF461) : structure générique du patron Singleton.
 * - un attribut de classe qui stocke l'unique instance ;
 * - un constructeur privé ;
 * - une méthode de classe publique getInstance() qui crée l'instance au besoin.
 */
public final class Singleton {

    private static Singleton instance = null;

    // D'autres attributs, classiques et non "static".
    private String attribut1;
    private int attribut2;

    // Constructeur de l'objet.
    private Singleton() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        super();
    }

    // Méthode renvoyant une instance de la classe Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // D'autres méthodes classiques et non "static".
    public void op1(int x, int y, int z) {
        this.attribut1 = "bonjour";
        this.attribut2 = x + y + z;
        System.out.println("op1 -> attribut1 = " + attribut1 + ", attribut2 = " + attribut2);
    }

    public void op2(int x, int y, int z) {
        System.out.println("op2(" + x + ", " + y + ", " + z + ") sur l'instance " + hashCode());
    }
}
