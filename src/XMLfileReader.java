import com.fasterxml.jackson.databind.DatabindException;

import java.io.FileReader;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;

public class XMLfileReader implements BookReader {

    @Override
    public List<Book> readBooks(String Filepath) throws Exception, DatabindException {
        List<Book> books = new ArrayList<>();
        File xmlFile = new File(Filepath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        NodeList nodeList = doc.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String genre = element.getElementsByTagName("genre").item(0).getTextContent();
                int pages = Integer.parseInt(element.getElementsByTagName("pages").item(0).getTextContent());
                String date_read= element.getElementsByTagName("date_read").item(0).getTextContent();

                books.add(new Book(title, author, genre, pages, date_read));
            }

        }
        return books;
    }
}
