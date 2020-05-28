package com.wso2telco.wum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

import com.wso2telco.wum.exceptions.WumException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.commons.io.FileUtils;

public class WumMerger {
    private static final Logger LOGGER = Logger.getLogger(WumMerger.class.getName());
    public static void main(String[] args) throws WumException {
        LOGGER.info("WUM-MERGER STARTED ... ");
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("modules/wum-profile/src/main/resources/customizedList.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray wumList = (JSONArray) obj;

            for (int i = 0; i < wumList.size(); i++) {
                mergeChanges((JSONObject) wumList.get(i),"store", true, true);
                mergeChanges((JSONObject) wumList.get(i),"publisher", true, true);
                mergeChanges((JSONObject) wumList.get(i),"admin", true, true);
            }
            LOGGER.info("... WUM-MERGER FINISHED");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void mergeChanges(JSONObject wum, String module, Boolean mergeUpdatedFiles, Boolean mergeAddedFiles) throws WumException {
        JSONObject wObject = (JSONObject) wum.get(module);
        JSONArray fileList = new JSONArray();
        if(mergeUpdatedFiles) fileList = (JSONArray) wObject.get("updated");
        if(mergeAddedFiles) {
            JSONArray added = (JSONArray) wObject.get("added");
            fileList.addAll(added);
        }
        if (fileList.size()>0) doMerge(module, fileList);
    }
    private static void doMerge(String module,JSONArray jsonArray) throws WumException {
        String pwd = System.getProperty("user.dir");
        String jaggeryAppsDir = pwd + "/modules/p2-profile/product/target/features/jaggeryapps";
        File originalFolder = new File(jaggeryAppsDir + "/" + module);
        File tempFolder = new File(jaggeryAppsDir + "/" + module + "-temp");

        /**
         * Create temp directories and copy files
         */
        try {

            if (jsonArray != null) {
                for (int i=0; i<jsonArray.size();i++){
                    String file = (String) jsonArray.get(i);
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
                if(tempFolder.exists()){
                    throw new WumException(module+"-temp STILL FOUND EXCEPTION"+tempFolder.toString());
                }
                LOGGER.info(module.toUpperCase() +" Module Updated Successfully !!");
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
            LOGGER.info("<< WUM ABORTED >> Check the file list and re initiate ..");
            throw new WumException(ex);
        }
    }
}

