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
        //��Ҫ������Excel�ļ�
        List<User> studentList = new ArrayList<>();
        try{
            //��ȡ������
            HSSFWorkbook workbook=new HSSFWorkbook(fs);
            //��ȡ��һ��������
            HSSFSheet hs=workbook.getSheetAt(0);
            //��ȡSheet�ĵ�һ���кź����һ���к�
            int last=hs.getLastRowNum();
            int first=hs.getFirstRowNum();
            //������ȡ��Ԫ�������Ϣ
            for (int i = first+1; i <= last; i++) {
                HSSFRow row=hs.getRow(i);
                int firstCellNum=row.getFirstCellNum();//��ȡ�����еĵ�һ���к�
                int lastCellNum=row.getLastCellNum();//��ȡ�����е����һ���к�
                User user = new User();
                try {
        			// ��װ����
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
        //���õ�Ԫ������
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
}



