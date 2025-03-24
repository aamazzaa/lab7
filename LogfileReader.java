import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class LogfileReader implements Iterator<LogEntry>
{
    private ArrayList<LogEntry> entries;
    private Iterator<LogEntry> dataIterator;
    
    public LogfileReader()
    {
        this("weblog.txt");
    }

    public LogfileReader(String filename)
    {
        entries = new ArrayList<>();
        try {
            URL fileURL = getClass().getClassLoader().getResource(filename);
            if(fileURL == null) {
                throw new FileNotFoundException(filename);
            }
            Scanner logfile = new Scanner(new File(fileURL.toURI()));
            while(logfile.hasNextLine()) {
                String logline = logfile.nextLine();
                LogEntry entry = new LogEntry(logline);
                entries.add(entry);
            }
            logfile.close();
        }
        catch(Exception e) {
            System.out.println("Error reading file: " + e);
            new LogfileCreator().createSimulatedData(entries);
        }
        Collections.sort(entries);
        reset();
    }

    public boolean hasNext()
    {
        return dataIterator.hasNext();
    }

    public LogEntry next()
    {
        return dataIterator.next();
    }

    public void reset()
    {
        dataIterator = entries.iterator();
    }
}
