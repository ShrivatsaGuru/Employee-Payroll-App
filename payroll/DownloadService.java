package payroll;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * UC4: DownloadService
 * - Writes a TEXT copy of the payslip to disk.
 * - Uses a deep copy of data to avoid mutating original (integrity).
 * - Generates unique filenames and returns an immutable handle.
 */
public class DownloadService {
    private static final String DEFAULT_DIR = "downloads";     // local folder
    private static final long   DEFAULT_TTL = 24 * 60 * 60 * 1000L; // 24h

    public DownloadedPayslip downloadAsText(Payslip original) {
        // 1) Deep-ish copy: make a safe copy of calculator state
        Payslip copy = original.copy();

        // 2) Unique filename (id + timestamp)
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "payslip_" + copy.getEmployeeId() + "_" + ts + ".txt";

        try {
            Path dir = Paths.get(DEFAULT_DIR);
            Files.createDirectories(dir);
            Path file = dir.resolve(fileName);

            // 3) Write text content (Payslip#toString() already formatted)
            Files.writeString(file, copy.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);

            // 4) Return immutable download handle with TTL
            return new DownloadedPayslip(fileName, file.toAbsolutePath().toString(),
                    System.currentTimeMillis(), DEFAULT_TTL);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write payslip: " + e.getMessage(), e);
        }
    }
}