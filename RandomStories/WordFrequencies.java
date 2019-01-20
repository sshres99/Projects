import edu.duke.*;
import java.util.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
     myWords.clear();
     myFreqs.clear();
     int counter = 0;
     FileResource fr = new FileResource();
     for(String s : fr.words()){
         s = s.toLowerCase();
         int index = myWords.indexOf(s);
         if(index == -1){
             myWords.add(s);
             myFreqs.add(1);
             counter++;
            }
            else
            {
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
                value = myFreqs.get(index);
            }
        }
        for(int i = 0;i<myWords.size();i++)
        {
            String word = myWords.get(i);
            int count = myFreqs.get(i);
            System.out.println(word + ": " + count);
        }
        System.out.println("There are " + counter + " unique words in the file.");
    }
    public void findIndexOfMax()
    {
        int maxIndex = 0;
        int maxValue = 0;
        for(int i =0;i<myWords.size();i++){
            if(myFreqs.get(i)>maxValue){
            maxValue = myFreqs.get(i);
            maxIndex = i;
        }
        }
        System.out.println("The word that occurs most often and its count are: " +myWords.get(maxIndex) +" " + myFreqs.get(maxIndex));
        
    }
    
    public void tester(){
        findUnique();
        findIndexOfMax();
    }
     
             
    
     
    
    

}
