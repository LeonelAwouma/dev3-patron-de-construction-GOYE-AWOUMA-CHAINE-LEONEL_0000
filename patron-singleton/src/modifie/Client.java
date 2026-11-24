package modifie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;

/**
 * Démonstration de l'exemple modifié : 10 threads accèdent simultanément
 * au singleton. On compte le nombre d'objets distincts obtenus.
 */
public class Client {

    private static final int NB_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1) Singleton naïf (cours) accédé par " + NB_THREADS + " threads ===");
        int naifs = compterInstances(SingletonNaif::getInstance);
        System.out.println("Instances distinctes obtenues : " + naifs
                + " | constructeur appelé " + SingletonNaif.getNombreCreations() + " fois");

        System.out.println("\n=== 2) Journal thread-safe accédé par " + NB_THREADS + " threads ===");
        int journaux = compterInstances(() -> {
            Journal j = Journal.getInstance();
            j.log("INFO", "connexion d'un utilisateur");
            return j;
        });
        System.out.println("Instances distinctes obtenues : " + journaux
                + " | constructeur appelé " + Journal.getNombreCreations() + " fois");

        Journal journal = Journal.getInstance();
        journal.log("WARN", "fin de la démonstration");
        journal.afficher();

        System.out.println("\n=== 3) Tentative de clonage ===");
        try {
            journal.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Refusé : " + e.getMessage());
        }
    }

    /** Lance NB_THREADS threads au même instant et compte les objets distincts reçus. */
    private static int compterInstances(Supplier<Object> acces) throws InterruptedException {
        Set<Object> instances = Collections.synchronizedSet(
                Collections.newSetFromMap(new IdentityHashMap<>()));
        CountDownLatch depart = new CountDownLatch(1);
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= NB_THREADS; i++) {
            Thread t = new Thread(() -> {
                try {
                    depart.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                instances.add(acces.get());
            }, "Thread-" + i);
            threads.add(t);
            t.start();
        }
        depart.countDown(); // tous les threads démarrent ensemble
        for (Thread t : threads) {
            t.join();
        }
        return instances.size();
    }
}
