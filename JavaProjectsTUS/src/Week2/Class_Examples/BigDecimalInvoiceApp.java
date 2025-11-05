package Week2.Class_Examples;

import java.util.Scanner; // Imports scanner library for keyboard input
import java.text.NumberFormat; // NumberFormat is for currency and percent formatting
import java.math.BigDecimal; // Imports math library "BigDecimal" for precise decimal arithmetic
import java.math.RoundingMode; // Rounding mode for setScale rounding policy
import java.util.Locale;

public class BigDecimalInvoiceApp {
    public static void main(String[] args) {
        // create a scanner object named sc
        Scanner sc = new Scanner(System.in);

        //perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (!choice.equalsIgnoreCase("n"))
        {
            // get user input
            System.out.println("Enter subtotal: ");
            double subtotal = sc.nextDouble(); // read subtotal as double from user input

            // calculate the discount amount and invoice total before tax
            double discountPercent = 0.0; // initialize discount percent
            if (subtotal >= 200) // if subtotal is greater than 200, set 20% discount
                    discountPercent = .2;
            else if (subtotal >= 100) // if subtotal is greater than 100, set 10% discount
                    discountPercent = .1;
            else
                    discountPercent = 0.0; // no discount

        // convert subtotal and discount percent to big decimal
            BigDecimal decimalSubtotal = new BigDecimal(Double.toString(subtotal)); // create BigDecimal from string to avoid double precision issues
            decimalSubtotal = decimalSubtotal.setScale(2, RoundingMode.HALF_UP);
            BigDecimal decimalDiscountPercent = 
            new BigDecimal(Double.toString(discountPercent));

        // calculate discount amount
            BigDecimal discountAmount = decimalSubtotal.multiply(decimalDiscountPercent);
            discountAmount = discountAmount.setScale(2, RoundingMode.HALF_UP);

        // calculate total before tax, sales tax, and total
            BigDecimal totalBeforeTax = decimalSubtotal.subtract(discountAmount);
            BigDecimal salesTaxPercent = new BigDecimal(".05");
            BigDecimal salesTax = salesTaxPercent.multiply(totalBeforeTax);
            salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
            BigDecimal total = totalBeforeTax.add(salesTax);

        // get the currency and percent formatter objects
            NumberFormat currency = NumberFormat.getCurrencyInstance(); // formatter for currency
            NumberFormat percent = NumberFormat.getPercentInstance(); // fprmatter for percent

        // display the discount amount and total
            String message = "Subtotal:             " + currency.format(decimalSubtotal) + "\n" + "Discount percent:             " + percent.format(decimalDiscountPercent) + "\n" + 
            "Discount amount:               " + currency.format(discountAmount) + "\n" +
            "Total before tax:              " + currency.format(totalBeforeTax) + "\n" +
            "Sales Tax:                 " + currency.format(salesTax) + "\n" +
            "Invoice total:             " + currency.format(total) + "\n";

            System.out.println(message);

        // see if the user wants to continue
            System.out.println("Continue? (y/n):    ");
            choice = sc.next(); // read user's choice token (y or n)
            System.out.println(); // print blank line to separate runs
        }
        sc.close();
    }
}
