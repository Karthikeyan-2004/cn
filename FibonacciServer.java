import java.net.*;
public class FibonacciServer {
public static void main(String[] args) throws Exception {
DatagramSocket socket = new DatagramSocket(12345);
byte[] buffer = new byte[1024];
while (true) {
DatagramPacket request = new DatagramPacket(buffer, buffer.length);
socket.receive(request);
String numStr = new String(request.getData(), 0, request.getLength());
int n = Integer.parseInt(numStr.trim());
String num2=new String(request.getData(), 0, request.getLength());
int n1 = Integer.parseInt(num2.trim());
String response="";
int res=n*n1;
response=Integer.toString(res);
DatagramPacket reply = new DatagramPacket(response.getBytes(), response.length(),
request.getAddress(), request.getPort());
socket.send(reply); } } }

