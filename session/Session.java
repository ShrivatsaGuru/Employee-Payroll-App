package session;

public class Session {
    private final String username;
    private final long createdAtMillis = System.currentTimeMillis();
    private final long timeoutMillis;

    public Session(String username, long timeoutMillis) {
        this.username = username;
        this.timeoutMillis = timeoutMillis;
    }

    public String getUsername() { return username; }
    public boolean isExpired() { return System.currentTimeMillis() - createdAtMillis > timeoutMillis; }
}