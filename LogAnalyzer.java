/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        hourCounts = new int[24];
        reader = new LogfileReader();
    }

    /**
     * Create an object to analyze hourly web accesses from a particular file.
     */
    public LogAnalyzer(String filename)
    {
        hourCounts = new int[24];
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while (hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }

    /**
     * Return the total number of accesses recorded in the log file.
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for(int count : hourCounts) {
            total += count;
        }
        return total;
    }

    /**
     * Return the busiest hour.
     */
    public int busiestHour()
    {
        int maxCount = 0;
        int busiestHour = 0;

        for(int hour = 0; hour < hourCounts.length; hour++) {
            if(hourCounts[hour] > maxCount) {
                maxCount = hourCounts[hour];
                busiestHour = hour;
            }
        }
        return busiestHour;
    }

    /**
     * Return the quietest hour.
     */
    public int quietestHour()
    {
        int minCount = Integer.MAX_VALUE;
        int quietestHour = 0;

        for(int hour = 0; hour < hourCounts.length; hour++) {
            if(hourCounts[hour] < minCount) {
                minCount = hourCounts[hour];
                quietestHour = hour;
            }
        }
        return quietestHour;
    }

    /**
     * Return the first hour of the busiest two-hour period.
     */
    public int busiestTwoHourPeriod()
    {
        int maxCount = 0;
        int busiestHour = 0;

        for(int hour = 0; hour < hourCounts.length - 1; hour++) {
            int sum = hourCounts[hour] + hourCounts[hour + 1];
            if(sum > maxCount) {
                maxCount = sum;
                busiestHour = hour;
            }
        }
        return busiestHour;
    }
}
