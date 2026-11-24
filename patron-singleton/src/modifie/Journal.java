package modifie;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Exemple modifié : journal d'application (logger) unique et partagé,
 * implémenté par un Singleton THREAD-SAFE (double-checked locking).
 *
 * Différences avec l'exemple du cours :
 *  - l'attribut de classe est "volatile" et la création est protégée par un
 *    bloc synchronized : plusieurs threads ne peuvent pas créer deux instances ;
 *  - le constructeur privé refuse une seconde création (protection contre la réflexion) ;
 *  - clone() est interdit, comme dans le cours ;
 *  - l'état partagé (la liste des messages) est lui aussi protégé.
 */
public final class Journal {

    private static volatile Journal instance = null;
    private static int nombreCreations = 0;

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    private final List<String> messages = new ArrayList<>();

    private Journal() {
        if (instance != null) {
            throw new IllegalStateException("Journal existe déjà : utiliser Journal.getInstance()");
        }
        nombreCreations++;
    }

    /** Point d'accès global, sûr en environnement multi-thread. */
    public static Journal getInstance() {
        Journal resultat = instance;              // 1re vérification, sans verrou
        if (resultat == null) {
            synchronized (Journal.class) {
                resultat = instance;              // 2e vérification, sous verrou
                if (resultat == null) {
                    instance = resultat = new Journal();
                }
            }
        }
        return resultat;
    }

    public synchronized void log(String niveau, String message) {
        String ligne = String.format("[%s] %-5s %-10s %s",
                LocalTime.now().format(FORMAT), niveau, Thread.currentThread().getName(), message);
        messages.add(ligne);
    }

    public synchronized int getNombreMessages() {
        return messages.size();
    }

    public synchronized void afficher() {
        System.out.println("---- Contenu du journal (" + messages.size() + " messages) ----");
        messages.forEach(System.out::println);
    }

    public static int getNombreCreations() {
        return nombreCreations;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Le Journal est un singleton");
    }
}
