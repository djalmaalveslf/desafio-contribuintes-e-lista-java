package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxPayer = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			System.out.println("\nDigite os dados do " + (i + 1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();

			taxPayer.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
		}

		for (int i = 0; i < taxPayer.size(); i++) {
			System.out.printf("%nResumo do %do contribuinte:%n", i + 1);
			System.out.printf("Imposto bruto total: %.2f%n", taxPayer.get(i).grossTax());
			System.out.printf("Abatimento: %.2f%n", taxPayer.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", taxPayer.get(i).netTax());
		}

		sc.close();
	}

}
