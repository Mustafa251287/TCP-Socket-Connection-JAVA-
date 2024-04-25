/*write
 *
 *v1.0
 *
 *10-08-2021
 *
 *This is CopyRighted By Me(Mustafa) 
 */ 
//package com.test.Myapp;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 *This file is copyrighted by me
 *Author of this File is Me(Mustafa)
 *Do not use in Wrong Way
 *I will not be Responsible for any damage happen with my codes
 */


public class write extends Thread {
ServerSocket k;
Socket s;
public int para;
String msgout="";
DataOutputStream dout;
BufferedReader br;
public write(ServerSocket kk,int port){
try{
  k=kk;
  para=port;
  }catch(Exception e){
    System.out.print("Error "+e);
  }
}
public void req(){
  try{
  s=k.accept();
   
    dout=new DataOutputStream(s.getOutputStream());
    
br=new BufferedReader(new InputStreamReader(System.in));


  }catch(Exception e){
    System.out.println("Exception caugth "+e);
  }
    
}
public void run(){
System.out.println("Successfully connected  with client on port "+para);
  System.out.println("Enter your messages now ");
  try{
  while(!msgout.equals("exit")){
  msgout=br.readLine();
  dout.writeUTF(msgout);
  }
  }catch(Exception e){
    System.out.println("Error caugth :"+e);
  }
  }

}
