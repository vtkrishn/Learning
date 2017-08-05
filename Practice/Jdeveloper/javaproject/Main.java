package javaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    
    static class G{
        List<G> child;
        String value;
        
        public G(String str){
            this.value = str;
            child = new ArrayList<G>();
        }
        public List<G> getChild(){
            return child;
        }
        
        public void setChild(G g){
            this.child.add(g);
        }
        
}
    
    public Main() {
        super();
    }
    
    public static void tsort(G g){
        Stack<G> s = new Stack<G>();
        s.push(g);
        while(!s.isEmpty()){
            G x = s.pop();
            for(int i =0;i<x.getChild().size();i++){
                G m = x.getChild().get(i);
                s.push(m);
                x = m;
            }
        }
    }
    
    

    
    
    public static void main(String args[]){
        G g1 = new G("A");      
        G g2 = new G("B");
        G g3 = new G("C");
        G g4 = new G("D");
        G g5 = new G("E");
        G g6 = new G("F");
        G g7 = new G("G");
        G g8 = new G("H");
        G g9 = new G("I");
        
        g1.setChild(g2);
        g2.setChild(g3);
        g2.setChild(g4);
        g2.setChild(g5);
        g2.setChild(g6);
        g2.setChild(g7);
        g3.setChild(g8);
        g8.setChild(g9);
        
        tsort(g1);
    }
}
