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
public class MailPojo {
    @JsonProperty("subTotal")
    private String subTotal;
    @JsonProperty("deliveryCost")
    private String deliveryCost;
    @JsonProperty("date")
    private String date;
    @JsonProperty("sellerName")
    private String sellerName;
    @JsonProperty("e_eventName")
    private String e_eventName;
    @JsonProperty("e_date_and_time")
    private String e_date_and_time;
    @JsonProperty("e_event_duration")
    private String e_event_duration;
    @JsonProperty("e_max_number_of_attendees")
    private String e_max_number_of_attendees;
    @JsonProperty("hopeToSeeYouMessage")
    private String hopeToSeeYouMessage;
    @JsonProperty("successMessage")
    private String successMessage;

    // successMessage ve hopeToSeeYouMessage Abdullah tarafindan eklendi
    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getHopeToSeeYouMessage() {
        return hopeToSeeYouMessage;
    }

    public void setHopeToSeeYouMessage(String hopeToSeeYouMessage) {
        this.hopeToSeeYouMessage = hopeToSeeYouMessage;
    }


    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getE_eventName() {
        return e_eventName;
    }

    public void setE_eventName(String e_eventName) {
        this.e_eventName = e_eventName;
    }

    public String getE_date_and_time() {
        return e_date_and_time;
    }

    public void setE_date_and_time(String e_date_and_time) {
        this.e_date_and_time = e_date_and_time;
    }

    public String getE_event_duration() {
        return e_event_duration;
    }

    public void setE_event_duration(String e_event_duration) {
        this.e_event_duration = e_event_duration;
    }

    public String getE_max_number_of_attendees() {
        return e_max_number_of_attendees;
    }

    public void setE_max_number_of_attendees(String e_max_number_of_attendees) {
        this.e_max_number_of_attendees = e_max_number_of_attendees;
    }
}
