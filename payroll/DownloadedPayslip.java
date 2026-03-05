package payroll;

/**
 * UC4: Immutable downloaded payslip info (value object).
 * - Stores file identity + simple expiry (TTL).
 * - Implements equals/hashCode (contract).
 */
public final class DownloadedPayslip {
    private final String fileName;     // e.g., payslip_1000_20260305_101530.txt
    private final String fullPath;     // absolute path to file
    private final long createdAtMillis;
    private final long ttlMillis;      // time to live (e.g., 24h)

    public DownloadedPayslip(String fileName, String fullPath, long createdAtMillis, long ttlMillis) {
        this.fileName = fileName;
        this.fullPath = fullPath;
        this.createdAtMillis = createdAtMillis;
        this.ttlMillis = ttlMillis;
    }

    public String getFileName() { return fileName; }
    public String getFullPath() { return fullPath; }
    public boolean isExpired()  { return System.currentTimeMillis() - createdAtMillis > ttlMillis; }

    // Equality by unique file path (simple + stable)
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DownloadedPayslip)) return false;
        DownloadedPayslip other = (DownloadedPayslip) o;
        return this.fullPath.equals(other.fullPath);
    }
    @Override public int hashCode() { return fullPath.hashCode(); }

    @Override public String toString() {
        return "DownloadedPayslip{file='" + fileName + "', path='" + fullPath + "'}";
    }
}