package modifie;

/**
 * Version "naïve" (celle du cours) instrumentée pour la démonstration :
 * le constructeur est volontairement lent, ce qui rend visible la
 * condition de course quand plusieurs threads appellent getInstance()
 * en même temps.
 */
public final class SingletonNaif {

    private static SingletonNaif instance = null;
    private static int nombreCreations = 0;

    private SingletonNaif() {
        try {
            Thread.sleep(50); // simule une initialisation coûteuse
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (SingletonNaif.class) {
            nombreCreations++;
        }
    }

    public static SingletonNaif getInstance() {
        if (instance == null) {          // plusieurs threads peuvent passer ce test
            instance = new SingletonNaif();
        }
        return instance;
    }

    public static synchronized int getNombreCreations() {
        return nombreCreations;
    }
}
