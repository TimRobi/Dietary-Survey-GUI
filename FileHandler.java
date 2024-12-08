import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class handles reading from and writing to a CSV file that stores the survey results.
 * It is responsible for creating the file (if it doesn't exist), overwriting it if necessary, 
 * and appending new survey data to it.
 * @author Timothy Robillard
 * @version 1.0
 * @since 2024-12-07
 */
public class FileHandler {

    // The name of the file where survey results will be stored
    private static final String FILE_NAME = "survey_results.csv";

    /**
     * Constructor for the FileHandler class.
     * This constructor creates a new file if it doesn't exist, overwrites it if it does,
     * and writes the header row to the file for the survey results.
     * The header contains the fields: DateTime, FirstName, LastName, PhoneNumber, Email, Sex, 
     * Water, Meals, Wheat, Sugar, Dairy, Miles, and Weight.
     */
    public FileHandler() {
        File file = new File(FILE_NAME);
        
        // Overwrite the file (delete and create a new file) and write the header
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            // Write header to the file
            writer.write("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,"
                    + "Wheat,Sugar,Dairy,Miles,Weight\n");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    /**
     * Appends a new survey entry to the CSV file.
     * The method adds the current date and time along with the provided survey data.
     * The data is appended to the file without overwriting existing entries.
     *
     * @param surveyData The survey data to be written to the CSV file, in CSV format.
     *                   This data is expected to include values for the user's survey responses.
     */
    public void writeResults(String surveyData) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            // Get the current date and time in the required format
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
            // Append the new data
            writer.write(dateTime + "," + surveyData + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
