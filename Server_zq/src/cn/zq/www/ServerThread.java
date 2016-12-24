package cn.zq.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    // �ͱ��߳���ص�Socket
    Socket socket = null;
    WorkState_db wsdb = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
        wsdb = new WorkState_db();
    }
    //cmd = "poweroff:#mj2016121301,0,1,000000,u"
    public void workState(String cmd){
    	String[] cmds = cmd.split(":");
    	
    	if(cmds[0].equals("poweron")){
    		//todo insert
    		wsdb.insertState(cmds[1]);
    	}else if(cmds[0].equals("update")){
    		//todo update
    		wsdb.udpateState(cmds[1]);
    	}else if(cmds[0].equals("poweroff")){
    		//todo delete
    		wsdb.deleteState(cmds[1]);
    	}else
    		;
    }
    //�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
    public void run(){
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
            //��ȡ������������ȡ�ͻ�����Ϣ
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info=null;
            HeartBeat hb = null;
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            int i = 0;
            while((info=br.readLine())!=null){//ѭ����ȡ�ͻ��˵���Ϣ
            	//hb = new HeartBeat(info);
            	//System.out.println("���Ƿ��������ͻ���˵��" + hb.toString());
                System.out.println("���Ƿ��������ͻ���˵��"+info);
                workState(info);
                //���ݿͻ��˵�����������ݿ�
                if(i % 5 == 0){
                	pw.println("get");
                	pw.flush();
                }else{
                	pw.println("notget");
                	pw.flush();
                }
                i++;
                
            }
            socket.shutdownInput();//�ر�������
            //��ȡ���������Ӧ�ͻ��˵�����

            pw.write("��ӭ����");
            pw.flush();//����flush()�������������
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //�ر���Դ
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}