package com.vtkrishn.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        //Queue<Employee> s = new LinkedList<>();
        Stack<Employee> s = new Stack<>();
        //s.offer(map.get(id));
        s.push(map.get(id));
        int count = 0;
        
        while(!s.isEmpty()){
            Employee e = s.pop();
            count += e.importance;
            for(Integer i : e.subordinates){
                  s.push(map.get(i));
            }
        }
        
        return count;
    }
    
}