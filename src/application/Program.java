package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int num = read.nextInt();

		List<Product> list = new ArrayList<>();

		for (int i = 1; i <= num; i++) {
			System.out.println("Product " + i + " data: ");
			char ans = 0;
			
			do {
				System.out.print("Common, User or Imported (c/u/i): ");
				ans = read.next().charAt(0);

			} while (ans != 'c' && ans != 'u' && ans != 'i');

			read.nextLine();
			System.out.print("Name: ");
			String name = read.nextLine();
			System.out.print("Price: ");
			double price = read.nextDouble();

			if (ans == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(read.next());

				list.add(new UsedProduct(name, price, manufactureDate));
			} else if (ans == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = read.nextDouble();

				list.add(new ImportedProduct(name, price, customsFee));
			} else {

				list.add(new Product(name, price));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product x : list) {
			System.out.println(x.priceTag());
		}
		read.close();
	}
}
