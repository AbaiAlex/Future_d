/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package future_d;

/**
 *
 * @author abaialex
 */
import java.util.ArrayList;
import java.util.List;

public class Csomopont {

   
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
    public void setLink(String link){
        this.links.add(link);
    }
    public void setLinks(List<String> links){
        this.links = links;
    }
    

   
}