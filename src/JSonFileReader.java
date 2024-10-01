import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JSonFileReader implements BookReader{

    @Override
    public List<Book> readBooks(String Filepath) throws  DatabindException {
        ArrayList<Book> books = new ArrayList<Book>();
        ObjectMapper objMapper= new ObjectMapper();
        try {
            List<Map<String, Object>> bookList= objMapper.readValue(new File(Filepath),List.class);
            for (Map<String, Object> item : bookList) {
                String title = (String) item.get("title");
                String author = (String) item.get("author");
                String genre = (String) item.get("genre");
                int pages = (int) item.get("pages");
                String date_Read = (String) item.get("date_read");

                books.add(new Book(title, author, genre, pages, date_Read));
            }
            return books;
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
