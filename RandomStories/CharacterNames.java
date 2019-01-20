    import edu.duke.*;
    import java.util.*;
    public class CharacterNames {
        private ArrayList<Integer> numLines;
        private ArrayList<String> names;
        public CharacterNames(){
            numLines = new ArrayList<Integer>();
            names = new ArrayList<String>();    
        }
        public void update(String person){
        if(person.length() < 20  && !person.contains("a")&&!person.contains("m")&&!person.contains("g")&& !person.contains("y") &&!person.contains("h")&&!person.contains("u")&&!person.contains("ACT")&&!person.contains("SCENE") &&!person.contains("o") && !person.contains("s") &&!person.contains("i")){
            if(names.indexOf(person) == -1 )
         {
            
            names.add(person);
            numLines.add(1);
        }
        else{
            int index = names.indexOf(person);
            int value = numLines.get(index);
            numLines.set(index,value+1);
        }
        
        }
    }
    
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String s:fr.lines()){
            if(s.contains(".")){
                int index = s.indexOf(".");
                String name = s.substring(0,index);
                update(name);
            }
        }
        }
    
    public void charactersWithNumParts(int num1,int num2){
        for(int i = 0; i<names.size();i++){
            String nameOf = names.get(i);
            int lines = numLines.get(i);
            if(lines >= num1 && lines <= num2)
           System.out.println(nameOf + " has " + lines + " lines.");
        }
        
        }
    public void tester(){
        findAllCharacters();
    charactersWithNumParts(0,1000);
}
}

