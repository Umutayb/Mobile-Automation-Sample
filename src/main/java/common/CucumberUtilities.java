package common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.cucumber.CucumberReport;
import models.slack.Receivers;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pickleib.mobile.utilities.MobileUtilities;
import utils.PropertyUtility;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class CucumberUtilities extends MobileUtilities {

    ObjectMapper mapper = new ObjectMapper();

    public CucumberUtilities(){
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public List<Receivers.Receiver> getReceivers() {
        try(FileReader file = new FileReader(PropertyUtility.getProperty("receivers-directory"))) {
            return mapper.readValue(file, Receivers.class).receivers();
        }
        catch (IOException e) {throw new RuntimeException(e);}
    }

    public List<CucumberReport> getCucumberReport(String directory){
        try {
            List<CucumberReport> reports = new ArrayList<>();
            FileReader reportFile = new FileReader(directory);
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(reportFile);
            for (Object jsonObject: array) {
                String json = jsonObject.toString();
                reports.add(mapper.readValue(json , CucumberReport.class));
            }
            return  reports;
        }
        catch (IOException | ParseException e) {throw new RuntimeException(e);}
    }
}
