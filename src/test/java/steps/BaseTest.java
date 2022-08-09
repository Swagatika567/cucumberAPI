package steps;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Header;
import org.testng.annotations.BeforeTest;
import utils.QAEnvProps;
import utils.TestNGListener;

import static io.restassured.RestAssured.given;

public class BaseTest {
    static JSONPObject data;

    @BeforeTest
    public void beforeTest() {
        data = TestNGListener.data;
        RestAssured.baseURI = QAEnvProps.getValue( "baseurl");
        RestAssured.requestSpecification = given().header(new Header("Accept", "application/json")).header(new Header("Content-Type", "application/json"))
                .header(new Header("Authorization", "Bearer "+QAEnvProps.getValue( "token"))).log().all();
        RestAssured.responseSpecification = new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

}
