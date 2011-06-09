package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String host = "localhost";// or IP address
        try
        {
	  socket = new Socket(host, 4444);
	  out = new PrintWriter(socket.getOutputStream(), true);
	  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	  // client code…
	  System.out.println("client started");
	  MyProtocol mp = new MyProtocol(in, out);
	  mp.run();
        }
        catch (UnknownHostException e)
        {
	  System.err.println("Do not know host: " + host);
	  System.exit(-1);
        }
        catch (IOException e)
        {
	  System.err.println("Cannot get IO for connection to " + host);
	  System.exit(-1);
        }
        finally
        {
	  // close connection (Order important)
	  if (out != null) out.close();
	  if (in != null) in.close();
	  if (socket != null) socket.close();
        }
    }
}
