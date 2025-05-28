import java.io.IOException;

public class Klasa_startowa {
    // Punkt wejścia programu
    public static void main(String[] args)  {
        // Pobiera czas rozpoczęcia programu w milisekundach
    	try {
    		Handyones.getFilePath();
    	}catch(IOException e){
    		System.out.println("Ścieżka do pliku którą podałeś nie istnieje lub nie masz do niej dostępu");
    		main(new String[]{});
    	}
        long startTime = System.currentTimeMillis();
        // Wywołuje główne menu aplikacji, przekazując czas rozpoczęcia
        Interface.main_menu(startTime);    
    }
}