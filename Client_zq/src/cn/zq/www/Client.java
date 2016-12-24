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
		System.out.println("please input device id ��");
		Scanner sc=new Scanner(System.in);
		id = sc.nextInt();
		
		HeartBeat hb = new HeartBeat("201612130" + String.valueOf(id), '1', '1', "000000");
		//nextid = nextid + 1;
		
		try {
			//1.�����ͻ���Socket��ָ����������ַ�Ͷ˿ں�
			Socket socket = new Socket("127.0.0.1", 8888);
			//2.��ȡ������������������������Ϣ
			OutputStream os = socket.getOutputStream();//�ֽ������
			//ת��Ϊ��ӡ��
			PrintWriter pw = new PrintWriter(os);
			
			//pw.write(hb.toString());
			pw.println("poweron:" + hb.toString());
			pw.flush();
			
		    
		    System.out.println("�����ַ���update:1:1 or quit:0:0");
		    String m = sc.next();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while(true){
				//pw.println("poweron:" + hb.toString());
				//pw.println("update:" + hb.toString());
				//pw.println("poweroff:" + hb.toString());
				//pw.flush();//ˢ�»��棬��������������Ϣ
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
				
				System.out.println("�����ַ���update:1:1 or quit:0:0");
				m = sc.next();
			}
			//�ر������
			socket.shutdownOutput();
			//3.��ȡ��������������ȡ�������˵���Ӧ��Ϣ

	
			while ((info = br.readLine()) != null) {
				System.out.println("���ǿͻ��ˣ��������˷��ص���Ϣ�ǣ�" + info);
			}
			//4.�ر���Դ
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
