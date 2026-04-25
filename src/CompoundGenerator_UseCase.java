import javax.sound.midi.Synthesizer;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import fundamentals.EMNumber;
import gameobjects.GameObjectNames;
import gameobjects.Multiplier;
import gameobjects.Generator1;

public class CompoundGenerator_UseCase {
        public static void main(String[] args) {
                SimpleReader in = new SimpleReader1L();
                SimpleWriter out = new SimpleWriter1L();

                out.println("What multiplier should the self generator have? (Can be decimals)");
                double multi = Double.parseDouble(in.nextLine());
                out.println("How many generators should we start with? (>=1 minimum)");
                int amt = in.nextInteger();

                Generator1<Generator1> selfGenerator = new Generator1<Generator1>(
                                GameObjectNames.MK2, new EMNumber(amt),
                                new Multiplier(multi, GameObjectNames.MK2));

                out.println("Just keep pressing enter and watch it grow! (Any input ends program)");
                out.println("Current amount of Self-Generators: "
                                + selfGenerator.amount());

                while (in.nextLine().equals("")) {
                        EMNumber current = selfGenerator.amount();
                        current.add(selfGenerator.generate());
                        selfGenerator.setAmount(current);
                        out.println("Current amount of Self-Generators: "
                                        + selfGenerator.amount());
                }
        }
}
