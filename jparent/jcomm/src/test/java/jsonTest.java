import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Maps;
import com.jmp.comm.Utils.JsonUtil;
import org.junit.Test;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-30 14:17
 */
public class jsonTest {


    @Test
    public void test001() {
        List<Map> listMap = new ArrayList<>();
        for(int k=0;k<5;k++) {
            Map map = Maps.newHashMap();
            map.put("k", k);
            listMap.add(map);
        }


        //转字符操作
        String result = JSON.toJSONString(listMap);

        JSONArray jsonArray = JSON.parseObject(result, JSONArray.class);

        JSONArray toolsArray = JsonUtil.objectToJson(listMap, JSONArray.class);

        System.err.println(jsonArray.toJSONString());
        System.err.println(toolsArray.toJSONString());
    }
}
