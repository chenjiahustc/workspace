package cn.zq.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    // 和本线程相关的Socket
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
    //线程执行的操作，响应客户端的请求
    public void run(){
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info=null;
            HeartBeat hb = null;
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            int i = 0;
            while((info=br.readLine())!=null){//循环读取客户端的信息
            	//hb = new HeartBeat(info);
            	//System.out.println("我是服务器，客户端说：" + hb.toString());
                System.out.println("我是服务器，客户端说："+info);
                workState(info);
                //根据客户端的请求操作数据库
                if(i % 5 == 0){
                	pw.println("get");
                	pw.flush();
                }else{
                	pw.println("notget");
                	pw.flush();
                }
                i++;
                
            }
            socket.shutdownInput();//关闭输入流
            //获取输出流，响应客户端的请求

            pw.write("欢迎您！");
            pw.flush();//调用flush()方法将缓冲输出
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭资源
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