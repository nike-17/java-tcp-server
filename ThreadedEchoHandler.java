import java.net.*;
import java.util.*;
import java.io.*;

class ThreadedEchoHandler implements Runnable{
	
	public ThreadedEchoHandler(Socket i){
		incoming = i;
	}
	
	public void run(){
		try{
			try{
        		InputStream inStream = incoming.getInputStream();
     			OutputStream outStream = incoming.getOutputStream();
				Scanner scan = new Scanner(inStream);
        		PrintWriter out = new PrintWriter(outStream, true);
        		out.println("Enter BYE to exit");
				boolean done = false;
			
        		while(!done && scan.hasNextLine()){
            		String line = scan.nextLine();
					System.out.println("Recieved from " + incoming.getInetAddress().getHostAddress() + ": "  + line);
            		out.println(line);
            		if(line.trim().equals("BYE"))
                		done = true;
        		}
    		}
    		finally{
    			incoming.close();
    		}
       }
			catch(IOException e){
    			e.printStackTrace();
			}  
	}
	
	private Socket incoming;	
}