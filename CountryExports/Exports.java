import edu.duke.*;
import org.apache.commons.csv.*;

public class Exports {
    public void listExporters(CSVParser parser,String exportOfInterest)
    {
        //for each row in the CSV File
        for(CSVRecord record:parser){
        //Look at the Exports Column
        String export = record.get("Exports");
        //Check if it contains ExportOfInterest
        if(export.contains(exportOfInterest)){
            String country = record.get("Country");
        //If so, write out Country from that row
        System.out.println(country);
    }
}
    }
  public void countryInfo(CSVParser parser, String country)
  {
    for(CSVRecord record:parser)
    {
    String name = record.get("Country");
    String exports = record.get("Exports");
    String value = record.get("Value (dollars)");
    if(name.equals(country))
    {
        System.out.println(country +": " +exports+": "+value);
    }
}
}
public void listExportersTwoProducts(CSVParser parser, String ex1, String ex2)
{
    for(CSVRecord record:parser)
    {
        String exports = record.get("Exports");
        String country = record.get("Country");
        if(exports.contains(ex1)&&exports.contains(ex2))
        System.out.println(country);
    }
}
public void numberOfExporters(CSVParser parser, String ex)
{
    int count = 0;
    for(CSVRecord record:parser)
    {
        String exports = record.get("Exports");
        if(exports.contains(ex))
        count++;
    }
    System.out.println(count);
}

public void bigExporters(CSVParser parser, String value)
{
     for(CSVRecord record:parser)
    {
        String val = record.get("Value (dollars)");
        String country = record.get("Country");
        if(val.length()>value.length())
        System.out.println(country +": " +val);
    }
}
    
    
 public void tester(){
     FileResource fr = new FileResource();
     CSVParser parser = fr.getCSVParser();
     countryInfo(parser,"Nauru");
     parser = fr.getCSVParser();
     listExportersTwoProducts(parser,"cotton","flowers");
     parser = fr.getCSVParser();
     numberOfExporters(parser,"cocoa");
      parser = fr.getCSVParser();
      bigExporters(parser,"$999,999,999,999");
      parser = fr.getCSVParser();
      

}
}
