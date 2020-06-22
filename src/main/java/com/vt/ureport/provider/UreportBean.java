package com.vt.ureport.provider;

import com.vt.ureport.entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: fanzhonglei
 * @Date: 2020/6/22 9:11
 **/
@Component
public class UreportBean {
    /**

     * 方法必须包含三个参数：String，String，Map

     *

     * @return 集合类型 ，包含字段：id,name,salary

     */

    public List<Map<String, Object>> loadReportData(String dsName, String datasetName, Map<String, Object> parameters) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < 1000; i++) {

            // 模拟数据

            Map<String, Object> m = new HashMap<String, Object>();

            m.put("id", i);

            m.put("name", RandomStringUtils.random(10, true, false));

            m.put("salary", RandomUtils.nextInt() + i);

            list.add(m);

        }

        return list;

    }



    /**

     * @return 对象类型 ,类型：com.bstek.ureport.test.demo.User

     */

    public List<User> buildReport(String dsName, String datasetName, Map<String, Object> parameters) {

        List<User> list = new ArrayList<User>();

        for (int i = 0; i < 1000; i++) {

            User m = new User();

            m.setId(i);

            m.setUserName(RandomStringUtils.random(10, true, false));

            m.setSalary(RandomUtils.nextDouble() + i);

            list.add(m);
        }

        return list;
    }
}
