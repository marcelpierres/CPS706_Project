package CPS706;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.text.*;
import java.net.*;
import java.nio.*;
public class Client {
	
		// main
	public static void main(String[] args) throws IOException, InterruptedException {
		// declare variables
		String site="", num="";
		int PortNumber=0;	
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
		System.out.println("Please Insert Your Port Address (Local server Port 40450 or 1)");
		
		//take in portnumber from user
		num = br.readLine();
		
		// convert string to integer
		PortNumber = Integer.parseInt(num);
		
		
		System.out.println("Please Insert The Web Address You Wish to Visit");
			
		//Take in website from user
		site = br.readLine();
		
		//test input
		System.out.println("You entered "+ site);
		
		// call the server
		client.server(site,PortNumber);
		
		//call the DNS Server for location
		PortNumber =client.dns();
		
		
		// Call the Webserver to download
		client.server2(site,PortNumber);
		
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
	    
	    //ability to recieve files
	    int filesze = 214748364;
	    String file = "c:/Users/marce/Desktop/Downloadedfile.mp4"; 
	    
	    int bytesRead;
	    int current = 0;
	    FileOutputStream fl = null;
	    BufferedOutputStream bl = null;
	    
	    
	    byte [] mybytearray  = new byte [filesze];
	      InputStream is = MyClient.getInputStream();
	      fl = new FileOutputStream(file);
	      bl = new BufferedOutputStream(fl);
	      
	    // create streams to read and write from server
	    //PrintStream out = new PrintStream( MyClient.getOutputStream() );
	    //PrintWriter out = new PrintWriter (MyClient.getOutputStream());
        //BufferedReader in = new BufferedReader( new InputStreamReader( MyClient.getInputStream() ) );
		
        //Outputs request from client to server in string to output
       // out.println("GET /about.html HTTP/1.1");
        //out.println("Host: " + site);
        //out.println("");
        //out.flush();	
        
       // out.println( "GET " + site + " HTTP/1.1" );
       // out.println("HI");
        
		//String outputStr;
		
		// print output of response
		//while((outputStr = in.readLine()) != null){
           // System.out.println(outputStr);
        //}
//=========================================================================            
            // Tell Server you have succefully connected
	    PrintStream PS = new PrintStream(MyClient.getOutputStream());	//ability to send to server
			PS.println("Successfully Connect to Server");
            
			InputStreamReader IR = new InputStreamReader(MyClient.getInputStream());
    		BufferedReader BR = new BufferedReader(IR);
    		BufferedReader user= new BufferedReader (new InputStreamReader(System.in));
    		String msg;
    		//==========================================
    		bytesRead = is.read(mybytearray,0,mybytearray.length);
    	      current = bytesRead;	   
    	     //===================================================
    	      
    		//while output from server to client isnt empty
    		while((msg = BR.readLine()) != null){
    			//output the message
    	           System.out.println(msg);
    	                     
    	        }
    		
    		//downloading
    		do {
    	         bytesRead =
    	            is.read(mybytearray, current, (mybytearray.length-current));
    	         if(bytesRead >= 0) current += bytesRead;
    	      } while(bytesRead > -1);
    		
    		bl.write(mybytearray, 0 , current);
    	      bl.flush();
    	      System.out.println("File " + file
    	          + " downloaded (" + current + " bytes read)");
    		 
    		//file send close connection
			bl.close();
			fl.close();
			
		// Close our streams
        IR.close();
        BR.close();
        MyClient.close();
		
	}
//=========================================================================================================
	
	// communicate with server	
	public  void server2 (String site, int PortNumber) throws IOException, FileNotFoundException, InterruptedException{
		// create the client (Prof already gave us our PortNumber which is) 40450
		Socket MyClient;
	    MyClient = new Socket(site, PortNumber);	
	    
	    //ability to recieve files
	  
	    
	      
	    // create streams to read and write from server
	    //PrintStream out = new PrintStream( MyClient.getOutputStream() );
	    //PrintWriter out = new PrintWriter (MyClient.getOutputStream());
        //BufferedReader in = new BufferedReader( new InputStreamReader( MyClient.getInputStream() ) );
		
        //Outputs request from client to server in string to output
       // out.println("GET /about.html HTTP/1.1");
        //out.println("Host: " + site);
        //out.println("");
        //out.flush();	
        
       // out.println( "GET " + site + " HTTP/1.1" );
       // out.println("HI");
        
		//String outputStr;
		
		// print output of response
		//while((outputStr = in.readLine()) != null){
           // System.out.println(outputStr);
        //}
//=========================================================================            
            // Tell Server you have succefully connected
	    PrintStream PS = new PrintStream(MyClient.getOutputStream());	//ability to send to server
			PS.println("Successfully Connect to Server");
            
			InputStreamReader IR = new InputStreamReader(MyClient.getInputStream());
    		BufferedReader BR = new BufferedReader(IR);
    		//==============================
    		 InputStream is = MyClient.getInputStream();
    		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
    		 byte[] aByte = new byte[1];
    	        int bytesRead;
    		//================================
    		
    		String msg;
    		//==========================================
    	
    		
    	     //===================================================
    	      
    		//while output from server to client isnt empty
    	/*	while((msg = BR.readLine()) != null){
    			//output the message
    	           System.out.println(msg);
    	                     
    	        }    */
    		
    		//downloading
    		
    	FileOutputStream fos = new FileOutputStream("c:/Users/marce/Desktop/newfile.mp4");
          BufferedOutputStream  bos = new BufferedOutputStream(fos);
            bytesRead = is.read(aByte, 0, aByte.length);

            do {
                    baos.write(aByte);
                    bytesRead = is.read(aByte);
            } while (bytesRead != -1);
    		
    		//file send close connection
		
    		 bos.write(baos.toByteArray());
             bos.flush();
             bos.close();
             MyClient.close();
    		
		// Close our streams
        IR.close();
        BR.close();
        MyClient.close();
		
	}
	
	

	// communicate with LDNS
	public int dns () throws IOException,  NumberFormatException {
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = "Go here to find the the SERVER!!!!!!! HURRY!!!"; // 
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 40450);
		clientSocket.send(sendPacket);
		
		// create a data packet to recieve responce from local DNS server
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String response = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + response);
		//conver to integer
		int finalans = 2;
		
		finalans=2;
		clientSocket.close();

		
		return finalans;
		
	}
	
	
	
	
	
}
