package edu.ustc.debunker.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import edu.ustc.debunker.model.Answers;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FileDownloadService {
	OutputStream os;//输出流 
	    WritableWorkbook wb;//建立Excel文件 
	    WritableSheet ws;//sheet名称 
	     
	    /** 
	     * 构造函数 
	     * @param os 
	     * @throws IOException 
	     */ 
	    public FileDownloadService(OutputStream os)throws IOException{ 
	        this.os=os; 
	    } 
	     
	    /** 
	     * 导出Excel方法 
	     * @param list 
	     * @throws WriteException 
	     */ 
	    public void ebfToExcel(List<Answers> alist) throws WriteException{ 
	        //设置样式(这个方法算是一个容器，可以放进去好多属性; 
	        //第一个: TIMES是字体大小，这里写的是12;第二个: BOLD是判断是否为斜体,选择true时为斜体; 
	        //第三个: ARIAL;第四个: UnderlineStyle.NO_UNDERLINE 下划线; 
	        //第五个: jxl.format.Colour.RED 字体颜色是红色的) 
	        WritableFont font2 = new WritableFont(WritableFont.TIMES, 12, 
	                WritableFont.BOLD); 
	        WritableCellFormat format2 = new WritableCellFormat(font2); 
	        format2.setAlignment(jxl.format.Alignment.CENTRE);//设置居中 
	        try{ 
	            wb=Workbook.createWorkbook(os); 
	            ws=wb.createSheet("评测结果", 0); 	             
	            //第一个是代表列数,  
	            //第二是代表行数，  
	            //第三个代表要写入的内容  
	            //第四个是可选项，是输入这个label里面的样式  
	            //然后通过写sheet的方法addCell（）把内容写进sheet里面。  
	            Label labelA=new Label(0,0,"报修人",format2); 
	            ws.addCell(labelA); 
	             
	            Label labelB=new Label(1,0,"所在部门",format2); 
	            ws.addCell(labelB); 
	             
	            Label labelC=new Label(2,0,"报修日期",format2); 
	            ws.addCell(labelC); 
	             
	            Label labelD=new Label(3,0,"消耗品名称",format2); 
	            ws.addCell(labelD); 
	             
	            Label labelF=new Label(4,0,"消耗品报修描述",format2); 
	            ws.addCell(labelF); 	 
	            writeRecruit(alist);//获取动态内容的方法 
	            wb.write();//写入 
	            wb.close();//关闭 
	        }catch(Exception e){ 
	            e.printStackTrace(); 
	        } 
	    } 
	     
	    private void writeRecruit(List<Answers> stuList){ 
	        if(stuList.size()==0){ 
	            return ; 
	        } 
	        for(int i=0;i<stuList.size();i++){ 
	            /*String person="";//报修人 
	            if(null!=stuList.get(i).getBxr()){ 
	                person=stuList.get(i).getBxr().toString(); 
	            } 
	            Label labelBxr = new Label(0,i+1,person); 
	             
	            String dept="";//所在部门 
	            if(null!=stuList.get(i).getBm()){ 
	                dept=stuList.get(i).getBm().toString(); 
	            } 
	            Label labelBm=new Label(1,i+1,dept); 
	             
	            String date="";//报修日期 
	            if(null!=stuList.get(i).getBdate()){ 
	                date=stuList.get(i).getBdate().toString(); 
	            } 
	            Label labelBdate=new Label(2,i+1,date); 
	             */
	            
	            /* 
	             * 统一添加到列表中 
	             * */ 
	            try{ 
	               /* ws.addCell(labelBxr); 
	                ws.addCell(labelBm); 
	                ws.addCell(labelBdate); */
	            }catch(Exception e){ 
	                e.printStackTrace(); 
	            } 
	        } 
	    } 
	
}
