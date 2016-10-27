/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.controllers;

import com.ipn.model.beans.Carrito;
import com.ipn.model.beans.Producto;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class GeneradorTicket {
    private static String FILE = "C:\\Users\\Alejandro\\Documents\\ticket.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private Document document;
    private Carrito carrito;

    public GeneradorTicket(Carrito c) {
        this.carrito = c;
    }
    
    public void generarTicket(){
         try {
                        document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        addMetaData();
                        addContent();
                        document.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
    }
    private void addMetaData() {
                document.addTitle("My first PDF");
                document.addSubject("Using iText");
                document.addKeywords("Java, PDF, iText");
                document.addAuthor("Lars Vogel");
                document.addCreator("Lars Vogel");
        }

        private void addContent() throws DocumentException
                        {
                Paragraph preface = new Paragraph();
                // We add one empty line
                addEmptyLine(preface, 2);
                // Lets write a big header
                preface.add(new Paragraph("Ticket de compra", catFont));
                addEmptyLine(preface, 2);
                document.add(preface);
                document.add(this.createTable());
                preface = new Paragraph();
                addEmptyLine(preface, 2);
                // Will create: Report generated by: _name, _date
                preface.add(new Paragraph(
                                "Fecha de compra: " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                smallBold));
                
                document.add(preface);
                
        }

       

        private  PdfPTable createTable()
                        throws BadElementException {
                PdfPTable table = new PdfPTable(4);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("Producto"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Cantidad"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Costo"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Total"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
        //add cell for product
        for (Producto producto : this.carrito.getProductos()) {
            table.addCell(producto.getNombre());
            table.addCell(String.valueOf(this.carrito.getDic().get(producto.getId())));
            table.addCell(String.valueOf(producto.getPrecio()));
            table.addCell(String.valueOf( producto.getPrecio()*this.carrito.getDic().get(producto.getId()) ));
        }
               table.addCell("Total");
               table.addCell(" ");
               table.addCell(" ");
               table.addCell( String.valueOf( this.carrito.getTotal() ) );

                return table;

        }

  
        private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
        }

    
}