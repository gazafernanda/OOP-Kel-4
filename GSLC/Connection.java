import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection {
	    private String filePath;

	    public Connection(String filePath) {
	        this.filePath = filePath;
	    }

	    public List<String[]> readData() {
	        List<String[]> data = new ArrayList<>();
	        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] row = line.split(",");
	                data.add(row);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }

	    public void writeData(List<String[]> data) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
	            for (String[] row : data) {
	                String line = String.join(",", row);
	                writer.println(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

