package javaproject.string;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateSentence {
    public FindDuplicateSentence() {
        super();
    }

    public static void main(String[] args){
        FileInputStream fs;
        try {

            File f = new File("D:\\1.txt");
            fs = new FileInputStream(f);
            BufferedInputStream bfs = new BufferedInputStream(fs);
            StringBuilder stb = new StringBuilder();
            Map m = new HashMap();
            while(bfs.available() > 0){
                char ch = (char)bfs.read();
                if(ch != '.')
                    stb.append(ch);
                else{
                    String val = stb.toString().trim();
                    long hash = val.hashCode();
                   if(!m.containsKey(hash))
                        m.put(hash, val);
                   else
                      System.out.println(val);
                   stb = new StringBuilder();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
