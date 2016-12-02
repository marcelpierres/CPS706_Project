package CPS706;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.text.*;
import java.net.*;

// to make threading in here work we have to run it in parallel.
// in other words we need to implement interfaces
public class HER  {
	// need to implement TCP protocol

	//class variables
	private int PortNumber =40450;
	private ServerSocket serversocket;
	private boolean work=false;
	//main
	public static void main (String [] args) throws IOException, InterruptedException{
	// create variables	
		HER server = new HER();
		
	// run the server		
		server.serverr();
		Thread.sleep(120000);
	
		//stop server
		server.stopserver();
		
	}

	//starting the server
	public void serverr() throws IOException{
		 serversocket = new ServerSocket(PortNumber);
		this.start();
		//State what port the server started on
		System.out.println("Web server www.hiscinema.com started on port: "+ PortNumber);
		
		
	}
	
	//stopping the server
	public void stopserver(){
		//set server working as false to stop
		work = false;
		interrupt();
	}
	
	@Override
	public void run(){
		//set server working as true to run
		work = true;
		// display that server is waiting for a client to connect
		while (work==true){
		try {
		System.out.println("Waiting for Client to Connect...");
		
		// recieve connection
		Socket socket = serversocket.accept();	
		System.out.println("Just connected to " + socket.getRemoteSocketAddress());
		// Send the request to a thread to proccess
		multiRun multirequest = new multiRun(socket);
		multirequest.start();
		}
		// catch Input/Output exception
		catch(IOException e){
			e.printStackTrace();
		}
				
		}
		
	}
	
}

// thread that handles multiple request
class multiRun extends Thread{
	
	// set the value of the socket
	private Socket socket;
    multiRun( Socket socket )
    {
        this.socket = socket;
    }
	
    @Override
	public void run(){
    	try {
    		// get input and output to client
    	PrintWriter out = new PrintWriter (socket.getOutputStream());
        BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream()));
        
        //welcome user
        out.println("Welcome to Server to www.hiscinema.com ");
        out.flush();
        
        
        String line = in.readLine();
        while( line != null && line.length() > 0 )
        {
            out.println( "Echo: " + line );
            out.flush();
            line = in.readLine();
        }
        
        

    	// Close our connection
        in.close();
        out.close();
        socket.close();
        System.out.println( "www.hiscinema.com Closed Connection " );	
    	}
    	// catch Input/output exception
    	catch (IOException e){
    		e.printStackTrace();
    	}
    	
    	

        
	}
	
	
	

	
}
