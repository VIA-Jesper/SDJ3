package main.java.object_transfer_socket_java_to_java_to_csharp.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Converter {

    public static Student convertJsonToStudent(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, Student.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertStudentToJson(Student student) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertBytesToString(byte[] bytes, int length) {
        String message = new String(bytes, 0, length);
        return message;
    }


    public static byte[] integerToBytes(int length) {
        byte[] lengthBytes = new byte[4];
        lengthBytes[0] = (byte)(length & 0xff);
        lengthBytes[1] = (byte)((length >> 8) & 0xff);
        lengthBytes[2] = (byte)((length >> 16) & 0xff);
        lengthBytes[3] = (byte)((length >> 24) & 0xff);
        return lengthBytes;
    }

    public static int lengthBytesToInteger(byte[] lengthBytes) {
        int length = (((lengthBytes[3] & 0xff) << 24) | ((lengthBytes[2] & 0xff) << 16) | ((lengthBytes[1] & 0xff) << 8) | (lengthBytes[0] & 0xff));
        return length;
    }

}
