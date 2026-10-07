package com.rami.shop.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rami.shop.models.SignupData;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class TestDataProviders {

    @DataProvider(name= "signupDataProvider")
    public static Object[][] getSignupData(){
        try {
            InputStream inputStream = TestDataProviders.class.getClassLoader()
                    .getResourceAsStream("testdata/signup_data.json");

            if (inputStream == null) {
                throw new RuntimeException("Could not find testdata/signup_data.json");
            }
            String jsonContent = new String(inputStream.readAllBytes());

            Gson gson = new Gson();

            Type listType = new TypeToken<List<SignupData>>(){}.getType();

            List<SignupData> dataList = gson.fromJson(jsonContent, listType);

            Object[][] result = new Object[dataList.size()][1];
            for  (int i = 0; i < dataList.size(); i++){
                result[i][0] = dataList.get(i);
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data from JSON", e);
        }
    }




}
