/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azathoth
 */
public class LZ {

    public Map<String, Integer> dict = new LinkedHashMap<>();
    public Map<Integer, String> dictDecod = new LinkedHashMap<>();
    public StringBuilder code = new StringBuilder("");
    private int alpha = 0;
    public StringBuilder decode = new StringBuilder("");
    public StringBuilder data = new StringBuilder("");

    public LZ() {

    }

    public LZ(String[] args) {

        File file = new File(args[1]);

        FileInputStream in;
        try {
            in = new FileInputStream(file);
            BufferedInputStream in2 = new BufferedInputStream(in);
            DataInputStream in3 = new DataInputStream(in2);
            while (in3.available() > 0) {
                data.append(in3.readLine());
                data.append("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LZ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LZ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void code() {
        code(data.toString());
    }

    public void decode() {
        decode(data.toString());
    }

    public void code(String s) {
        int i = 0;
        int j = 1;

        while (i < s.length() && j <= s.length()) {

            if (dict.containsKey(s.substring(i, j))) {
                j++;
                if (j - 1 == s.length()) {

                    code.append("E");
                    code.append(dico(s.substring(i, j - 1)));
                    break;
                }
                continue;

            } else {
//                System.out.println("we examined " + s.substring(i, j));
//                System.out.println("we put in dict " + s.substring(i, j) + (alpha + 1));
//                System.out.println("we put in code " + s.charAt(j - 1) + dico(s.substring(i, j - 1)));
//                System.out.println("**********************");
                if (dico(s.substring(i, j - 1)) == null) {

                    dict.put(s.substring(i, j), alpha + 1);
                    code.append(s.charAt(j - 1));
                    code.append(0);

                    alpha++;
                } else {

                    dict.put(s.substring(i, j), alpha + 1);
                    code.append(s.charAt(j - 1));
                    code.append(dico(s.substring(i, j - 1)));
                    alpha++;
                }
            }
            i = j;
            j++;
        }

    }

    public String getCode() {
//        StringBuilder sb = new StringBuilder("");
//        for (Entry<Integer, Character> entry : code.entrySet()) {
//            sb.append(entry.getKey());
//            sb.append(entry.getValue());
//        }

        return code.toString();
    }

////    public String getDict() {
////        StringBuilder sb = new StringBuilder("");
////        for (Entry<String, Integer> entry : dict.entrySet()) {
////            sb.append(entry.getKey());
////            sb.append(entry.getValue());
////        }
////
////        return sb.toString();
////    }
    public void decode(String s) {
        int i = 0;
        int beta = 1;

        while (i < s.length()) {
            System.out.println("we examine " + s.substring(i, i + 2));
            if (dictDecod.containsKey(Character.getNumericValue(s.charAt(i + 1)))) {

                if (String.valueOf(s.charAt(i)).equals("E")) {

                    decode.append(dico(Character.getNumericValue(s.charAt(i + 1))));
                    dictDecod.put(-1, dico(Character.getNumericValue(s.charAt(i + 1))));
//                    System.out.println("3we put in dict " + beta + String.valueOf(s.charAt(i)));
                    break;
                }
                dictDecod.put(beta, dico(Character.getNumericValue(s.charAt(i + 1))) + String.valueOf(s.charAt(i)));
                decode.append(dico(Character.getNumericValue(s.charAt(i + 1)))).append(String.valueOf(s.charAt(i)));
//                System.out.println("1we put in dict " + beta + dico(Character.getNumericValue(s.charAt(i + 1))) + String.valueOf(s.charAt(i)));
            } else {
                //dictDecod.put(Character.getNumericValue(s.charAt(i + 1)+1),        String.valueOf(s.charAt(i)));
                dictDecod.put(beta, String.valueOf(s.charAt(i)));
                decode.append(String.valueOf(s.charAt(i)));
//                System.out.println("2we put in dict " + beta + String.valueOf(s.charAt(i)));
            }
            beta++;
            //     System.out.println("***************");
            i += 2;
        }

    }

    private Integer dico(String search) {
        return dict.get(search);
    }

    private String dico(Integer search) {
        return dictDecod.get(search);
    }

}
