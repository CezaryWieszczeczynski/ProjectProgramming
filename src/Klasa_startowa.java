public class Klasa_startowa {
    // Punkt wejścia programu
    public static void main(String[] args) {
        // Pobiera czas rozpoczęcia programu w milisekundach
        long startTime = System.currentTimeMillis();
        // Wywołuje główne menu aplikacji, przekazując czas rozpoczęcia
        Interface.main_menu(startTime);    
    }
}