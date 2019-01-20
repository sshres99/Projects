import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyNameFinder {
public void totalBirths(FileResource fr)
{
    int totalBirths = 0;
    int totalCount = 0;
    int totalBoys = 0;
    int boyCount = 0;
    int totalGirls = 0;
    int girlCount = 0;
    for(CSVRecord rec:fr.getCSVParser(false)){
        int numBorn = Integer.parseInt(rec.get(2));
        totalBirths += numBorn;
        totalCount++;
        if(rec.get(1).equals("M")){
        totalBoys += numBorn;
        boyCount++;
    }
        else {
        totalGirls +=numBorn;
        girlCount++;
    }
    }
    System.out.println("Total Births: " + totalBirths);
    System.out.println("Boy Births: " + totalBoys);
    System.out.println("Boy Names: " + boyCount);
    System.out.println("Girl Births: " + totalGirls);
    System.out.println("Girl Names: " + girlCount);
}
public int getRank(int year,String name,String gender)
{
    int rank = 1;
    int ranking = 0;
   FileResource fr = new FileResource("yob" + year + "short.csv");
   for(CSVRecord rec:fr.getCSVParser(false)){
       if(rec.get(0).equals(name) && rec.get(1).equals(gender))
       ranking = Integer.parseInt(rec.get(2));
    }
    
    for(CSVRecord rec:fr.getCSVParser(false)){
        if(rec.get(1).equals(gender) && Integer.parseInt(rec.get(2)) > ranking)
        rank++;
    }
    
    return rank;   
}
public String getName(int year,int rank,String gender)
{
     FileResource fr = new FileResource("yob" + year + "short.csv");
     boolean avail = false;
     String name ="";
     for(CSVRecord rec:fr.getCSVParser(false))
     {
         if(getRank(year,rec.get(0),gender)==rank)
         {
            name = rec.get(0);
             avail = true;
         }
        }
        if(!avail)
        name = "NO NAME";
        return name;  
}
public void whatIsNameInYear(String name,int year,int newYear,String gender)
{
    int rank = getRank(year,name,gender);
    String newName = getName(newYear,rank,gender);
    System.out.println("If your name was " + name + "in " + year +",then your name would be " +newName+"in " + newYear);
}
public void getTotalBirthRankedHigher(int year,String name,String gender)
{
    FileResource fr = new FileResource("yob" + year + "short.csv");
    int rank = 0;
    for(CSVRecord rec:fr.getCSVParser(false))
    {
    if(rank == 0)
    rank = getRank(year,name,gender) + 1;
    else
    if(getRank(year,rec.get(0),gender)==rank)
    System.out.println(Integer.parseInt(rec.get(2)));
    
}

}
public void test(){

    
}

}

