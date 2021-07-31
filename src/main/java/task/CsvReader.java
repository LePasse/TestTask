package task;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader {
    private static final char COMMA_DELIMITER = ',';
    private final String filename;

    public CsvReader(String filename) {
        this.filename = filename;
    }

    public List<String[]> readAll() throws Exception {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(COMMA_DELIMITER).build();
        CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(Paths.get(filename))).withCSVParser(csvParser).withSkipLines(0).build();
        return csvReader.readAll();
    }
}
