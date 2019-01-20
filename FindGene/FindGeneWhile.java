         
        import edu.duke.*;
    import java.util.*;
        public class FindGeneWhile {
            int counter = 0;
            int lcounter = 0;
            int cg = 0;
            int cgcounter = 0;
            int ctgcounter = 0;
            int longest = 0;
            int unique = 0;
           ArrayList<String> codon = new ArrayList<String>();
           ArrayList<Integer> codo = new ArrayList<Integer>();
           String cod = "";
        public String findGene(String dna,int where)
        {
            int startIndex = dna.indexOf("ATG",where);
            int temp = 0;
            int minIndex = 0;
            
            if(startIndex == -1)
            {
            return "";
        }
        
            
            int taaindex = findStopCodon(dna,startIndex,"TAA");
            int tagindex = findStopCodon(dna,startIndex,"TAG");
            int tgaindex = findStopCodon(dna,startIndex,"TGA");
            
            if(taaindex == -1 && tagindex == -1 && tgaindex == -1)
            {
                return"a";
            }
            else
            {
            if(taaindex < 0 && tagindex > 0)
             temp = tagindex;
            else
            if(taaindex > 0 && tagindex < 0)
             temp = tgaindex;
            else
            temp = Math.min(taaindex,tagindex);
        }
        
        if(temp < 0)
         minIndex = tgaindex;
         else
         minIndex = Math.min(temp,tgaindex);
         if(minIndex == dna.length())
            return "b";
            else
            {
 if((dna.substring(startIndex,minIndex+3)).length() > 60)
 lcounter++;
 if((dna.substring(startIndex,minIndex+3)).length() > longest)
     longest = (dna.substring(startIndex,minIndex+3)).length();
 for(int i = 0; i < (dna.substring(startIndex,minIndex+3)).length();i++)
 { 
     if((dna.substring(startIndex,minIndex+3)).charAt(i) == 'C' ||(dna.substring(startIndex,minIndex+3)).charAt(i) == 'G')
    cg++;
    }
    if(cg/(dna.substring(startIndex,minIndex+3).length()) > 0.35)
    cgcounter++;
    counter++;
    cod = dna.substring(startIndex,minIndex+3);
    if(codon.indexOf(cod) == -1){
       codon.add(cod);
       codo.add(1);
       unique++;
    }
    else{
        int index = codon.indexOf(cod);
        int value = codo.get(index);
        codo.set(index,value+1);
    }
        
            return cod;
        }
        
       
        }
    
        public void printAllGenes(String dna)
        {
            int starIndex = 0;
            while(starIndex!=-1)
            {
            String currentGene = findGene(dna,starIndex);
            
        if(currentGene.isEmpty())
        {
            break;
        }
        //System.out.println(currentGene);
        starIndex = dna.indexOf(currentGene,starIndex)+ currentGene.length(); 
        
    }
}
public void printAllCodons(){
    for(int i = 0;i < codon.size();i++){
        String c = codon.get(i);
        int count = codo.get(i);
        System.out.println(c + " appears " + count + " times.");
}
}
        
        
        
       public void test()
       {
           String test ="CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        printAllGenes(test);
        printAllCodons();
       System.out.println("There are " +  unique +  "unique codons in the file.");
    }
            
            
        
        
        public int findStopCodon(String str,int startIndex, String codon)
        {
             int currIndex = str.indexOf(codon,startIndex+3);
                while(currIndex != -1)
                {
                    if((currIndex - startIndex)%3==0)
                    {
                        return currIndex;
                    }
                    else
                    {
                        currIndex = str.indexOf(codon,currIndex+1);
                    }
                }
                    return str.length();
                        
                }
                public void testFindStop()
                {
                    String dna ="xxxyyyzzzTAAxxxyyyzzzTAAxx";
                    int dex = findStopCodon(dna,0,"TAA");
                    //if(dex!=10)
                    System.out.println(dex);
                    dex = findStopCodon(dna,9,"TAA");
                   // if(dex!=21)
                System.out.println(dex);
            }
    }
    
