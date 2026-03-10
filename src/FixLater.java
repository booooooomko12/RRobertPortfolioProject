import fundamentals.EMNumber;

public class FixLater {
    public static void main(String[] args) {
        EMNumber test = new EMNumber();
        EMNumber intTest = new EMNumber(30);
        System.out.println("Empty EMNumber: " + test.toString());
        test.add(intTest);
        System.out.println("EMNumber(30): " + intTest.toString());
        System.out.println("Empty + 30: " + test.toString());
        EMNumber doubleTest = new EMNumber(309.52332);
        System.out.println("EMNumber(309.52332): " + doubleTest.toString());
        test.multiply(doubleTest);
        System.out.println("30 * 309.52332: " + test.toString());
        EMNumber giganticNumber = new EMNumber(9.4234, 48245);
        System.out.println("Large EMNumber (L): " + giganticNumber.toString());
        giganticNumber.divide(test);
        System.out
                .println("L / (30 * 309.52332): " + giganticNumber.toString());
    }

}
