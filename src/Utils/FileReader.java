package Utils;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    private String fileName;

    public FileReader(String filename) {
        fileName = filename;
    }

    public ArrayList<String []> readFile() throws Exception {
        Path p = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(p,
                StandardCharsets.US_ASCII);
        ArrayList<String []> returnList = new ArrayList<String []>();

        //Read the header
        String headLine = br.readLine();
        String[] header = headLine.split(",");
        returnList.add(header);

        String line = br.readLine();
        while (line != null) {
            String[] inputs = line.split(",");
            returnList.add(inputs);
            line = br.readLine();
        }
        return returnList;
    }
}