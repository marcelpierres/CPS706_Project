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
		Client client = new Client();
		
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
		
		// call the server
		client.server(site,80);
		
		
	/*	
		// create the client (Prof already gave us our PortNumber which is) 40450
		Socket MyClient;
	    MyClient = new Socket(site, PortNumber);
			    
		*/
		
	
		
		
	}

	// communicate with server	
	public  void server (String site, int PortNumber) throws IOException{
		// create the client (Prof already gave us our PortNumber which is) 40450
		Socket MyClient;
	    MyClient = new Socket(site, PortNumber);	
	    
	    // create streams to read and write from server
	    //PrintStream out = new PrintStream( MyClient.getOutputStream() );
	    PrintWriter out = new PrintWriter (MyClient.getOutputStream());
        BufferedReader in = new BufferedReader( new InputStreamReader( MyClient.getInputStream() ) );
		
        //Outputs request from client to server in string to output
        out.println("GET /about.html HTTP/1.1");
        out.println("Host: " + site);
        out.println("");
        out.flush();	    
		String outputStr;
		
		// print output of response
		while((outputStr = in.readLine()) != null){
            System.out.println(outputStr);
        }
		
		// Close our streams
        in.close();
        out.close();
        MyClient.close();
		
	}
	

	// communicate with DNS
	public void dns (){
		
		
	}
	
	
	
	
	
}
