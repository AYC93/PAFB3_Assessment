package ibf2022.assessment.paf.batch3.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Order {
    private int beerId;
    private int quantity;

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order() {
    }

    public Order(int beerId, int quantity) {
        this.beerId = beerId;
        this.quantity = quantity;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("beerId", beerId)
                .add("quantity", quantity)
                .build();
    }
}
