import java.net.*;
import java.io.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket s = new ServerSocket(6666);
			while(true){
            	Socket incoming = s.accept();
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
			}
       }
	   catch(IOException e){
	        e.printStackTrace();
	   }
    }       
 }

    


