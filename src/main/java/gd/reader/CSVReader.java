package gd.reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by rajani.maski on 7/11/17.
 */
public class CSVReader {

    public static void main(String[] args) throws IOException{
        parseKaggleJobCSV();

    }

    static  void parseKaggleJobCSV()throws IOException {

        Reader in = new FileReader("/Users/rajani.maski/data_job_posts.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withCommentMarker('#').withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withIgnoreEmptyLines(true).parse(in);

        int i =0;
        for (CSVRecord record : records) {
            record.toMap().forEach((key, val) -> System.out.println(key + val));
            i++;
            if(i>2)
                System.exit(0);
        }
    }

    static void parseCommonInputsWithComma() throws IOException{

        Reader in = new FileReader("/Users/rajani.maski/gd/search-jobs-api/problemsolving/src/main/resources/common_inputs.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withCommentMarker('#').withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withIgnoreEmptyLines(true).parse(in);


        for (CSVRecord record : records) {
            record.toMap().forEach((key, val) -> System.out.println(key +  val));

            String id = record.get("jobListingCtr");
            String customerNo = record.get("employerCtr");
            String name = record.get("gdApplyEnabled");
          //  System.out.println(id +" " + customerNo + " " + name);
        }
    }

    static void parseWithTab() throws IOException{
        Reader in = new FileReader("/Users/rajani.maski/gd/search-jobs-api/problemsolving/src/main/resources/io_tab.tsv");
        Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withCommentMarker('#').withIgnoreEmptyLines(true).parse(in);
        for (CSVRecord record : records) {
           record.forEach(elem -> System.out.println(elem));
            String id = record.get("uniqueId");
            String customerNo = record.get("jobDescription");
            String name = record.get("employer");
            System.out.println(id +" " + customerNo + " " + name);
        }
    }
}
