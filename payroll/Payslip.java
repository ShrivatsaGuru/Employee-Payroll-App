package payroll;

import employee.Employee;

/**
 * UC3: Payslip (AGGREGATION: HAS-A Employee, COMPOSITION: HAS-A SalaryComponents)
 * - Computes gross, statutory deductions (PF/Tax), and net.
 * - Kept deliberately simple and readable.
 */
public class Payslip {
    private final Employee employee;          // aggregation
    private final SalaryComponents sc;        // composition

    // Simple statutory rules for demo (tweak freely):
    private static final double PF_RATE  = 0.12;   // 12% of basic
    private static final double TAX_RATE = 0.10;   // 10% of gross

    public Payslip(Employee employee, SalaryComponents sc) {
        this.employee = employee;
        this.sc = sc;
    }

    public double gross() { return sc.getBasic() + sc.sumAllowances(); }
    public double pf()    { return sc.getBasic() * PF_RATE; }
    public double tax()   { return gross() * TAX_RATE; }
    public double totalDeductions() { return pf() + tax() + sc.sumOtherDeductions(); }
    public double net()   { return gross() - totalDeductions(); }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("\n=========== PAYSLIP ===========\n")
            .append("Employee : ").append(employee.getName())
            .append(" (ID: ").append(employee.getEmpId()).append(", Role: ").append(employee.getRole()).append(")\n")
            .append("--------------------------------\n")
            .append(String.format("Basic            : %.2f%n", sc.getBasic()))
            .append(String.format("Allowances (sum) : %.2f%n", sc.sumAllowances()))
            .append(String.format("GROSS            : %.2f%n", gross()))
            .append(String.format("PF (12%% basic)   : %.2f%n", pf()))
            .append(String.format("Tax (10%% gross)  : %.2f%n", tax()))
            .append(String.format("Other Deductions : %.2f%n", sc.sumOtherDeductions()))
            .append(String.format("TOTAL DEDUCTIONS : %.2f%n", totalDeductions()))
            .append(String.format("NET PAY          : %.2f%n", net()))
            .append("================================\n")
            .toString();
    }
}
