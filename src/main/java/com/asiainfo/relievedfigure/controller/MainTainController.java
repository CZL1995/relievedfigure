package com.asiainfo.relievedfigure.controller;

import com.asiainfo.relievedfigure.model.PlanInfo;


import com.asiainfo.relievedfigure.service.PlanInfoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.bind.JAXBIntrospector.getValue;
import static org.springframework.util.StringUtils.isEmpty;

/**
 * Created by Caozl on 2017-07-04.
 */
@Controller
@RequestMapping("/maintain")
public class MainTainController {

    @Resource
    private PlanInfoService planInfoService;



    @RequestMapping(value = "/submitText", method = RequestMethod.POST)
    @ResponseBody
    public String submitText(MultipartFile file, HttpServletRequest request) throws IOException {
        getFile(file, request);
        return "ok!";
    }

    @RequestMapping(value = "/submitExcel", method = RequestMethod.POST)
    @ResponseBody
    public String submitExcel(MultipartFile file, HttpServletRequest request) throws IOException {
        getFile(file, request);
        return "ok!";
    }

    public String getFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        List<PlanInfo> planInfoList = readXlsx(path + "\\" + fileName);

        for (int i = 0; i < planInfoList.size(); i++) {
            System.out.println(planInfoList.get(i).toString());
        }

        return fileName;
    }

    private List<PlanInfo> readXlsx(String path) {

        XSSFWorkbook xssfWorkbook = null;
        try {
            InputStream is = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlanInfo planInfo = null;
        List<PlanInfo> list = new ArrayList<PlanInfo>();
        if (xssfWorkbook != null) {
            // Read the Sheet
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                // Read the Row
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        planInfo = new PlanInfo();
                        XSSFCell planName = xssfRow.getCell(0);
                        XSSFCell planType = xssfRow.getCell(1);
                        XSSFCell planId = xssfRow.getCell(2);
                        XSSFCell groupList = xssfRow.getCell(3);
                        XSSFCell planPrice = xssfRow.getCell(4);
                        XSSFCell voice = xssfRow.getCell(5);
                        XSSFCell priceVoicej1 = xssfRow.getCell(6);
                        XSSFCell flow = xssfRow.getCell(7);
                        XSSFCell priceFlowj1 = xssfRow.getCell(8);
                        XSSFCell flowj1 = xssfRow.getCell(9);
                        XSSFCell priceFlowj2 = xssfRow.getCell(10);
                        XSSFCell flowj2 = xssfRow.getCell(11);
                        XSSFCell ifShare = xssfRow.getCell(12);
                        planInfo.setPlanName(String.valueOf(getValue(planName)));
                        planInfo.setPlanType(planType.getStringCellValue());
                        if (getIntData(planId)!=0){
                            planInfo.setPlanId(getIntData(planId));
                        }
                        planInfo.setGroupList((String.valueOf(getValue(groupList))));
                        if (getIntData(planPrice)!=0){
                            planInfo.setPlanPrice(getIntData(planPrice));
                        }
                        if (getIntData(voice)!=0){
                            planInfo.setVoice(getIntData(voice));
                        }
                        if (getIntData(priceVoicej1)!=0){
                            planInfo.setPriceVoicej1(getIntData(priceVoicej1));
                        }
                        if (getIntData(flow)!=0){
                            planInfo.setFlow(getIntData(flow));
                        }
                        if (getIntData(priceFlowj1)!=0){
                            planInfo.setPriceFlowj1(getIntData(priceFlowj1));
                        }
                        if (getIntData(flowj1)!=0){
                            planInfo.setFlowj1(getIntData(flowj1));
                        }
                        if (getIntData(priceFlowj2)!=0){
                            planInfo.setPriceFlowj2(getIntData(priceFlowj2));
                        }
                        if (getIntData(flowj2)!=0){
                            planInfo.setFlowj2(getIntData(flowj2));
                        }
                        if (getIntData(ifShare)!=0){
                            planInfo.setIfShare(getIntData(ifShare));
                        }
                        planInfoService.insertPlanInfo(planInfo);
                        list.add(planInfo);
                    }
                }
            }
        }
        return list;
    }


    public int getIntData(XSSFCell cell) {
        Object inputValue = null;// 单元格值
        if (!isEmpty(cell) && cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

            long longVal = Math.round(cell.getNumericCellValue());

            if (Double.parseDouble(longVal + ".0") == cell.getNumericCellValue()){
                inputValue = longVal;
            }else {
                inputValue = cell.getNumericCellValue();
            }
        }
        if(StringUtils.isEmpty(inputValue)){
            return 0;
        }

        return  Integer.valueOf(inputValue.toString());
    }


}
