package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class testLinux {
	
	public static void main(String[] args) {
		
		String s;
        Process p;
        try {
        	   System.out.println("test");
        	   Process proc = Runtime.getRuntime().exec("./api");                        
        	   proc.waitFor();
        	   System.out.println("salut");
        } catch (Exception e) {}
    }
	
	
	
	public void indexer()
	{
		
	}
	

}
