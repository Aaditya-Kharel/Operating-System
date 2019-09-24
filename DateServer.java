
/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.21
 *
 * @author Silberschatz, Gagne, and Galvin. 
 * Operating System Concepts  - Ninth Edition
 * Copyright John Wiley & Sons - 2013.
 */
 
import java.net.*;
import java.io.*;

class Connection implements Runnable
{
    private Socket worker;
    public Connection(Socket w)
    {
	worker=w;
    }
 
    public void run ()
    {
	try{
	PrintWriter pout = new PrintWriter(this.worker.getOutputStream(),true);

	//added
	long threadId=Thread.currentThread().getId();
	pout.println("Date is being served from the Thread number " + threadId);
	//
	pout.println(new java.util.Date().toString());
	this.worker.close();
	}
	catch (IOException ioe) {
	    System.err.println(ioe);
       	}
	
    }
}

public class DateServer
{
    
    
	public static void main(String[] args)  {
		try {
		    ServerSocket sock = new ServerSocket(6013);

			// now listen for connections
			while (true) {
			    //Socket client = sock.accept();
				// we have a connection
				
			    Thread worker=new Thread(new Connection(sock.accept()));
			    worker.start();

			  
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
    
}
