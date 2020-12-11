
import java.io.*;

import java.net.*;




public class Server
{
    static int i =1;
    public static void main(String[] args) throws Exception
    {

        String colonDelimited[] = args[0].split(":");
        int port = Integer.parseInt(colonDelimited[1]);

        InetAddress addr = InetAddress.getByName(colonDelimited[0]);

        ServerSocket serverSocket = new ServerSocket();

        SocketAddress endPoint=new InetSocketAddress(addr, port);  
        
        


        serverSocket.bind(endPoint);  

        Process pr = new ProcessBuilder("./protocol.sh", Integer.toString(port) ).start();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        pr. waitFor();
        String message = buf.readLine();
        String request;

        while(true)
        {
                  //creating socket and waiting for client connection
                  System.out.println("Waiting for the client request");

                 Socket clientSocket = serverSocket.accept();

                 System.out.println("Handling Client "+ i);
                i++;

                        PrintWriter out =
                            new PrintWriter(clientSocket.getOutputStream(), true);
                        
                        BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

                        if(message!=null)
                        {
                            out.println("TEXT "+message+ " 1.0");
                            if((request = in.readLine())!=null && request.equalsIgnoreCase("ok"))
                            {
                                
                                    System.out.println("OK");
                                    String command = Rand.randOperation();
                                    if(command.startsWith("f"))
                                    {
                                        double value1 = Rand.randDecimalValue();
                                        double value2 = Rand.randDecimalValue();
                                        out.println(command+" "+ value1 +" "+ value2);
                                        if((request = in.readLine())!=null )
                                        {
                                            if(request.equalsIgnoreCase( Double.toString(Calculator.calculate(command,value1,value2))))
                                            {
                                                out.println("ok");
                                            }
                                            else{

                                                out.println("error");
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
                                            if(request.equalsIgnoreCase(Integer.toString(Calculator.calculate(command,value1,value2))))
                                            {
                                                out.println("ok");
                                            }
                                            else
                                            {
                                                out.println("error");

                                            }
                                            
                                        }


                                    }

                                
                                
                            }

                        }  

            clientSocket.close();
            
            
        }
            


    }
}