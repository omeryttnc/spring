package spring.selenium.demo.test.suite2;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import spring.selenium.demo.pojos.User2Pojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class postDeneme {

    @Value("${token}")
    String token;


    Response response;
    String endpoint = "https://gorest.co.in/public-api/users/";
    Map<String,Object> myPostData = new HashMap<>();
    JsonPath jsonPath;

    public void postMethod(Object body){
        response = given().contentType(ContentType.JSON).auth().oauth2(token).body(body).when().post(endpoint);
        response.prettyPrint();
    }

    //@Test
    public void get(){
        response = given().when().get(endpoint);
        response.prettyPrint();
    }
    //@Test
    public void post1(){
        String body = "{\n" +
                "        \"name\": \"samet\",\n" +
                "        \"email\": \"sa6262eaqet@sdfs\",\n" +
                "        \"gender\": \"Male\",\n" +
                "        \"status\": \"Active\"\n" +
                "    }";
        response = given().contentType(ContentType.JSON).auth().oauth2(token).body(body).when().post(endpoint);
        response.prettyPrint();
    }
    //@Test
    public void post2(){
        myPostData.put("name","cengiz");
        myPostData.put("email","kerfli@gmail.com");
        myPostData.put("gender","Male");
        myPostData.put("status","Active");
        postMethod(myPostData);
        jsonPath = response.jsonPath();
//        String myResponseData = jsonPath.getString("data.name");
//        System.out.println(myResponseData);
        System.out.println(jsonPath.getString("data.field"));
        System.out.println(jsonPath.getString("data.message"));
    }
    //@Test
    public void post3(){
        User2Pojo object = new User2Pojo(true,"mead@gmail.com","Female","Active");
        //User2Pojo object2 = new User2Pojo(9999);
        postMethod(object);
        jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("data.name"),"9999");
    }
   // @Test
    public void post4(){
        User2Pojo object3 = new User2Pojo();
        object3.setEmail("samet@gmail.com");
        object3.setStatus("Inactive");
        object3.setName(true);
        object3.setGender("956");
        postMethod(object3);
    }




}


