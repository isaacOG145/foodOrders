package utez.edu.mx.foodOrders.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DoubleLinkedListSerializer extends JsonSerializer<DoubleLinkedList<Food>> {

    @Override
    public void serialize(DoubleLinkedList<Food> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (int i = 0; i < value.size(); i++) {
            Food food = value.get(i);
            gen.writeObject(food);
        }
        gen.writeEndArray();
    }
}
