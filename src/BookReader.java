import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.List;

public interface BookReader {
     List<Book> readBooks(String Filepath) throws Exception, DatabindException;
}
