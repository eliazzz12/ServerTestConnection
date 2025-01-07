import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int PORT = 10100;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket client = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());

            dos.writeUTF("Saludos desde la Raspberry Pi de la Secta Mermelada :D");

            String input = dis.readUTF();

            dos.writeUTF("Mensaje recibido: " +input);

        } catch (IOException e) {
            System.out.println("SERVER Status: Stopped");
        }
    }
}
