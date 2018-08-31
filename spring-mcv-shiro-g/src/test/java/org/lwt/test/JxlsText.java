package org.lwt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.lwt.entity.Employee;



public class JxlsText {
  
  public static void main(String[] args) throws Exception {
   /* String path = JxlsText.class.getClassLoader().getResource("customer_template.xlsx").getPath();
    path = path.substring(1, path.length());*/
    List<Employee> employees = generateSampleEmployeeData();
    String path = JxlsText.class.getClassLoader().getResource("customer_template.xlsx").getPath();
    path = path.substring(1, path.length());
    System.out.println(path);
    try(InputStream is = new FileInputStream(new File(path))) {
      try (OutputStream os = new FileOutputStream("target/customer_collection_output.xlsx")) {
          Context context = new Context();
          context.putVar("employees", employees);
          JxlsHelper.getInstance().processTemplate(is, os, context);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
 // getting input stream for our report template file from classpath
   /* InputStream is = new FileInputStream(new File(path));
    // creating POI Workbook
    Workbook workbook = WorkbookFactory.create(is);
    // creating JxlsPlus transformer for the workbook
    PoiTransformer transformer = PoiTransformer.createTransformer(workbook);
    // creating XlsCommentAreaBuilder instance
    AreaBuilder areaBuilder = new XlsCommentAreaBuilder(transformer);
    // using area builder to construct a list of processing areas
    List<Area> xlsAreaList = areaBuilder.build();
    System.out.println(xlsAreaList);
    // getting the main area from the list
    Area xlsArea = xlsAreaList.get(0);
    System.out.println(xlsArea.getCommandDataList().get(0).getStartCellRef());*/
    
  }
  
  private static List<Employee> generateSampleEmployeeData(){
    SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd");
    
    List<Employee> list = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
      Employee employee = new Employee();
      employee.setName("¹¬Æé¿¥"+ (char)(i << 2));
      employee.setPayment(BigDecimal.valueOf(9000));
      employee.setBonus(BigDecimal.valueOf(3000));
      employee.setBirthDate(format.format(new Date()));
      list.add(employee);
    }
    return list;
  }
}
