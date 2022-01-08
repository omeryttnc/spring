package spring.selenium.demo.test.suite2;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import spring.selenium.demo.config.TestResultLoggerExtension;
import spring.selenium.demo.util.ReusableMethods;

import static io.restassured.RestAssured.given;

@SpringBootTest
@Epic("EP001")
@Story("US002")
@ExtendWith(TestResultLoggerExtension.class)
public class US_04_Test_DeleteTest {
    @Value("${token}")
    private String token;
    @Value("${end_point}")
    private String endPoint;

    Response response;

    JsonPath jsonPath;


    public void deleteMethod(int queryId){
        response = given().contentType(ContentType.JSON).auth().oauth2(token).when().delete(endPoint +queryId);
        response.prettyPrint();
    }
    public void getMethod(int queryId){
        response = given().accept(ContentType.JSON).when().get(endPoint +queryId);
        response.prettyPrint();
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    public void TC0301(){
        response = given().accept(ContentType.JSON).when().get(endPoint);
        jsonPath = response.jsonPath();
        int sizeOfData = jsonPath.getInt("meta.pagination.total");
        int deletedId = ReusableMethods.randomInteger(sizeOfData);
        deleteMethod(deletedId);
        jsonPath = response.jsonPath();
        Assertions.assertNull(jsonPath.getString("data"));
        Assertions.assertNull(jsonPath.getString("meta"));
        Assertions.assertEquals(jsonPath.getInt("code"),204);
        getMethod(deletedId);
        jsonPath = response.jsonPath();
        //Assertions.assertEquals(jsonPath.getString("data.message"),"Resource not found");

    }
}
