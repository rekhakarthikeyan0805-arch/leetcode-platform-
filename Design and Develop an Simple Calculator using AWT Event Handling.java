import java.util.Scanner;

class PiCalculator {

    // Private variable
    private double pi;

    // Public method
    public void calculatePi(int terms) {

        pi = 0.0;

        for (int i = 0; i < terms; i++) {
            if (i % 2 == 0)
                pi += 4.0 / (2 * i + 1);
            else
                pi -= 4.0 / (2 * i + 1);
        }

        System.out.println("\nCalculating Pi using Leibniz Series...\n");

        displayResult();
        displayPrecision(terms);
        displayPrivate();
    }

    // Public method
    public void displayResult() {
        System.out.println("Public Method - Displaying Result:");
        System.out.println("Approximated value of Pi: " + pi);
    }

    // Protected method
    protected void displayPrecision(int terms) {
        System.out.println("\nProtected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + terms + " terms");
        System.out.println("Series used: Leibniz Series");
        System.out.println("(4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)");
    }

    // Private method
    private void displayPrivate() {
        System.out.println("\nPrivate Data - Accessed only within class:");
        System.out.println("Raw computed value (private): " + pi);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Pi Calculator using Access Specifiers ===");

        System.out.print("Enter the number of terms for Pi approximation: ");
        int terms = sc.nextInt();

        PiCalculator obj = new PiCalculator();

        obj.calculatePi(terms);

        sc.close();
    }
}
