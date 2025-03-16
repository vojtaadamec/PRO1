import pro1.ExamRecord;
import pro1.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvExporter{
    public static void main(String[] args) {
        try {

            Files.createDirectories(Paths.get("C:/data/output"));


            File inputDir = new File("C:/data/input");
            File[] inputFiles = inputDir.listFiles();

            if (inputFiles == null) {
                System.out.println("File not found");
                return;
            }


            for (File inputFile : inputFiles) {
                System.out.println("Processing: " + inputFile.getName());


                ExamRecord[] records = Main.readInputFile(inputFile.toPath());


                String outputFileName = inputFile.getName().replace(".txt", ".csv");
                String outputPath = "C:/data/output/" + outputFileName;

                exportToCsv(records, outputPath);
                System.out.println("File created successfully!");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    private static void exportToCsv(ExamRecord[] records, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ExamRecord record : records) {
                writer.write(record.getName() + ", " + record.getScore().toString());
                writer.newLine();
            }
        }
    }
}