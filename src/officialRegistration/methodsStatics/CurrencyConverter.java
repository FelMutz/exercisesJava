package officialRegistration.methodsStatics;


public class CurrencyConverter {

    public static final double dollarTax = 0.06;

    public static double Quotation(double dollarPrice, double dollarWanted){
        return (dollarPrice * dollarWanted)+ (dollarPrice * dollarWanted)*dollarTax;
    }
}
