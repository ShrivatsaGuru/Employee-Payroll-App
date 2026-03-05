package payroll;

import java.util.Arrays;

/**
 * UC3: SalaryComponents (COMPOSITION)
 * + UC4: add defensive-copy getters for deep copy.
 */
public class SalaryComponents {
    private double basic;
    private double[] allowances = new double[0];
    private double[] deductions = new double[0];

    public SalaryComponents withBasic(double basic) { this.basic = basic; return this; }
    public SalaryComponents withAllowances(double... a) { this.allowances = a == null ? new double[0] : a; return this; }
    public SalaryComponents withDeductions(double... d) { this.deductions = d == null ? new double[0] : d; return this; }

    public double sumAllowances() { return Arrays.stream(allowances).sum(); }
    public double sumOtherDeductions() { return Arrays.stream(deductions).sum(); }

    public double getBasic() { return basic; }

    // --- UC4: defensive copies to support deep copy ---
    public double[] allowancesCopy()  { return Arrays.copyOf(allowances, allowances.length); }
    public double[] deductionsCopy()  { return Arrays.copyOf(deductions, deductions.length); }
}
