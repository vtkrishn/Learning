package com.learning.scratchpad;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public Main1() {
        super();
    }
    
    public static void main(String[] args){
        Points p1 = new Points(1,2);
        Points p2 = new Points(2,2);
        Points p3 = new Points(2,0);
        Points p4 = new Points(4,2);
        List<Points> pp = new ArrayList<Points>();
        pp.add(p1);
        pp.add(p2);
        pp.add(p3);
        pp.add(p4);
        erectFence(pp);
        
    }
    
    static class Points{
            int x;
            int y;
            
            public Points (int x, int y){
                    this.x = x;
                    this.y = y;
            }
    }

    static public List<Points> erectFence(List<Points> points){
            //find the index of the leftmost point 
			int l = 0;
			Points start = points.get(0);
			for(int i=0;i<points.size();i++){
				if(points.get(i).x < start.x)
					l = i;
			}
			
			List<Points> result = new ArrayList<Points>();
			int p = l, q;
			do{
				result.add(points.get(p));
				q = (p + 1) % points.size();
				for(int i=0;i<points.size();i++){
					if(getOrientation(points.get(p),points.get(i),points.get(q)) > 0)
						q = i;
				}
				p = q;
				
			} while(p != l);
			
                        for(Points pk : result)
                            System.out.println(pk.x + " : " + pk.y);
            return result;
    }

    static public int getOrientation(Points p1, Points p2, Points p3){
            return (p2.x - p1.x) * (p3.y - p2.y) - (p2.y - p1.y)*(p3.x-p2.x);
    }
}
