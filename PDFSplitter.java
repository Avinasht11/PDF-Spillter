import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class PDFSplitter {

    public static void main(String[] args) {
        try {
            // Load the PDF file
            PDDocument document = PDDocument.load(new File("input.pdf"));

            // Get the total number of pages in the PDF
            int pageCount = document.getNumberOfPages();

            for (int i = 0; i < pageCount; i++) {
                // Create a new document for each page
                PDDocument newDocument = new PDDocument();
                
                // Get the specific page from the original document
                PDPage page = document.getPage(i);
                
                // Add the page to the new document
                newDocument.addPage(page);
                
                // Save the new document with the page
                newDocument.save("page_" + (i + 1) + ".pdf");
                
                // Close the new document
                newDocument.close();
            }

            // Close the original document
            document.close();

            System.out.println("PDF has been split into individual pages.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
