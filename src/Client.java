import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Created by paudie on 08/11/2017.
 */

public class Client {

    private final String FILENAME = null;
    Connect c = new Connect();
    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void startClient() throws UncheckedIOException, IOException
    {
        //create socket connection
        socket = new Socket(c.getHOSTNAME(), c.getPORT());

        //create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        //prompt user name to server
        String username = JOptionPane.showInputDialog(null, "Enter User Name:");

        //send user name to server
        output.println(username);

        //prompt for password
        String password = JOptionPane.showInputDialog(null, "Enter password:");

        //send password
        output.println(password);
        output.flush();

        //create Buffered reader for reading response from server
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //read response from server
        String response = read.readLine();
        System.out.println("This is the response: " + response);

        JOptionPane.showMessageDialog(null, response);
    }

    public void fileInfo(){

    }

    public static void main(String [] args)
    {
        Client client = new Client();
        try{
            client.startClient();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
