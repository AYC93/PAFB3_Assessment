package ibf2022.assessment.paf.batch3.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Orders {
    private int orderId;
    private LocalDate date;
    private int breweryId;
    private List<Orders> orders;
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getBreweryId() {
        return breweryId;
    }
    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }
    public List<Orders> getOrders() {
        return orders;
    }
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    public Orders() {
    }
    public Orders(int orderId, LocalDate date, int breweryId, List<Orders> orders) {
        this.orderId = orderId;
        this.date = date;
        this.breweryId = breweryId;
        this.orders = orders;
    }

    public JsonObject toJson(){
        JsonObjectBuilder jObj = Json.createObjectBuilder()
                                .add("orderId", UUID.randomUUID().toString()
                                                    .substring(0, 8))
                                .add("date", LocalDate.now().toString())
                                .add("breweryId", getBreweryId());
		if(orders.isEmpty()){
            jObj.build();
        }else{
        JsonArrayBuilder ab = Json.createArrayBuilder();
        for(Orders o : orders)
            ab.add(o.toJson());
        jObj.add("orders", ab);
	    }
        return jObj.build();	
    }

    public Document toDocument(){
        return Document.parse(toJson().toString());
    }

}
