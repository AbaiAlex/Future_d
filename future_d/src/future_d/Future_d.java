/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package future_d;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Csomopont {
    private String name;            
    private int number;             
    private List<String> links;     
    
    
    //constructors
    public Csomopont(){
        this.name = "null";
        this.number = 0;
        this.links = new ArrayList<>();
    }
    public Csomopont(String name, int number,List<String> links){
        this.name = name;
        this.number = number;
        this.links = links;
    }
    public Csomopont(String name){
        this.name = name.replaceAll("/home/abaialex/NetBeansProjects/Future_d/","");
        this.number = 0;
        this.links = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    public int getNumber(){
        return this.number;
    }
    public List getLinks(){
        return this.links;
    }
    public String getLink(int i){
        return this.links.get(i);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public void setLinks(List<String> links){
        this.links = links;
    }
    public void setLink(String link){
        this.links.add(link);
    }
}
/**
 *
 * @author abaialex
 */
public final class Future_d {
  private static List<Csomopont> graph;        
private static int iterations = 300;
public Future_d(){
        Future_d.graph = new ArrayList<>();
        readFiles("City");
       
}
 public int osszes(){    
        int sum = 0;
        sum = graph.stream().map((n) -> n.getNumber()).reduce(sum, Integer::sum);
        return sum;
}
  public void readFiles(String stdir){
        File[] Files;
      Files = new File(stdir).listFiles();
        String name;
        int number;
        List<String> links = new ArrayList<>();
        for(File file: Files){
          if(file.isFile()){
              try{
                  java.util.Scanner in = new java.util.Scanner(new java.io.FileReader(file.getAbsoluteFile()));
                 Csomopont pont = new Csomopont(file.getPath());
                  pont.setNumber(in.nextInt());
                  
                  while(in.hasNext()){
                      pont.setLink(in.next());
                  }
                  graph.add(pont);
              }catch(IOException ex){
              }
          } else {
          }
          if(file.isDirectory()){
            readFiles(file.getAbsolutePath());
          }
        }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Future_d test = new Future_d();
        System.out.println("Debrecen lakossága: " + test.osszes());  
        
}
    
    }
    

