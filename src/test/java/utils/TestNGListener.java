package utils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Header;
import org.testng.ITestContext;
import org.testng.ITestListener;

import static io.restassured.RestAssured.given;

public class TestNGListener implements ITestListener {

    public static JSONPObject data;

    @Override
    public void onStart(ITestContext context) {
        data = JsonInputParser.inputDataInit();
        QAEnvProps.init();
        data = TestNGListener.data;
        RestAssured.baseURI = QAEnvProps.getValue("baseurl");
        RestAssured.requestSpecification = given().header(new Header("Accept", "application/json"))
                .header(new Header("Content-Type", "application/json"))
                .header(new Header("Authorization", "Bearer" + QAEnvProps.getValue("token"))).log().all();
        RestAssured.responseSpecification = new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

}

