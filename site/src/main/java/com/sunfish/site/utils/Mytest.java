package com.sunfish.site.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mytest {

    @Getter
    @Setter
    @ToString
    public static
    class DemoObj {
        private String id;
        private String pid;
        private String title;
        private List<DemoObj> children;

        public DemoObj(String id, String pid, String title) {
            this.id = id;
            this.pid = pid;
            this.title = title;
        }
    }


    public DemoObj combineTree(List<DemoObj> modeList) {
        String rootId = "1";
        DemoObj root = null;
        Map<String, List<DemoObj>> childrenMap = new HashMap<>();//pid ,this
        for (DemoObj demoObj : modeList) {
            if (StringUtils.equals(rootId, demoObj.getId())) {
                root = demoObj;
            }
            List<DemoObj> demoObjs = childrenMap.get(demoObj.getPid());//subling
            if (demoObjs == null) {
                demoObjs = new ArrayList<>();
                childrenMap.put(demoObj.getPid(), demoObjs);
            }
            demoObjs.add(demoObj);
            List<DemoObj> demoObjs1 = childrenMap.get(demoObj.getId());
            if (demoObjs1 == null) {
                demoObjs1 = new ArrayList<>();
                childrenMap.put(demoObj.getId(), demoObjs1);
            }
            demoObj.setChildren(demoObjs1);
        }
        return root;
    }

    public void test() {
        List demolist = new ArrayList();
        demolist.add(new DemoObj("1", "", "顶级"));
        demolist.add(new DemoObj("122", "12", "第三层22"));
        demolist.add(new DemoObj("123", "12", "第三层23"));
        demolist.add(new DemoObj("112", "11", "第三层12"));
        demolist.add(new DemoObj("113", "11", "第三层13"));
        demolist.add(new DemoObj("114", "11", "第三层14"));
        demolist.add(new DemoObj("12", "1", "第二层2"));
        demolist.add(new DemoObj("11", "1", "第二层1"));
        demolist.add(new DemoObj("111", "11", "第三层11"));
        demolist.add(new DemoObj("121", "12", "第三层21"));
        demolist.add(new DemoObj("13", "1", "第二层3"));
        demolist.add(new DemoObj("14", "1", "第二层4"));
        DemoObj demoObj = combineTree(demolist);
        System.out.println(demoObj);
    }
}
