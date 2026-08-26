import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    static int invalidLines = 0; // to keep track of invalid lines skipped
    static int totalScores = 0; // to keep track of total scores processed
    public static void main(String[] args) {
       // Step 1: read scores from file
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores(filename);
        double avg = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {

            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        writeReport(scores, avg, highest, lowest, "report.txt");
        // System.out.println(scores);
        // Step 2: calculate statistics
        // Step 3: write and print report
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalScores++;
                if (line.trim().isEmpty()) {
                    invalidLines++; // increment invalid line count
                    continue; // this is to skip empty lines
                }
                try {
                    int number = Integer.parseInt(line.trim());
                    scores.add(number);
                } catch (NumberFormatException e) {
                    invalidLines++; // increment invalid line count
                    System.out.println("Skipping invalid value: " + line);
                }
            }
        } catch (IOException e) {
            invalidLines++;
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) { //return 0.0 if the list is empty
            return 0.0;
        }
        double sum = 0.0;
        for (int score : scores) {
            sum += score;
        }
            return sum / scores.size();

    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            writer.write("=== Grade Analysis Report ===");
            System.out.println("=== Grade Analysis Report ===");
            writer.newLine();

            writer.write(String.format("Total Scores Processed: %d%n", totalScores));
            System.out.println(String.format("Total Scores Processed: %d%n", totalScores));
            writer.write(String.format("Invalid Lines Skipped: %d%n", invalidLines)); 
            System.out.println(String.format("Invalid Lines Skipped: %d%n", invalidLines));
            writer.newLine();

            writer.write(String.format("Average Score: %.2f%n", avg));
            // writer.newLine(); 
            System.out.println(String.format("Average Score: %.2f%n", avg));

            writer.write(String.format("Highest Score: %d%n", high));
            // writer.newLine();
            System.out.println(String.format("Highest Score: %d%n", high));

            writer.write(String.format("Lowest Score: %d%n", low));
            writer.newLine();
            System.out.println(String.format("Lowest Score: %d%n", low));

            writer.write("Grade Distribution:");
            writer.newLine();
            System.out.println("Grade Distribution:");

            writer.write(String.format("A (90 - 100): %d", countA));
            writer.newLine();
            System.out.println(String.format("A (90 - 100): %d", countA));

            writer.write(String.format("B (80 - 89): %d", countB));
            writer.newLine();
            System.out.println(String.format("B (80 - 89): %d", countB));

            writer.write(String.format("C (70 - 79): %d", countC));
            writer.newLine();
            System.out.println(String.format("C (70 - 79): %d", countC));

            writer.write(String.format("D (60 - 69): %d", countD));
            writer.newLine();
            System.out.println(String.format("D (60 - 69): %d", countD));

            writer.write(String.format("F (below 60): %d", countF));
            System.out.println(String.format("F (below 60): %d", countF));

        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }

    
} 
