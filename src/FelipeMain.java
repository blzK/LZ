
import mtf.Mtf;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */
public class FelipeMain {
    public static void main(String args[]){
        Mtf mtf = new Mtf("1000010100");
        
        if(args[0].equals("-c")){
            System.out.println(mtf.codage());
        }
        
    }
    
}
