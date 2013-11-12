
import lz.LZ;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azathoth
 */
public class Main {

    public static void main(String[] args) {
////////        LZ lz = new LZ();
////////        lz.code("001");
////////        //lz.code("aaa");
////////        System.out.println("Dictionnaire");
////////        System.out.println(lz.dict);
////////        System.out.println("Code");
////////        System.out.println(lz.code);
////////        System.out.println(lz.getCode());
        LZ lz2 = new LZ();
        
        lz2.decode("a0a1b0b2b1E1");
        System.out.println("Dictionnaire");
        System.out.println(lz2.dictDecod);
        System.out.println("Decode");
        System.out.println(lz2.decode);
   

//        String s ="happilyeverafter";
//        String t="aa";
//        System.out.println(s);
//        System.out.println(s.charAt(2));
//        System.out.println(s.substring(1,2));
    }
}
