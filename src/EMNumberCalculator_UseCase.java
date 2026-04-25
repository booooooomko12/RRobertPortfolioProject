import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import fundamentals.EMNumber;

/**
 * Example use case of EMNumber
 */
public class EMNumberCalculator_UseCase {
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        EMNumber current = new EMNumber();
        String command = "";

        do {
            out.println("Current value: " + current.toString());
            out.println(
                    "(Commands: [+] [-] [*] [/]) (Remember: Enter a number after your command with a space between!)");
            out.println("Entering any other character first will exit.");
            command = in.nextLine();
            switch (command.charAt(0)) {
                case '+':
                    current.add(new EMNumber(new NaturalNumber1L(
                            command.substring(2, command.length()))));
                    break;
                case '-':
                    if (current.compareTo(new EMNumber(new NaturalNumber1L(
                            command.substring(2, command.length())))) > 0) {
                        current.subtract(new EMNumber(new NaturalNumber1L(
                                command.substring(2, command.length()))));
                    } else {
                        out.println(
                                "Error: Cannot subtract to numbers < 0. Skipping...");
                    }
                    break;
                case '*':
                    current.multiply(new EMNumber(new NaturalNumber1L(
                            command.substring(2, command.length()))));
                    break;
                case '/':
                    current.divide(new EMNumber(new NaturalNumber1L(
                            command.substring(2, command.length()))));
                    break;
                default:
                    command = "e";
            }
        } while (command.charAt(0) != 'e');
    }

}
