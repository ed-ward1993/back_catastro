package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class Util {
    public static ObjectNode createResponse(String mensaje , boolean status) {
        ObjectNode result = Json.newObject();
        result.put("isSuccessful", status);
        result.put("errorMessage", mensaje);
        return result;
    }
}
