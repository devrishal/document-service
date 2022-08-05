package com.rds.barcodegen.service;

import com.rds.barcodegen.repository.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.output.bitmap.BitmapEncoder;
import org.krysalis.barcode4j.output.bitmap.BitmapEncoderRegistry;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final CarSpecification carSpecification;

    public void downloadDocument(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject barcodeImage = PDImageXObject.createFromByteArray(document, generateCode39(), "bmp");
        contentStream.drawImage(barcodeImage, 100f, 600f);
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("I am always good pdf");
        contentStream.endText();
        contentStream.close();

        document.save(response.getOutputStream());
        document.close();
    }

    private byte[] generateCode39() throws IOException {
        Code39Bean barcodeGenerator = new Code39Bean();
        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(600, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        BarcodeDimension barcodeDimension = new BarcodeDimension(200, 50);
        canvas.establishDimensions(barcodeDimension);
        barcodeGenerator.generateBarcode(canvas, "barcodeText");
        BufferedImage barcodeImage = canvas.getBufferedImage();
        BitmapEncoder encoder = BitmapEncoderRegistry.getInstance("bmp");
        //encoder.encode(canvas.getBufferedImage(), os, mime, dpi);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(barcodeImage, "bmp", baos);
        return baos.toByteArray();
    }

    public void callDB() {
        carSpecification.getQuery();
    }
}
