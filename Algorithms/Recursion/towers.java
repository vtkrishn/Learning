package javaproject;

import java.util.*;
public class Tower{

	static class Disc{
		int length;
		public Disc(int size){
			this.length = size;
		}
	}
	static class Pole{
		List<Disc> discs;
		public Pole(){
			discs = new LinkedList<Disc>();
		}
		public void addDisc(Disc disc){
			discs.add(disc);
		}

		public Disc removeDisc(int index){
		  return discs.size()>0 ? discs.remove(index) : null;
		}

		public int size(){
		  return discs.size();
		}

	}

	public static void main(String[] args){
		int n = 15;
		Disc[] discs = createDiscs(n);
		Pole source = new Pole();
		Pole destination = new Pole();
		Pole temp = new Pole();
		for(Disc d : discs){
		  source.addDisc(d);
		}
                for(Disc d : source.discs){
                  System.out.println(d.length);
                }
		System.out.println("Soruce : "+source.size());
		System.out.println("Destination : "+destination.size());
		Tower(n, source, destination, temp);
		System.out.println("Soruce : "+source.size());
		System.out.println("Destination : "+destination.size());
                for(Disc d : destination.discs){
                  System.out.println(d.length);
                }
	}

	public static void shiftDisc(Pole source, Pole destination){
                Disc d = source.removeDisc(source.size()-1);
		if(d != null)
		  destination.addDisc(d);
	}
	public static void Tower(int n, Pole source, Pole destination, Pole temp){
		if(n == 0)
			return;
                Tower(n-1,source, temp, destination);
                shiftDisc(source,destination);
                Tower(n-1,temp, destination ,source);
	}

	public static Disc[] createDiscs(int size){
		Disc[] discs = new Disc[size];
		for(int i=0;i<size;i++){
			discs[i] = new Disc(i+1);
		}
		return discs;
	}
}
