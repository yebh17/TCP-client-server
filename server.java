
import java.io.*;

import java.net.*;




public class Server
{
    public static void main(String[] args) throws Exception
    {

        String colonDelimited[] = args[0].split(":");
        int port = Integer.parseInt(colonDelimited[1]);



        Process pr = new ProcessBuilder("./protocol.sh",Integer.toString(port)).start();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        pr.waitFor();
        String message = "";

 





        InetAddress addr = InetAddress.getByName(colonDelimited[0]);

        ServerSocket serverSocket = new ServerSocket();

        SocketAddress endPoint=new InetSocketAddress(addr, port);  

        serverSocket.bind(endPoint);  

        while(true)
        {
            System.out.println("Waiting for the client request");

            //creating socket and waiting for client connection
            Socket clientSocket = serverSocket.accept();
            
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
                    
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));


            while ((message=buf.readLine())!=null) {
                
                out.println(message);
        }


        }
            


    }
}