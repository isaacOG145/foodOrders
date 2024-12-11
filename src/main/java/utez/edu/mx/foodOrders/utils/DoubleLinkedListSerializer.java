package utez.edu.mx.foodOrders.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import utez.edu.mx.foodOrders.order.model.FoodDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedListSerializer extends JsonSerializer<DoubleLinkedList<Food>> {

    @Override
    public void serialize(DoubleLinkedList<Food> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        List<FoodDTO> foodDTOs = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            Food food = value.get(i);
            foodDTOs.add(new FoodDTO(food.name(), food.getPrice()));
        }

        gen.writeObject(foodDTOs);
    }
}
