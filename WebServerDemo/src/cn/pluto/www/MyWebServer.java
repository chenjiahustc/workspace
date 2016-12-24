package cn.pluto.www;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		OutputStream os = null;
		BufferedReader br = null; 
		
		try{
			ss = new ServerSocket(9999);
			s = ss.accept();
			System.out.println(" listen on port 9999");
			os = s.getOutputStream();
			br = new BufferedReader(new FileReader("hello.html"));
			
			String buf = "";
			while((buf = br.readLine()) != null){
				os.write(buf.getBytes());
			}

			
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			if (br != null){
				try{
					br.close();
				} catch(Exception e){
					e.printStackTrace();
				}
				
				br = null;
			}
			
			if (os != null){
				try{
					os.close();
				} catch(Exception e){
					e.printStackTrace();
				}
				
				os = null;
			}
			
			if (s != null){
				try {
					s.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
				s = null;
			}
			
			if (ss != null){
				try{
					ss.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
				ss = null;
			}
		}
		
		

	}

}
