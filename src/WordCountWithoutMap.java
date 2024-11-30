import java.io.*;
import java.util.ArrayList;

public class WordCountWithoutMap {

    public static void main(String[] args) {
        String inputFile = "input.txt";  
        String outputFile = "output.txt";  

        try {
            
            ArrayList<String> words = new ArrayList<>();
            ArrayList<Integer> counts = new ArrayList<>();

            
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    
                    String word = line.trim().toLowerCase();

                    
                    int index = words.indexOf(word);
                    if (index != -1) {
                        
                        counts.set(index, counts.get(index) + 1);
                    } else {
                        
                        words.add(word);
                        counts.add(1);
                    }
                }
            }

            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (int i = 0; i < words.size(); i++) {
                    writer.write(words.get(i) + " " + counts.get(i));
                    writer.newLine();
                }
            }

            System.out.println("Word count has been written to " + outputFile);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
