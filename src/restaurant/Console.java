package restaurant;


import java.math.BigInteger;
import java.util.*;

/**
 * @author Miroslav Shilov
 * @apiNote Custom class that provide methods for reading data from the console.
 * We use the standard input "System.in".
 */
public class Console {
    /**
     * Read a real number from the console.
     *
     * @param scan    System.in scanner
     * @param message user message
     * @return number of type double
     */
    public static double readRealNumber(Scanner scan, String message) {
        System.out.print(message);
        String line = scan.next();
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return readRealNumber(scan, message);
        }
    }

    /**
     * Read single character from the console.
     *
     * @param charsGroup group of the character we're looking for.If we have group of
     *                   "[abc]" ,the method will search for a || b || c
     * @param scan       System.in scanner
     * @param message    user message
     * @return String containing single character
     */
    public static String readCharacter(String charsGroup, Scanner scan, String message) {
        System.out.println(message);
        String line = scan.next();
        if (line.matches(charsGroup)) {
            return line;
        } else {
            return readCharacter(charsGroup, scan, message);
        }
    }

    /**
     * Read Integer numbers from the console and store them in to an ArrayList.
     * We have encapsulated user message inside("Input a number ")
     *
     * @param digitsNumber the number of the digits we read
     * @return ArrayList of consumed Integer digits
     * @implNote The user message is hard coded!
     */
    public static ArrayList<Integer> readIntArray(int digitsNumber) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        while (digitsNumber > 0) {
            arr.add((int) readRealNumberInRange(scan, Integer.MIN_VALUE, Integer.MAX_VALUE, "Input a number " + count + "..."));
            digitsNumber--;
            count++;
        }
        scan.close();
        return arr;
    }

    /**
     * Read single number from the console in range of min(inc) to max(inc) number.
     *
     * @param scan    System.in scanner
     * @param min     min value if type double include
     * @param max     max value of type double include
     * @param message user message
     * @return number of type double
     */
    public static double readRealNumberInRange(Scanner scan, double min, double max, String message) {

        System.out.print(message);
        String line = scan.next();
        try {
            double d = Double.parseDouble(line);
            if (d >= min && d <= max) {
                return d;
            } else {
                return readRealNumberInRange(scan, min, max, message);
            }
        } catch (NumberFormatException e) {
            return readRealNumberInRange(scan, min, max, message);
        }
    }

    /**
     * This method clear the console.
     *
     * @implNote Not works in the console of IntelliJ or Eclipse.
     * Use external one like CMD!
     */
    public static void clear() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method read a text from the console and split it to rows with specific length.
     * In other words the every element of the returned List contains String with length of  @param rowLength.
     * If the length of some row is less than the @param rowLength the method fill the end of that row with white spaces
     * to @param rowLength.
     *
     * @param rowLength the length of every row
     * @param message   user message
     * @return List containing a text with specific row length
     */
    public static ArrayList<String> readText(int rowLength, String message) {

        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        String text = scan.nextLine();

        if (!text.isEmpty()) {

            int reminder = text.length() % rowLength;
            //here we separate the text in rows with the same length  | If you have Egyptian flu:  |
            if (reminder == 0) {
                for (int i = rowLength; i <= text.length(); i += rowLength) {
                    lines.add(text.substring(i - rowLength, i));
                }
            } else {
                //here split the text by rowLength until we reach the length ,but without the remainder
                int length = text.length() - reminder;
                for (int i = rowLength; i <= length; i += rowLength) {
                    lines.add(text.substring(i - rowLength, i));
                }
                StringBuilder whiteSpace = new StringBuilder();
                for (int i = 0; i < rowLength - reminder; i++) {
                    whiteSpace.append(" ");
                }
                //and here we get the last letter by using the remainder value
                lines.add(text.substring(text.length() - reminder) + whiteSpace);
            }
        } else {
            return readText(rowLength, message);
        }
        scan.close();
        return lines;
    }

    /**
     * Read single not empty line from the console.
     *
     * @param scan    System.in scanner
     * @param message user message
     * @return String containing consumed line
     */
    public static String readText(Scanner scan, String message) {

        System.out.print(message);
        String line;
        do {
            line = scan.nextLine();
            if (!line.isEmpty()) {
                return line;
            }
        } while (true);
    }

    public static String readTextByPattern(Scanner scan, String format, String okMessage, String nokMessage) {

        System.out.print(okMessage);
        String line;
        do {
            line = scan.nextLine();
            if (!line.isEmpty()) {

                if (line.matches(format)) {
                    return line;
                } else {
                    System.out.println(nokMessage);
                    return readTextByPattern(scan, format, okMessage, nokMessage);
                }
            }
        } while (true);
    }

    /**
     * @param scan    System.in scanner
     * @param message user message
     * @return number of type BigInteger
     */
    public static BigInteger readBigWholeNumber(Scanner scan, String message) {
        System.out.println(message);
        String line = scan.nextLine();
        try {
            return new BigInteger(line);
        } catch (NumberFormatException e) {
            return readBigWholeNumber(scan, message);
        }
    }

    public static List<Integer> readUniqueDiditsNumber(Scanner scan, int length, String message) {

        ArrayList<Integer> num = new ArrayList<>();
        String line = readText(scan, message);
        if (line.length() == length && line.matches("[0-9]+")) {
            //the digits must not repeat in the number
            for (int i = 0; i < length; i++) {
                String s = String.valueOf(line.charAt(i));
                num.add(Integer.parseInt(s));
            }
        }
        Set<Integer> unique = new HashSet<Integer>(num);
        if (unique.size() < length) {
            return readUniqueDiditsNumber(scan, length, message);
        }
        return num;
    }
}

