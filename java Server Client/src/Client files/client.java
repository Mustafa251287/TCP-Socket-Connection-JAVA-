/*client
 *
 *v1.0
 *
 *10-08-2021
 *
 *This is CopyRighted By Me(Mustafa) 
 */ 
import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.Socket;
import java.util.*;

/**
 *This file is copyrighted by me
 *Author of this File is Me(Mustafa)
 *Do not use in Wrong Way
 *I will not be Responsible for any damage happen with my codes
 */



public class client extends Thread {

String msgout="";
public Socket s;
public DataOutputStream dout;
public DataInputStream din;
public BufferedReader br;

public client(int port,String ip){
try{
  s=new Socket(ip,port); 
System.out.println("Socket created on port "+port);
  }catch(Exception e){
    System.out.println("Error caugth "+e);
  }
}
public void req(){
  try{
    dout=new DataOutputStream(s.getOutputStream());
    din=new DataInputStream(s.getInputStream());
    br=new BufferedReader(new InputStreamReader(System.in));
    
  }catch(Exception e){
    System.out.println("Error "+e);
  }
}
public void run(){
System.out.println("Successfully connected with server ");
  System.out.println("type your messages :");
  try{
  while(!msgout.equals("exit")){
   msgout=br.readLine();

   dout.writeUTF(msgout);
  }
  
  }catch(Exception e){
    System.out.println("Error caugth "+e);
  }
}

  public static void main(String[] args) {
  String msgin="";
  String address=new String("");
  
  Scanner c=new Scanner(System.in);
  
  System.out.println("Enter port :");
int para=c.nextInt();

System.out.println("Enter ip addess of server :");
address=c.next();

client obj=new client(para,address);
obj.req();
obj.start();
try{

  while(!msgin.equals("exit")){
    msgin=(obj.din).readUTF();
//System.out.println();
    System.out.print("Server :"+msgin);
  }
  
  
}catch(Exception e){
  System.out.println("Error caugth "+e);
}



  }
}