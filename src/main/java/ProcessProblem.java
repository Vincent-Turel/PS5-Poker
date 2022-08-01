public class ProcessProblem {
    public static boolean toDo(Exception e) {
        System.err.println(e.toString());
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Veuillez saisir deux main valides !");
        return false;
    }
}
