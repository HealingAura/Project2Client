package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MyProtocol
{
    BufferedReader in;
    PrintWriter out;

    public MyProtocol(BufferedReader in, PrintWriter out)
    {
        this.in = in;
        this.out = out;
    }

    public void run()
    {
        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        String request = null, response = null;
        try
        {
	  while (response == null || !response.startsWith("bye"))
	  {
	      System.out.print(">");
	      request = sysin.readLine();
	      out.println(request);
	      response = in.readLine();
	      System.out.println(response);
	  }
        }
        catch (IOException e)
        {
        }
    }
}
