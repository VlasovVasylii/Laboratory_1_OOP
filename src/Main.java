import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String cleaned = line.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "");
                cleaned = cleaned.replaceAll("\\s+", " ").trim();
                writer.write(cleaned + System.lineSeparator());
            }
            System.out.println("Обработка завершена. Результат записан в " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}