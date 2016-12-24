package edu.ustc.debunker.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.*;

import edu.ustc.debunker.model.Answers;
import edu.ustc.debunker.model.Questions;

public class PaperToExlService {
	
	public void PaperToExl(List<Questions> questionslist,List<Answers> answerslist,String exam_id,String account,OutputStream out) throws IOException{
		HSSFWorkbook wb = new HSSFWorkbook();//创建Excel工作簿对象   
		HSSFSheet sheet = wb.createSheet("第" + exam_id + "场评测结果汇总表");//创建Excel工作表对象     
		HSSFCellStyle style = wb.createCellStyle();//创建单元格样式   
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
	    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    // 生成一个字体
	    HSSFFont font = wb.createFont();
	    font.setColor(HSSFColor.VIOLET.index);
	    font.setFontHeightInPoints((short) 12);
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    // 把字体应用到当前的样式
	    style.setFont(font);
	    HSSFRow row = sheet.createRow(0);
	    int n=0;
	    for (Questions que:questionslist) {
	       HSSFCell cell = row.createCell(n++);
	       cell.setCellStyle(style);
	       HSSFRichTextString text = new HSSFRichTextString(que.getQuestion());
	       cell.setCellValue(text);
	    }
	    int i=1,j=0;
	    row = sheet.createRow(i);
	    for(Answers ans:answerslist){
	    	if(j>=n){
	    		j=0;
	    		row = sheet.createRow(++i);
	    	}
	    	HSSFCell cell = row.createCell(j++);
		    cell.setCellStyle(style);
		    HSSFRichTextString text = new HSSFRichTextString(ans.getAnswer());
		    cell.setCellValue(text);
	    }
	    wb.write(out);
	}
}
