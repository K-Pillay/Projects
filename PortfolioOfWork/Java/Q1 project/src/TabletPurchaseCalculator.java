//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.text.DecimalFormat;


public class TabletPurchaseCalculator {

    // Initialise tablet prices as constants
    private static final double TabletOnePrice = 5799.00;
    private static final double TabletTwoPrice = 7999.00;
    private static final double TabletThreePrice = 10099.00;

    // initialise interest rate as a constant
    private static final double InterestRate = 0.854;


//Method to calculate the monthly installment Taking price as a parameter


    public static void main(String[] args) {
        //Format the currency values for the prices
        DecimalFormat CurrencyFormat = new DecimalFormat("R###,###.00");

        //Display The options to the user and the formatted prices of the tablets
        //ADD /t Character to space out everything
        System.out.println("Tablet Options");
        System.out.println("S - 64GB Tablet\t\t\t" + CurrencyFormat.format(TabletOnePrice));
        System.out.println("M - 128GB Tablet\t\t\t" + CurrencyFormat.format(TabletTwoPrice));
        System.out.println("L - 256GB Tablet\t\t\t" + CurrencyFormat.format(TabletThreePrice));

        //Get Input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a Tablet option S, M, L");
        String option = scanner.next().toUpperCase();//Add uppercase to option by user is capital

        //Make sure That a valid option is chosen
        double TabletPrice = 0;

        if (option.equals("S")) {
            TabletPrice = TabletOnePrice;

        }
        if (option.equals("M")) {
            TabletPrice = TabletTwoPrice;

        }
        if (option.equals("L")) {
            TabletPrice = TabletThreePrice;

        } else {
            System.out.println("Invalid option. Please select from options provided");
        }

        double monthlyinstallments = calcmonthlyInstallment(TabletPrice);

//CALCULATE TOTAL CREDIT PRICE
        double totCreditPrice = TabletPrice * (1 + InterestRate);

        //Print out results
        System.out.println("Monthly installments will be: " + CurrencyFormat.format(monthlyinstallments) + "p.m");
        System.out.println("Total Credit Price is: " + CurrencyFormat.format(totCreditPrice));
    }

    //intialise variable  monthly installments and call method
    private static double calcmonthlyInstallment(double price) {
        return price * (1 + InterestRate) / 24;
    }
}