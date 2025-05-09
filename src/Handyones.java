package programowanie_komputerow_1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Handyones {
    public static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return timeFormat.format(new Date());
    }
    
	public static String Date() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
		
	}
	
	public static String Runtime(long pies) {
		long endTime = System.currentTimeMillis();
		long runTime = endTime - pies;
		long sekundy = runTime / 1000;
		long minuty = sekundy / 60;
		long sekundyWyświtlane = sekundy % 60;
		String Wynik = (String) (minuty + ":" + sekundyWyświtlane);
		return Wynik;
		
	}
	
		
		
}
    

	
	

