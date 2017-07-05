package com.asiainfo.relievedfigure.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.asiainfo.relievedfigure.model.Cost;
import com.asiainfo.relievedfigure.model.DataButter;
import com.asiainfo.relievedfigure.model.DataOther;
import com.asiainfo.relievedfigure.model.Txt;
import com.asiainfo.relievedfigure.service.ComboProcService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Controller
@RequestMapping("/proc")
public class ComboProcController {

    private final static Logger logger = Logger.getLogger(ComboProcController.class);


    @Resource
    private ComboProcService comboProcService;

    @RequestMapping("/testproc")
    @ResponseBody
    public Map<String, Object> selectUser(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam Map<String, Object> mapParam) {
        Map<String, Object> map = new HashMap<>();
        map.put("IN_FLOW", Integer.valueOf(String.valueOf(mapParam.get("civilFlow"))));
        map.put("IN_VOICE", Integer.valueOf(String.valueOf(mapParam.get("voiceTime"))));
        comboProcService.getProc(map);
        List<DataButter> listData1 = new ArrayList<DataButter>();
        DataButter dataButter = new DataButter();
        String OUT_PLAN11 = map.get("OUT_PLAN11").toString();
        String OUT_TOTALFEE11 = map.get("OUT_TOTALFEE11").toString();

        DataButter dataButter1 = new DataButter();
        String OUT_PLAN12 = map.get("OUT_PLAN12").toString();
        String OUT_TOTALFEE12 = map.get("OUT_TOTALFEE12").toString();


        DataButter dataButter2 = new DataButter();
        String OUT_PLAN13 = map.get("OUT_PLAN13").toString();
        String OUT_TOTALFEE13 = map.get("OUT_TOTALFEE13").toString();


        listData1.add(getDataButterData(dataButter,OUT_PLAN11,OUT_TOTALFEE11));
        listData1.add(getDataButterData(dataButter1,OUT_PLAN12,OUT_TOTALFEE12));
        listData1.add(getDataButterData(dataButter2,OUT_PLAN13,OUT_TOTALFEE13));
        String strData1 = JSON.toJSON(listData1).toString();
        JSONArray json1 = JSONArray.parseArray(strData1);

        List<DataOther> listData2 = new ArrayList<DataOther>();
        DataOther dataOther = new DataOther();
        dataOther.setFlow(map.get("OUT_FLOW11").toString());
        dataOther.setFlowCost(map.get("OUT_FLOWPRICE11").toString());
        dataOther.setCallTime(map.get("OUT_VOICE11").toString());
        dataOther.setLocalCall(map.get("OUT_VOICEPRICE11").toString());
        dataOther.setFeeCost(map.get("OUT_PLANFEE11").toString());
        DataOther dataOther1 = new DataOther();
        dataOther1.setFlow(map.get("OUT_FLOW12").toString());
        dataOther1.setFlowCost(map.get("OUT_FLOWPRICE12").toString());
        dataOther1.setCallTime(map.get("OUT_VOICE12").toString());
        dataOther1.setLocalCall(map.get("OUT_VOICEPRICE12").toString());
        dataOther1.setFeeCost(map.get("OUT_PLANFEE12").toString());
        DataOther dataOther2 = new DataOther();
        dataOther2.setFlow(map.get("OUT_FLOW13").toString());
        dataOther2.setFlowCost(map.get("OUT_FLOWPRICE13").toString());
        dataOther2.setCallTime(map.get("OUT_VOICE13").toString());
        dataOther2.setLocalCall(map.get("OUT_VOICEPRICE13").toString());
        dataOther2.setFeeCost(map.get("OUT_PLANFEE13").toString());
        listData2.add(dataOther);
        listData2.add(dataOther1);
        listData2.add(dataOther2);
        String strData2 = JSON.toJSON(listData2).toString();
        JSONArray json2 = JSONArray.parseArray(strData2);

        List<DataButter> listData3 = new ArrayList<DataButter>();
        DataButter dataButter4 = new DataButter();
        String OUT_PLAN21 = map.get("OUT_PLAN21").toString();
        String OUT_TOTALFEE21 = map.get("OUT_TOTALFEE21").toString();


        DataButter dataButter5 = new DataButter();
        String OUT_PLAN22 = map.get("OUT_PLAN22").toString();
        String OUT_TOTALFEE22 = map.get("OUT_TOTALFEE22").toString();

        DataButter dataButter6 = new DataButter();
        String OUT_PLAN23 = map.get("OUT_PLAN23").toString();
        String OUT_TOTALFEE23 = map.get("OUT_TOTALFEE23").toString();

        listData3.add(getDataButterData(dataButter4,OUT_PLAN21,OUT_TOTALFEE21));
        listData3.add(getDataButterData(dataButter5,OUT_PLAN22,OUT_TOTALFEE22));
        listData3.add(getDataButterData(dataButter6,OUT_PLAN23,OUT_TOTALFEE23));
        String strData3 = JSON.toJSON(listData3).toString();
        JSONArray json3 = JSONArray.parseArray(strData3);

        List<DataOther> listData4 = new ArrayList<DataOther>();
        DataOther dataOther3 = new DataOther();
        dataOther3.setFlow(map.get("OUT_FLOW21").toString());
        dataOther3.setFlowCost(map.get("OUT_FLOWPRICE21").toString());
        dataOther3.setCallTime(map.get("OUT_VOICE21").toString());
        dataOther3.setLocalCall(map.get("OUT_VOICEPRICE21").toString());
        dataOther3.setFeeCost(map.get("OUT_PLANFEE21").toString());
        DataOther dataOther4 = new DataOther();
        dataOther4.setFlow(map.get("OUT_FLOW22").toString());
        dataOther4.setFlowCost(map.get("OUT_FLOWPRICE22").toString());
        dataOther4.setCallTime(map.get("OUT_VOICE22").toString());
        dataOther4.setLocalCall(map.get("OUT_VOICEPRICE22").toString());
        dataOther4.setFeeCost(map.get("OUT_PLANFEE22").toString());
        DataOther dataOther5 = new DataOther();
        dataOther5.setFlow(map.get("OUT_FLOW23").toString());
        dataOther5.setFlowCost(map.get("OUT_FLOWPRICE23").toString());
        dataOther5.setCallTime(map.get("OUT_VOICE23").toString());
        dataOther5.setLocalCall(map.get("OUT_VOICEPRICE23").toString());
        dataOther5.setFeeCost(map.get("OUT_PLANFEE23").toString());
        listData4.add(dataOther3);
        listData4.add(dataOther4);
        listData4.add(dataOther5);
        String strData4 = JSON.toJSON(listData4).toString();
        JSONArray json4 = JSONArray.parseArray(strData4);
        System.out.println(json4.toString());


        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data1", json1);
        resultMap.put("data2", json2);
        resultMap.put("data3", json3);
        resultMap.put("data4", json4);
        return resultMap;
    }

