import java.time.LocalDateTime;

public class LogEntry implements Comparable<LogEntry>
{
    private String ipAddress;
    private LocalDateTime accessTime;
    private String requestedResource;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String logLine)
    {
        try {
            String[] parts = logLine.split(" ");
            this.ipAddress = parts[0];
            this.accessTime = LocalDateTime.parse(parts[1]);
            this.requestedResource = parts[2];
            this.statusCode = Integer.parseInt(parts[3]);
            this.bytesReturned = Integer.parseInt(parts[4]);
        } catch (Exception e) {
            System.out.println("Invalid log entry format: " + logLine);
        }
    }
    
    public LogEntry(String ipAddress, LocalDateTime accessTime, String requestedResource, int statusCode, int bytesReturned)
    {
        this.ipAddress = ipAddress;
        this.accessTime = accessTime;
        this.requestedResource = requestedResource;
        this.statusCode = statusCode;
        this.bytesReturned = bytesReturned;
    }

    public String getIpAddress() { return ipAddress; }
    public LocalDateTime getAccessTime() { return accessTime; }
    public String getRequestedResource() { return requestedResource; }
    public int getStatusCode() { return statusCode; }
    public int getBytesReturned() { return bytesReturned; }
    
    public int getHour() 
    {
        return accessTime.getHour();
    }
    
    @Override
    public int compareTo(LogEntry other)
    {
        return this.accessTime.compareTo(other.accessTime);
    }
    
    @Override
    public String toString()
    {
        return ipAddress + " " + accessTime + " " + requestedResource + " " + statusCode + " " + bytesReturned;
    }
}
