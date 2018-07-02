package com.practice.concurrency.json;

import com.google.gson.*;
import com.practice.concurrency.dal.model.AppFilePathDO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * java 读取json文件并解析
 *
 * @author hetao
 * @create 2018-07-02 下午2:29
 */
public class ReadJsonFileTest {

    public static void main(String[] args) {

        // 测试解析方法
        ReadJsonFileTest readJsonFileTest = new ReadJsonFileTest();
        List<AppFilePathDO> appFilePathDOS = readJsonFileTest.readJsonFile();
    }

    /**
     * 解析具体实现
     * @return
     */
    public List<AppFilePathDO> readJsonFile() {

        //需要创建一个解析器，可以用来解析字符串或输入流
        JsonParser parser = new JsonParser();
        List<AppFilePathDO> appFilePathDOS = new ArrayList<>();
        try {

            JsonObject object = (JsonObject) parser.parse(new FileReader("fileNameByPackageName.json"));
            JsonArray array = object.get("value").getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {

                //创建一个JsonObject，从array的下标获取，get() 返回JsonElement类型

                //这里不用强转，而用 getAsJsonObject() 进行转换

                JsonObject subObject = array.get(i).getAsJsonObject();

                AppFilePathDO appFilePathDO = new AppFilePathDO();
                appFilePathDO.setAppFileId(subObject.get("id").getAsString());
                appFilePathDO.setAppName(subObject.get("note").getAsString());
                appFilePathDO.setFilePath(subObject.get("path").getAsString());

                appFilePathDOS.add(appFilePathDO);

            }

        } catch (JsonIOException e) {

            e.printStackTrace();

        } catch (JsonSyntaxException e) {

            e.printStackTrace();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        return appFilePathDOS;

    }
}
