package payroll;

import employee.Employee;

/**
 * UC3 + UC4:
 * - UC3: calculates gross/deductions/net and formats slip.
 * - UC4: equals/hashCode, deep copy, and simple accessor for employee id.
 */
public class Payslip {
    private final Employee employee;   // aggregation
    private final SalaryComponents sc; // composition

    private static final double PF_RATE  = 0.12;
    private static final double TAX_RATE = 0.10;
    private final long generatedAt = System.currentTimeMillis();
    public long getGeneratedAt() { return generatedAt; }
    public Payslip(Employee employee, SalaryComponents sc) {
        this.employee = employee;
        this.sc = sc;
    }

    public int getEmployeeId() { return employee.getEmpId(); }

    public double gross() { return sc.getBasic() + sc.sumAllowances(); }
    public double pf()    { return sc.getBasic() * PF_RATE; }
    public double tax()   { return gross() * TAX_RATE; }
    public double totalDeductions() { return pf() + tax() + sc.sumOtherDeductions(); }
    public double net()   { return gross() - totalDeductions(); }

    // UC4: deep copy (clone-like) to preserve original integrity
    public Payslip copy() {
        SalaryComponents cpy = new SalaryComponents()
                .withBasic(sc.getBasic())
                .withAllowances(sc.allowancesCopy())
                .withDeductions(sc.deductionsCopy());
        return new Payslip(employee, cpy); // Employee ref kept for identity; values are re-computed
    }

    // UC4: equals/hashCode based on employee identity + computed totals
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payslip)) return false;
        Payslip other = (Payslip) o;
        return this.employee.getEmpId() == other.employee.getEmpId()
                && Double.compare(this.gross(), other.gross()) == 0
                && Double.compare(this.net(),   other.net())   == 0;
    }
    @Override public int hashCode() {
        int r = Integer.hashCode(employee.getEmpId());
        long g = Double.doubleToLongBits(gross());
        long n = Double.doubleToLongBits(net());
        r = 31 * r + (int)(g ^ (g >>> 32));
        r = 31 * r + (int)(n ^ (n >>> 32));
        return r;
    }

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