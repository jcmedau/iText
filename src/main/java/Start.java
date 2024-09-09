import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

public class Start {
   public static void main(String[] args) throws DocumentException, FileNotFoundException {
      PdfBook book = new PdfBook();
      try {
         book.build();
      } catch (Exception e) {

      }
   }
}
