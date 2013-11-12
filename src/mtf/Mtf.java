/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtf;

/**
 *
 * @author Felipe
 */
public class Mtf {
    
    private String word;
    private char[] alphabet;
    
    public Mtf(String word){
        this.word=word;
        this.alphabet = new char[2];
        this.alphabet[0]=0;
        this.alphabet[1]=1;
    }
    
    public String codage(){
        StringBuilder codedString = new StringBuilder();
        for(char c : word.toCharArray()){
            switch (c){
                case '0':
                    if(this.alphabet[0]=='0'){
                        codedString.append("0");
                    }else{
                        codedString.append("1");
                        this.alphabet[0]='0';
                        this.alphabet[1]='1';
                    }
                    break;
                case '1':
                    if(this.alphabet[0]=='1'){
                        codedString.append("0");
                    }else{
                        codedString.append("1");
                        this.alphabet[0]='1';
                        this.alphabet[1]='0';
                    }
                    break;
            }
        }
        
        return codedString.toString();
    }
    
    public void decodage(){
        
    }
}
