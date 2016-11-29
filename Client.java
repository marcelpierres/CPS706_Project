package CPS706;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.text.*;
import java.net.*;
public class Client {
	
		// main
	public static void main(String[] args) throws IOException, InterruptedException {
		// declare variables
		String site="";
		int PortNumber=40450;
		// ability to take in input from the user
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		
		// Welcome user
		System.out.println("Welcome to the Dummy Content Distribution Service \n ");
		// delay
		Thread.sleep(2000);
		System.out.println("Now Logging Into your Computer \n ");
		// delay
		Thread.sleep(2000);
		System.out.println("Opening Browser");
	
		//pretend loading screen to open browser
		for (int i=0; i<3; i++){	
			// delay
		Thread.sleep(1000);
		System.out.print(". ");
	}
		// create the client (Prof already gave us our PortNumber which is) 40450
		Socket MyClient;
	    MyClient = new Socket("Machine name", PortNumber);
	    
		// display header of browser
		System.out.println("\n");
		System.out.println("============================================");
		System.out.println("           BROWSER Version 706");
		System.out.println("============================================ \n");
		System.out.println("Please Insert The Web Address You Wish to Visit");
	
		//Take in website from user
		site = br.readLine();
		
		//test input
		System.out.println("You entered "+ site);
	
		
		
	}

	
	
	
	
	
}
