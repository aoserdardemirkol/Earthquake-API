package com.project.earthquake.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.earthquake.dto.EarthquakeDto;
import com.project.earthquake.dto.request.EarthquakeRequest;
import com.project.earthquake.exception.NotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EarthquakeService {

    public List<EarthquakeDto> getEarthquakeLastFewDays(EarthquakeRequest earthquakeRequest) throws ParseException {

        List<EarthquakeDto> earthquakeDtoList = new ArrayList<>();

        LocalDate currentDay = LocalDate.now();
        LocalDate minusDays = currentDay.minusDays(earthquakeRequest.getCountofDays());

        // added for convert millis to SimpleDateFormat
        Calendar calendar = Calendar.getInstance();

        final String uri = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="+minusDays+"&endtime="+currentDay;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JSONArray featuresJsonArray = getJSONObject(result).getJSONArray("features");

        for (Object value : featuresJsonArray) {
            JSONObject jsonObjectValue = (JSONObject) value;
            String properties = jsonObjectValue.get("properties").toString();

            JSONObject propertiesJsonObject = getJSONObject(properties);

            if (propertiesJsonObject.get("place").toString().contains(earthquakeRequest.getCountry())){
                calendar.setTimeInMillis(Long.parseLong(propertiesJsonObject.get("time").toString()));
                earthquakeDtoList.add(createEarthquakeDto(earthquakeRequest, propertiesJsonObject, calendar));
            }
        }
        if (!earthquakeDtoList.isEmpty())
            return earthquakeDtoList;
        else
            throw new NotFoundException("No Earthquakes were recorded past " + earthquakeRequest.getCountofDays() + " days");
    }

    public String getJson(String value){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(value);
    }

    public JSONObject getJSONObject(String value) throws ParseException {
        return new JSONObject((String) new JSONParser().parse(getJson(value)));
    }

    public EarthquakeDto createEarthquakeDto(EarthquakeRequest earthquakeRequest, JSONObject propertiesJsonObject, Calendar calendar){
        return new EarthquakeDto(
                earthquakeRequest.getCountry(),
                propertiesJsonObject.get("place").toString(),
                Double.parseDouble(propertiesJsonObject.get("mag").toString()),
                new SimpleDateFormat().format(calendar.getTime())
        );
    }

}