    public DataButter getDataButterData(DataButter dataButter, String string1, String string2) {

        String[] strings = string1.split("\\$");
        String[] strings2 = string2.split("\\$");

        int a = strings.length;
        switch (a) {
            case 1:
                String oneTxt1 = strings[0];
                Txt txt1 = new Txt();
                txt1.setOne(oneTxt1);
                txt1.setTwo("");
                txt1.setThree("");
                dataButter.setTxt(txt1);
                break;
            case 2:
                String oneTxt2 = strings[0];
                String twoTxt2 = strings[1];
                Txt txt2 = new Txt();
                txt2.setOne(oneTxt2);
                txt2.setTwo(twoTxt2);
                txt2.setThree("");
                dataButter.setTxt(txt2);
                break;
            case 3:
                String oneTxt3 = strings[0];
                String twoTxt3 = strings[1];
                String threeTxt3 = strings[2];
                Txt txt3 = new Txt();
                txt3.setOne(oneTxt3);
                txt3.setTwo(twoTxt3);
                txt3.setThree(threeTxt3);
                dataButter.setTxt(txt3);
                break;
        }
        String oneCost = strings2[0];
        String twoCost = strings2[1];
        Cost cost = new Cost();
        cost.setOne(oneCost);
        cost.setTwo(twoCost);
        dataButter.setCost(cost);
        return dataButter;
    }


}
