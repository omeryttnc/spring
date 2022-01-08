package spring.selenium.demo.pojos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;



@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "name",
        "email",
        "gender",
        "status"
})
public class User2Pojo {

    @JsonProperty("name")
    private Object name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("status")
    private String status;


    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public User2Pojo(){
    }

    public User2Pojo(Object name,String email,String gender,String status){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
    public User2Pojo(Object name){
        this.name = name;
    }
    public User2Pojo(Object name, String email){
        this.name = name;
        this.email = email;
    }
    public User2Pojo(Object name,String email,String gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User2Pojo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
