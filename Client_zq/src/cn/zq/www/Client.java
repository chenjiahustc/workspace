package cn.zq.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	//static private int nextid = 0;
	
	public static void main(String[] args) {
		int id = 0;
		System.out.println("please input device id ：");
		Scanner sc=new Scanner(System.in);
		id = sc.nextInt();
		
		HeartBeat hb = new HeartBeat("201612130" + String.valueOf(id), '1', '1', "000000");
		//nextid = nextid + 1;
		
		try {
			//1.创建客户端Socket，指定服务器地址和端口号
			Socket socket = new Socket("127.0.0.1", 8888);
			//2.获取输出流，用来向服务器发送信息
			OutputStream os = socket.getOutputStream();//字节输出流
			//转换为打印流
			PrintWriter pw = new PrintWriter(os);
			
			//pw.write(hb.toString());
			pw.println("poweron:" + hb.toString());
			pw.flush();
			
		    
		    System.out.println("输入字符：update:1:1 or quit:0:0");
		    String m = sc.next();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while(true){
				//pw.println("poweron:" + hb.toString());
				//pw.println("update:" + hb.toString());
				//pw.println("poweroff:" + hb.toString());
				//pw.flush();//刷新缓存，向服务器端输出信息
				String[] strs = m.split(":");
				if(strs[0].equals("quit")){
					pw.println("poweroff:" + hb.toString());
					pw.flush();
					break;
				}else if (strs[0].equals("update")){
					hb.setState(strs[1].charAt(0));
					hb.setDoorstate(strs[2].charAt(0));
					pw.println("update:" + hb.toString());
					pw.flush();
				} else{
					System.out.println("format error, please try again:");
				}
				
				info = br.readLine();
				if(info.equals("get")){
					pw.println("update:" + hb.toString());
					pw.flush();
					info = null;
				}
				
				System.out.println("输入字符：update:1:1 or quit:0:0");
				m = sc.next();
			}
			//关闭输出流
			socket.shutdownOutput();
			//3.获取输入流，用来读取服务器端的响应信息

	
			while ((info = br.readLine()) != null) {
				System.out.println("我是客户端，服务器端返回的信息是：" + info);
			}
			//4.关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
