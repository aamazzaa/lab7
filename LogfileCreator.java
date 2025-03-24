import java.util.*;
import java.time.LocalDateTime;

public class LogfileCreator
{
    private static final String[] SAMPLE_IPS = {
        "192.168.1.1", "192.168.1.2", "10.0.0.1", "10.0.0.2"
    };
    
    private static final String[] SAMPLE_PAGES = {
        "/index.html", "/about.html", "/contact.html", "/products.html"
    };

    public void createSimulatedData(ArrayList<LogEntry> entries)
    {
        Random rand = new Random();
        LocalDateTime now = LocalDateTime.now();
        
        for(int i = 0; i < 100; i++) {  // Generating 100 entries
            String ipAddress = SAMPLE_IPS[rand.nextInt(SAMPLE_IPS.length)];
            String page = SAMPLE_PAGES[rand.nextInt(SAMPLE_PAGES.length)];
            int statusCode = 200;  // Assuming all requests are successful
            int bytesReturned = rand.nextInt(5000) + 500;  // Random size between 500 and 5500 bytes
            
            LocalDateTime accessTime = now.minusMinutes(rand.nextInt(1440));  // Anytime within the last 24 hours
            LogEntry entry = new LogEntry(ipAddress, accessTime, page, statusCode, bytesReturned);
            entries.add(entry);
        }
    }
}
