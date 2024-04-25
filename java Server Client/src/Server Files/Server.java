/*Server
 *
 *v1.0
 *
 *10-08-2021
 *
 *This is CopyRighted By Me(Mustafa) 
 */ 
//package com.test.Myapp;
//import com.test.Myapp.Server;
import java.io.DataInputStream;
import java.net.*;
import java.net.ServerSocket;
import java.util.*;

/**
 *This file is copyrighted by me
 *Author of this File is Me(Mustafa)
 *Do not use in Wrong Way
 *I will not be Responsible for any damage happen with my codes
 */

public class Server {

ServerSocket ss;
public Server(int port) {
  try{
    ss=new ServerSocket(port);
    
  }catch(Exception e){
    System.out.println("Error caugth "+e);
  }
}

public static void main(String[] arg) {
String name;
String msgin="";
 System.out.println("Enter port :");
  Scanner b=new Scanner(System.in);
 int p=b.nextInt();
/* System.out.println("Enter your name :");
 name=b.next();*/
Server obj=new Server(p);
write ob=new write(obj.ss,p);
ob.req();
ob.start();

DataInputStream din;
try{
  din=new DataInputStream((ob.s).getInputStream());
  while(!msgin.equals("exit")){
    msgin=din.readUTF();
   System.out.println();
    System.out.println("Client :"+msgin);
  }
}catch(Exception e){
  System.out.println("Error caugth "+e);
}


  }
}
