import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVfileReader implements BookReader{

    @Override
    public List<Book> readBooks(String Filepath) throws IOException {
        List<Book> books = new ArrayList<Book>();
        try(BufferedReader br = new BufferedReader(new FileReader(Filepath))) {
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(",");
                String title = data[0];
                String author = data[1];
                String genre = data[2];
                int pages = Integer.parseInt(data[2]);
                String date = data[3];
                books.add(new Book(title, author, genre, pages, date));
            }
        }
        return books;
    }
}
