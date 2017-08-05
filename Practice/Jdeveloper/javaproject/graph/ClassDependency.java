package javaproject.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClassDependency {
    static Map dep = new HashMap();
    static Set loadOrder;
    public ClassDependency() {
        super();
    }
    
    public static void main(String[] args){
        dep.put("A","BD");
        dep.put("B","CDE");
        dep.put("C","E");
        dep.put("D","FE");
        dep.put("E","");
        dep.put("F","C");
        loadOrder = new HashSet(); 
        //process the importName
        Deque stack = new ArrayDeque();
        String aDep = (String)dep.get("A");
        stack.push("A");
        processFile(aDep,stack);
    }
    
    public static String processFile(String file,Deque stack){
        if(file != null && file.equals("")){
            String f = (String)stack.pop();
            if(!loadOrder.contains(f)){
                loadOrder.add(f);
                System.out.println("Loaded :: "+f);
            }
            return null;
        } 
        
        String[] dependancies = file.split("");
        for(String depend : dependancies){
            stack.push(depend);
            while(!stack.isEmpty()){
                String fileDep = (String)dep.get(depend);
                processFile(fileDep,stack);     
            }
        }
        return null;
    }
}
