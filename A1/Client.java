import java.io.*;

import java.net.*;

public class Client
{
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
            protocol = "TEXT "+protocol+" 1.0";

            String input;
            boolean completed = false;
            while((completed!=true && (input = in.readLine())!=null )) {

                if(input.equalsIgnoreCase(protocol))
                {
                    Thread.sleep(10000);
                    System.out.println(input);
                    out.println("OK");
                    input = in.readLine();
                    if(input!=null)
                    {
                        System.out.println(input);
                        String[] operations = input.split(" ");
                        if (operations[0].startsWith("f"))
                        {
                            double result = Calculator.calculate(operations[0],Double.parseDouble(operations[1]),Double.parseDouble(operations[2]));
                            System.out.println(result);
                            out.println(result);
                        }
                        else
                        {
                            int result = Calculator.calculate(operations[0],Integer.parseInt(operations[1]),Integer.parseInt(operations[2]));
                            System.out.println(result);
                            out.println(result);



                        }
                        completed = true;
                    
                    }
                }
                else
                {
                    System.out.print("Client Doesnot support the protocol");
                    break;
                }
            }
            clientSocket.close();
    }
}



