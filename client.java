
import java.io.*;

import java.net.*;

public class Client
{
    public static void main(String[] args) throws Exception
    {
            String colonDelimited[] = args[0].split(":");

            String hostName = colonDelimited[0];

            int portNumber = Integer.parseInt(colonDelimited[1]);

            Socket kkSocket = new Socket(hostName, portNumber);

    }
}