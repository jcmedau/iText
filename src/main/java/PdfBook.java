import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PdfBook {

   private Document document;
   private PdfPTable leftTable;
   private PdfPTable rightTable;
   private ArrayList<PdfPTable> allPages;

   public PdfBook() throws FileNotFoundException, DocumentException {
      allPages = new ArrayList<>();
      Rectangle pageSize = new Rectangle(920f,503f);
      this.document = new Document(pageSize,12f,12f,12f,12f);
      PdfWriter.getInstance(document, new FileOutputStream("firstTest3.pdf"));
      this.leftTable = new PdfPTable(25);
      leftTable.setTotalWidth(new float[] {54,54,51,51,51,44,21,44,21,44,21,44,21,
            44,21,44,21,44,21,44,21,44,21,21,21}); // total 888
      leftTable.setLockedWidth(true);
      leftTable.setHorizontalAlignment(Element.ALIGN_LEFT);
      this.rightTable = new PdfPTable(23);
      rightTable.setTotalWidth(new float[] {44,21,44,21,44,21,21,21,44,21,44,21,
            44,21,44,21,44,21,44,21,44,21,206}); // total
      rightTable.setLockedWidth(true);
      rightTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
   }

   public void build() throws DocumentException {
      document.open();
      createHeaderLeftPage();
      createFlightLinesLeftPage();
      createTotalsLeftPage();
      document.add(leftTable);
      document.newPage();
      createHeaderRightPage();
      createFlightLinesRightPage();
      createTotalsRightPage();
      document.add(rightTable);
      document.close();
   }

   private void createHeaderLeftPage()  {
      // title line 1
      addCell("YEAR 2024", 3, 1, 18f, BaseColor.WHITE, 9, leftTable);
      addCell("ROUTE OF FLIGHT", 2, 1, 18f, BaseColor.WHITE, 9, leftTable);
      addCell("TOTAL\n DURATION\n OF\n FLIGHT", 2, 2, 18f, BaseColor.WHITE, 7, leftTable);
      addCell("AIRCRAFT CATEGORY AND CLASS", 16, 1, 18f, BaseColor.WHITE, 9, leftTable);
      addCell("LNDGS", 2, 1, 18f, BaseColor.WHITE, 9, leftTable);

      // title line 2
      addCell("DATE", 1, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("Aircraft\nMAKE AND\n MODEL", 1, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("Aircraft IDENT", 1, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("FROM", 1, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("TO", 1, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("SEL", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("SES", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("MEL", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("MES", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("HELI", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("GLIDER", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 36f, BaseColor.WHITE, 7, leftTable);
      addCell("D\nA\nY", 1, 1, 36f, BaseColor.WHITE, 6, leftTable);
      addCell("N\nI\nG\nH\nT", 1, 1, 36f, BaseColor.WHITE, 6, leftTable);
   }

   private void createHeaderRightPage() {
      // title line 1
      addCell("CONDITIONS OF FLIGHT", 8, 1, 18f, BaseColor.WHITE, 9, rightTable);
      addCell("FLIGHT\nSIMULATOR", 2, 3, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("TYPE OF PILOTING TIME", 12, 1, 18f, BaseColor.WHITE, 9, rightTable);
      addCell("REMARKS\nAND\nENDORSEMENTS", 1, 3, 18f, BaseColor.WHITE, 9, rightTable);

      // title line 2
      addCell("NIGHT", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("ACTUAL\nINSTRUMENT", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("SIMULATED\nINSTRUMENT\n(HOOD)", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("APP", 2, 1, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("CROSS\nCOUNTRY", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("SOLO", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("PILOT\nIN\nCOMMAND", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("SECOND\nIN\nCOMMAND", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("DUAL\nRECEIVED", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("AS\nFLIGHT\nINSTRUCTOR", 2, 2, 18f, BaseColor.WHITE, 7, rightTable);

      // title line 3
      addCell("NO", 1, 1, 18f, BaseColor.WHITE, 7, rightTable);
      addCell("TYPE", 1, 1, 18f, BaseColor.WHITE, 6, rightTable);
   }

   private void createFlightLinesLeftPage() {
      int numberOfRows = 13;
      for (int i = 0; i < numberOfRows; i++) {
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, leftTable);
      }
   }

   private void createFlightLinesRightPage() {
      int numberOfRows = 13;
      for (int i = 0; i < numberOfRows; i++) {
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.LIGHT_GRAY, 7, rightTable);
         addCell(" ", 1, 1, 25f, BaseColor.WHITE, 7, rightTable);
      }
   }

   private void createTotalsLeftPage() {
      Font pageNumberFont = FontFactory.getFont(FontFactory.HELVETICA, 6, BaseColor.BLACK);
      Phrase word = new Phrase("Page number",pageNumberFont);
      PdfPCell cell = new PdfPCell(word);
      cell.setColspan(3);
      cell.setRowspan(3);
      cell.setHorizontalAlignment(Element.ALIGN_LEFT);
      cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
      leftTable.addCell(cell);

      addCell("TOTAL THIS PAGE", 2, 1, 27f, BaseColor.WHITE, 9, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 1, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 1, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell("AMT FORWARDED", 2, 1, 27f, BaseColor.WHITE, 9, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 1, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 1, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell("TOTALS TO DATE", 2, 1, 27f, BaseColor.WHITE, 9, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, leftTable);
      addCell(" ", 1, 1, 27f, BaseColor.WHITE, 7, leftTable);
      addCell(" ", 1, 1, 27f, BaseColor.WHITE, 7, leftTable);
   }

   private void createTotalsRightPage() {
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7,rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);

      Font statementFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8, BaseColor.BLACK);
      Phrase word = new Phrase("I certify that the entries in this logbook are correct."
            +"\n\n\n\n\nLogbook Owner Name",statementFont);
      PdfPCell cell = new PdfPCell(word);
      cell.setRowspan(3);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      rightTable.addCell(cell);

      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7,rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);

      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7,rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.WHITE, 7, rightTable);
      addCell(" ", 2, 1, 27f, BaseColor.LIGHT_GRAY, 7, rightTable);
   }

   private void addCell(String text, int colSpan, int rowSpan,
                        float rowHeight, BaseColor background, int fontSize, PdfPTable table) {
      Font font = new Font(Font.FontFamily.HELVETICA, fontSize, Font.BOLD, BaseColor.BLACK);
      PdfPCell cell = new PdfPCell(new Phrase(text,font));
      cell.setColspan(colSpan);
      cell.setRowspan(rowSpan);
      cell.setFixedHeight(rowHeight);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setBackgroundColor(background);
      table.addCell(cell);
   }
}
