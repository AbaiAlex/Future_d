
package future_d;

import Jama.Matrix;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author abaialex
 */
public final class Future_d {
  private static List<Csomopont> graph;    
  private static int iterations = 200; 

public Future_d(){
        Future_d.graph = new ArrayList<>();
        readFiles("City");
       Matrix myVec = createVector();
        Matrix myMatrix = createMatrix();
        iterations(myVec,myMatrix);
     

}
 public int osszes(){    
        int sum = 0;
        for(int i=0; i < graph.size(); i++){
            sum += graph.get(i).getNumber();
        }
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
              }catch(IOException ioe){
                  ioe.printStackTrace();}
          } else {
          }
          if(file.isDirectory()){
            readFiles(file.getAbsolutePath());
          }
        }
}   
  private Matrix createVector() {
       int size = graph.size();
        double sum = osszes();
        double[][] array = new double[1][size];
        for (int i = 0; i < size; i++) {
            array[0][i] = graph.get(i).getNumber()/sum;
        }
        Matrix myVec = new Matrix(array);
        return myVec;
   
    }

    private Matrix createMatrix() {
int size = graph.size();
        double[][] array = new double[size][size];
        for (int i = 0; i < size; i++){
            double linksCount = graph.get(i).getLinks().size();
            for (int j = 0; j < linksCount; j++){
                String actual = graph.get(i).getLink(j) + "City/Debrecen";
                for (int k = 0; k < size; k++) {
                    if (actual.equals(graph.get(k).getName())) {
                        array[i][k] = 1.0/linksCount;   
                    }
                }
            }
        }
        Matrix myMatrix = new Matrix(array);
        return myMatrix;        

    }
    
    public void iterations(Matrix myVec, Matrix myMatrix){
        for (int i = 0; i <= iterations; i++){
            System.out.println(i + ". iteration");
            myVec = myVec.times(myMatrix);
            myVec.print(5,8);
            //System.out.printf("%.8f ",myVec.trace());
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Future_d lakossag = new Future_d();
        System.out.println("Debrecen lakossága: " + lakossag.osszes());  
        
}

}

