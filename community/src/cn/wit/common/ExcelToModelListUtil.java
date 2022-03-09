package cn.wit.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import cn.wit.pojo.CommunityInfo;
import cn.wit.pojo.HouseHold;
import cn.wit.pojo.User;
import cn.wit.service.UserRegisterService;
import cn.wit.serviceImpl.UserRegisterServiceImpl;

public class ExcelToModelListUtil {
	static UserRegisterService  registerService = new UserRegisterServiceImpl();

    private ExcelToModelListUtil(){
    }
    public static List<User> getList(InputStream fs) {
        //需要解析的Excel文件
        List<User> studentList = new ArrayList<>();
        try{
            //获取工作簿
            HSSFWorkbook workbook=new HSSFWorkbook(fs);
            //获取第一个工作表
            HSSFSheet hs=workbook.getSheetAt(0);
            //获取Sheet的第一个行号和最后一个行号
            int last=hs.getLastRowNum();
            int first=hs.getFirstRowNum();
            //遍历获取单元格里的信息
            for (int i = first+1; i <= last; i++) {
                HSSFRow row=hs.getRow(i);
                int firstCellNum=row.getFirstCellNum();//获取所在行的第一个行号
                int lastCellNum=row.getLastCellNum();//获取所在行的最后一个行号
                User user = new User();
                try {
        			// 封装对象
        			CommunityInfo community = new CommunityInfo();
        			HouseHold household = new HouseHold();
        			
        			user.setUsername((String)getValue(row, firstCellNum++));
        			user.setPassword((String)getValue(row, firstCellNum++));
        			user.setName((String)getValue(row, firstCellNum++));
        			user.setSex(Integer.parseInt(String.valueOf(getValue(row,firstCellNum++))));
        			user.setIdentityNumber((String)getValue(row, firstCellNum++));
        			user.setPhoneNumber((String)getValue(row, firstCellNum++));
        			community.setCommunityname((String)getValue(row, firstCellNum++));
        			community.setLocation((String)getValue(row, firstCellNum++));
        			household.setUnit((String)getValue(row, firstCellNum++));
        			household.setBuliding(Integer.parseInt(String.valueOf(getValue(row,firstCellNum++))));
        			household.setRoom(Integer.parseInt(String.valueOf(getValue(row,firstCellNum++))));
        			user.setCommunityInfo(community);
        			user.setHousehold(household);
        			
        			registerService.userRegister(user);
        		} catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(studentList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    private static Object  getValue(HSSFRow row,int j){
        HSSFCell cell=row.getCell(j);
        //设置单元格类型
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
}



