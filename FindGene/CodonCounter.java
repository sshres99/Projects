   import edu.duke.*;
    import java.util.*;
public class CodonCounter {
        private ArrayList<Integer> numCodon;
        private ArrayList<String> codon;
        private int unique = 0;
        public CodonCounter(){
            numCodon = new ArrayList<Integer>();
            codon = new ArrayList<String>();    
        }

public void update(String seq){
            if(codon.indexOf(seq) == -1 )
         {
            codon.add(seq);
            numCodon.add(1);
            unique++;
        }
        else{
            int index = codon.indexOf(seq);
            int value = numCodon.get(index);
            numCodon.set(index,value+1);
        }
        
        }
        public void findAllCodons(){
        String s = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        String sequence = "";
        for(int i = 0; i < s.length() - 3;i+=3){
            sequence = s.substring(i,i+3);
            System.out.println(sequence);
            update(sequence);
        }
        }
        public void test(){
            findAllCodons();
            System.out.println("UNIQUE: " + unique);
            for(int i = 0;i < codon.size();i++){
                String se = codon.get(i);
                int count = numCodon.get(i);
                System.out.println(se + " appears " + count + " times ");
            }
        }
    }
    