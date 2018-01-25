package GUI;

import java.io.FileOutputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import CTRL.CustomerCtrl;
import MODEL.Order;
import MODEL.PartOrder;

public class Pdf
{
	private static String FILE;
	private static Font title = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD);
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private Order order;
	private Double totalPrice = 0.00;

	private CustomerCtrl cCtrl = new CustomerCtrl();

	public Pdf(Order order)
	{
		{
			try
			{
				this.order = order;
				Paragraph preface = new Paragraph();
				FILE = System.getProperty("user.dir") + "/OrderPdf/";
				String realFile = FILE.replace('\\', '/');
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(realFile + "Order" + order.getId() + ".pdf"));
				document.open();
				addMetaData(document);
				PdfPTable pdfTable = createTable(document);
				addTitlePage(document);
				
				document.add(crateInformationTable());
				
				document.add(addOrderId());
				
				document.add(pdfTable);
				
				
				addEmptyLine(preface,1);
				
				document.add(preface);
				
				document.add(addTotalPrice());
				
				document.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void addMetaData(Document document)
	{
		document.addTitle("Order Print");
		document.addAuthor("Vestbjerg");
		document.addCreator("Vestbjerg");
	}

	private void addTitlePage(Document document) throws DocumentException
	{
		
		/* Creates the title of the page*/
		Paragraph textTitle = new Paragraph();

		textTitle.setSpacingAfter(25);
		textTitle.setSpacingBefore(25);
		textTitle.setAlignment(Element.ALIGN_MIDDLE);
		textTitle.setIndentationLeft(50);
		textTitle.setIndentationRight(50);
		textTitle.add(new Paragraph("Vestbjerg Byggecenter ApS", title));
		document.add(textTitle);
		

	}
	
	public Paragraph addOrderId()
	{
		Paragraph preface = new Paragraph();

		preface.add(new Paragraph("Ordernr: " + order.getId(), catFont));
		addEmptyLine(preface, 1);
				
		return preface;

	}
	
	public PdfPTable addTotalPrice()
	{
		PdfPTable table = new PdfPTable(3);
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		table.setWidthPercentage(100);
		table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell("Total Price: " + df.format(totalPrice) + "DKK", PdfPCell.ALIGN_RIGHT));
		return table;
	}

	public PdfPTable createTable(Document document) throws DocumentException
	{
		float[] columnWidths = { 2, 2, 2, 2 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);

		table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
		table.addCell("Item Name");
		table.addCell("Quantity");
		table.addCell("Discount");
		table.addCell("Part Total");
		table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		

		table.setHeaderRows(1);
		table.setFooterRows(0);

		for (PartOrder po : order.getPartorders())
		{
			table.addCell(po.getItemName());
			table.addCell(Integer.toString(po.getQuantity()));
			table.addCell(Double.toString(po.getDiscount()));
			table.addCell(Double.toString(po.getPartTotal() - (po.getPartTotal() / 100.0 * po.getDiscount())));
			totalPrice += po.getPartTotal() - (po.getPartTotal() / 100.0 * po.getDiscount());
		}
		return table;
	}

	public PdfPTable crateInformationTable()
	{
		String name = cCtrl.findCustomer(order.getCustomerPhone()).getName();
		String address = cCtrl.findCustomer(order.getCustomerPhone()).getAddress();
		String phone = cCtrl.findCustomer(order.getCustomerPhone()).getPhone();
		String email = cCtrl.findCustomer(order.getCustomerPhone()).getEmail();

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100);

		table.addCell(getCell("Company Information:", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell("Customer Information:", PdfPCell.ALIGN_RIGHT));
		
		table.addCell(getCell("Vestbjerg Byggecenter", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(name, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("Sofiendalsvej 60", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(address, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("9000 Aalborg", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(phone, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("Denmark", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(email, PdfPCell.ALIGN_RIGHT));
		
		table.addCell(getCell("__________________________", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("__________________________", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell("__________________________", PdfPCell.ALIGN_RIGHT));
		return table;

	}

	public PdfPCell getCell(String text, int alignment)
	{
		PdfPCell cell = new PdfPCell(new Phrase(text));
		cell.setPadding(0);
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	private void addEmptyLine(Paragraph paragraph, int number)
	{
		for (int i = 0; i < number; i++)
		{
			paragraph.add(new Paragraph(" "));
		}
	}

}
