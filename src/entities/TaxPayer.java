package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double salaryMonth = this.salaryIncome / 12;

		if (salaryMonth < 3000) {
			return 0.0;
		} else if (salaryMonth >= 3000 && salaryMonth <= 5000) {
			return this.salaryIncome * 0.1;
		} else {
			return this.salaryIncome * 0.2;
		}
	}

	public double servicesTax() {
		return this.servicesIncome * 0.15;
	}

	public double capitalTax() {
		return this.capitalIncome * 0.2;
	}

	public double grossTax() {
		return (this.salaryTax() + this.servicesTax() + this.capitalTax());
	}

	public double taxRebate() {
		double deductibleExpenses = this.healthSpending + this.educationSpending;
		double maximumDeductible = this.grossTax() * 0.3;

		return deductibleExpenses > maximumDeductible ? maximumDeductible : deductibleExpenses;
	}

	public double netTax() {
		return this.grossTax() - this.taxRebate();
	}
}
