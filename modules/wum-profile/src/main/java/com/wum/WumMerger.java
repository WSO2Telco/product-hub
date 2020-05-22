package com.wum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.commons.io.FileUtils;

public class WumMerger {
    private static final Log log = LogFactory.getLog(WumMerger.class);
    public static void main(String[] args) {
        log.info("[[[[[[[[[[[[[[[[[ SCRIPT STARTED ]]]]]]]]]]]]]]]]]]]]]");
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("modules/wum-profile/src/main/resources/customizedList.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray wumList = (JSONArray) obj;

            for (int i = 0; i < wumList.size(); i++) {
                mergeChanges((JSONObject) wumList.get(i),"store");
                mergeChanges((JSONObject) wumList.get(i),"publisher");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void mergeChanges(JSONObject wum, String module)
    {
        JSONObject wObject = (JSONObject) wum.get(module);
        JSONArray updated = (JSONArray) wObject.get("updated");
        JSONArray added = (JSONArray) wObject.get("added"); // TODO: Implement

        String pwd = System.getProperty("user.dir");
        String jaggeryAppsDir = pwd + "/modules/p2-profile/product/target/features/jaggeryapps";
        File originalFolder = new File(jaggeryAppsDir + "/" + module);
        File tempFolder = new File(jaggeryAppsDir + "/" + module + "-temp");

        /**
         * Create temp directories and copy files
         */
        try {

            if (updated != null) {
                for (int i=0; i<updated.size();i++){
                    String file = (String) updated.get(i);
                    file = file.replace("/repository/deployment/server/jaggeryapps/"+module,"");

                    File from = new File(jaggeryAppsDir+"/"+module+file);
                    File to = new File(jaggeryAppsDir+"/"+module+"-temp"+file);

                    FileUtils.copyFile(from, to);
                }
                /**
                 * Replace original folder with temp
                 */
                FileUtils.deleteDirectory(originalFolder);
                FileUtils.copyDirectory(tempFolder, originalFolder);
                FileUtils.deleteDirectory(tempFolder);

                System.out.println(module.toUpperCase() +" Module Updated Successfully !!");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

