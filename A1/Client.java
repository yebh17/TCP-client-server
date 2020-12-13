import java.io.*;

import java.net.*;

import java.util.*;

public class Client
{
    static String version = "1.0";
    public static void main(String[] args) throws Exception
    {
            String colonDelimited[] = args[0].split(":");

            String hostName = colonDelimited[0];

            int port = Integer.parseInt(colonDelimited[1]);

            Socket clientSocket = new Socket(hostName, port);

            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));

            Process pr = new ProcessBuilder("./protocol", Integer.toString(port) ).start();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            pr. waitFor();
            String protocol = buf.readLine();
            protocol = "TEXT "+protocol +" " + version;

            String input;
            boolean completed = false;
            while(completed!=true && (input = in.readLine())!=null ) {

                ArrayList<String> serverVersions = new ArrayList<String>();
                while(!input.equals(""))
                {
                    serverVersions.add(input);
                    input = in.readLine();

                }
                if(serverVersions.contains(protocol))
                {
                    System.out.println(protocol);
                    out.println("OK");
                    input = in.readLine();
                    if(input!=null)
                    {
                        String[] operations = input.split(" ");
                        if (operations[0].startsWith("f"))
                        {

                            double result = Calculator.calculate(operations[0],Double.parseDouble(operations[1]),Double.parseDouble(operations[2]));
                            Thread.sleep(500);

                            Formatter formatter = new Formatter();
                            formatter.format("%8.8g", result); 
                            System.out.println("Client_Result : " + formatter);
                            out.println(formatter);
                            input = in.readLine();
                            Thread.sleep(500);
                            if(input!=null)
                            {
                                                

                                System.out.println(input);
                            }
                        }
                        else
                        {
                            int result = Calculator.calculate(operations[0],Integer.parseInt(operations[1]),Integer.parseInt(operations[2]));
                            Thread.sleep(500);

                            System.out.println("Client_Result : " + result);
                            out.println(result);
                            input = in.readLine();
                            Thread.sleep(500);

                            if(input!=null)
                            {
                                System.out.println(input);
                            }


                        }
                        completed = true;
                    
                    }
                }
                else
                {
                    System.out.println("Error: Server Supported Protocols " + serverVersions);
                    break;
                }
            }
            clientSocket.close();
    }
}


