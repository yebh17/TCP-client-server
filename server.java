
import java.io.*;

import java.net.*;




public class Server
{
    public static void main(String[] args)
    {

        String colonDelimited[] = args[0].split(":");
        int portNumber = Integer.parseInt(colonDelimited[1]);

        try{

            InetAddress addr = InetAddress.getByName(colonDelimited[0]);

            ServerSocket serverSocket = new ServerSocket();

            SocketAddress endPoint=new InetSocketAddress(addr, portNumber);  

            serverSocket.bind(endPoint);  

            System.out.println("Local Socket Address: "+serverSocket.getLocalSocketAddress());  

            Socket clientSocket = serverSocket.accept();
            
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
                    
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

        }
        catch(Exception e)
        {
            System.out.print(e);
        }
            


    }
}