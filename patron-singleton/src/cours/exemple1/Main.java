package cours.exemple1;

/** Utilisation possible de l'exemple 1 (les deux façons vues en cours). */
public class Main {

    public static void main(String[] args) {
        // ----------------- utilisation possible -----------------
        Singleton.getInstance().op1(1, 2, 3);
        Singleton.getInstance().op2(3, 4, 5);

        // ----------------- autre façon -----------------
        Singleton singl = Singleton.getInstance();
        singl.op1(1, 2, 3);
        singl.op2(3, 4, 5);

        System.out.println("Même instance ? " + (singl == Singleton.getInstance()));
    }
}
