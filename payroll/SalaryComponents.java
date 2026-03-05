package payroll;

import java.util.Arrays;

/**
 * UC3: SalaryComponents (COMPOSITION)
 * - Holds basic pay + variable allowances/deductions.
 * - Provides a tiny fluent API and uses Stream API to sum arrays.
 */
public class SalaryComponents {
    private double basic;
    private double[] allowances = new double[0];   // e.g., HRA, transport, bonus
    private double[] deductions = new double[0];   // e.g., other deductions (besides PF/Tax)

    // ---- Fluent setters (tiny, chainable) ----
    public SalaryComponents withBasic(double basic) { this.basic = basic; return this; }
    public SalaryComponents withAllowances(double... a) { this.allowances = a == null ? new double[0] : a; return this; }
    public SalaryComponents withDeductions(double... d) { this.deductions = d == null ? new double[0] : d; return this; }

    // ---- Aggregations using Stream API (UC3 requirement) ----
    public double sumAllowances() { return Arrays.stream(allowances).sum(); }
    public double sumOtherDeductions() { return Arrays.stream(deductions).sum(); }

    public double getBasic() { return basic; }
}
