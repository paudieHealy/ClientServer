import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by paudie on 08/11/2017.
 */
public class Server {
    private int currentTot;
    ServerSocket serverSocket;
    Socket client;
    int bytesRead;
    Connect c = new Connect();
    BufferedReader input;
    PrintWriter output;

    public void start() throws IOException{
        System.out.println("Connection Starting on port:" + c.getPORT());
        // make connection to client on port specified
        serverSocket = new ServerSocket(c.getPORT());

        //accept connection from client
        client = serverSocket.accept();

        System.out.println("Waiting for connection from client");

        try{
            logInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logInfo() throws Exception{
        //open buffered reader for reading data from client
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String username = input.readLine();
        System.out.println("SERVER SIDE" + username);
        String password = input.readLine();
        System.out.println("SERVER SIDE" + password);

        //output printwriter for writing data to client
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        if(username.equals(c.getUSERNAME()) && password.equals(c.getPASSWORD())){
            output.println("Welcome, " + password);
        }else{
            output.println("Login Failed");
        }
        output.flush();
        output.close();
    }

    public static void main(String[] args)
    {
        Server server = new Server();
        try{
            server.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
