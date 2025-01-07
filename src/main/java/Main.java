import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    private static final int PORT = 10100;
    public static void main(String[] args) {
        System.out.println("Iniciando programa test");

        try {
            System.out.println("========================================================");
            InetAddress dir = InetAddress.getByName("sectamermelada.ddns.net");

            // Array de tipo InetAddress con todas las direcciones IP
            //asignadas a sectamermelada.ddns.net
            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones =
                    InetAddress.getAllByName(dir.getHostName());
            for (InetAddress dirs : direcciones) System.out.println("\t\t" + dirs.toString());

            System.out.println("========================================================");
        } catch (UnknownHostException e) {
            System.out.println("Error en la conexión al servidor");
        }
        while(true){
            try(ServerSocket serverSocket = new ServerSocket(PORT)) {
                Socket client = serverSocket.accept();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                DataInputStream dis = new DataInputStream(client.getInputStream());

                dos.writeUTF("SERVER: Saludos desde la Raspberry Pi de la Secta Mermelada :D");

                String input = dis.readUTF();

                dos.writeUTF("SERVER: Mensaje recibido= " +input);

            } catch (IOException e) {
                System.out.println("SERVER Status: Stopped by Exception");
            }
            System.out.println("SERVER Status: Finished");
        }
    }
}
