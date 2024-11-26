import java.net.*;
import java.util.Scanner;
public class FibonacciClient {
public static void main(String[] args) throws Exception {
DatagramSocket socket = new DatagramSocket();
InetAddress serverAddress = InetAddress.getByName("localhost");
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number1: ");
String number1 = scanner.nextLine();
System.out.print("Enter a number2: ");
String number2 = scanner.nextLine();
DatagramPacket request = new DatagramPacket(number1.getBytes(), number1.length(),serverAddress, 12345);
DatagramPacket request1 = new DatagramPacket(number2.getBytes(), number2.length(),serverAddress, 12345);
// DatagramPacket request = new DatagramPacket(number.getBytes(), number.length(),serverAddress, 12345);
socket.send(request);
byte[] buffer = new byte[1024];
DatagramPacket response = new DatagramPacket(buffer, buffer.length);
socket.receive(response);
String result = new String(response.getData(), 0, response.getLength());
System.out.println("Fibonacci result: " + result);
socket.close();  }}