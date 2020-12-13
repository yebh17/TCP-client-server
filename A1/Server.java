import java.io.*;

import java.net.*;

import java.util.*;

public class Server
{
    static String[] supportedVersions = {"1.0","1.1","1.2"};

    public static void main(String[] args) throws Exception
    {

        String colonDelimited[] = args[0].split(":");
        int port = Integer.parseInt(colonDelimited[1]);

        InetAddress addr = InetAddress.getByName(colonDelimited[0]);

        ServerSocket serverSocket = new ServerSocket();

        SocketAddress endPoint=new InetSocketAddress(addr, port);  
        
        serverSocket.bind(endPoint);  

        Process pr = new ProcessBuilder("./protocol", Integer.toString(port) ).start();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        pr. waitFor();
        String message = buf.readLine();
        String request;

        while(true)
        {
                  //creating socket and waiting for client connection
                  System.out.println("Waiting for the client request");

                 Socket clientSocket = serverSocket.accept();

                        PrintWriter out =
                            new PrintWriter(clientSocket.getOutputStream(), true);
                        
                        BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

                        if(message!=null)
                        {
                            for(String version:supportedVersions)
                            {
                                out.println("TEXT "+ message + " "+ version);
                            }
                
                            out.println("");
                            if((request = in.readLine())!=null && request.equalsIgnoreCase("OK"))
                            {
                                
                                    String command = Rand.randOperation();
                                    if(command.startsWith("f"))
                                    {
                                        double value1 = Rand.randDecimalValue();
                                        double value2 = Rand.randDecimalValue();
                                        Formatter serverFormat = new Formatter();
                                        out.println(command+" "+ value1 +" "+ value2);
                                        if((request = in.readLine())!=null )
                                        {
                                            double result = Calculator.calculate(command,value1,value2);
                                            serverFormat.format("%8.8g", result); 
                                            System.out.println("Server_result " + serverFormat);
                                            System.out.println("");
                                            if(request.equals( serverFormat.toString()))
                                            {
                                                
                                                out.println("OK");
                                            }
                                            else{

                                                out.println("ERROR");
                                            }
                                            
                                        }
                                        
                                    }
                                    else 
                                    {
                                        int value1 = Rand.randIntegerValue();
                                        int value2 = Rand.randIntegerValue();
                                        out.println(command+" "+ value1 +" "+ value2);
                                        if((request = in.readLine())!=null)
                                        {
                                            int result = Calculator.calculate(command,value1,value2);
                                            System.out.println("Server_result : " + result);
                                            System.out.println("");
                                            if(request.equalsIgnoreCase(Integer.toString(result)))
                                            {
                                                out.println("OK");
                                            }
                                            else
                                            {
                                                out.println("ERROR");

                                        }
                                            
                                    }
                                }                           
                            }
                        }
            clientSocket.close();            
        }
    }
}
