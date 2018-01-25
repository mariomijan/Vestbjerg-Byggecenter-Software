package gui;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ctrl.BookingCtrl;
import model.Booking;
import model.Invoice;
import model.RoomType;
import net.miginfocom.swing.MigLayout;

public class ChooseDate extends JPanel
{

	public ChooseDate(Booking b, RoomType rt)
	{
		BookingCtrl bCtrl = new BookingCtrl();

		setLayout(new MigLayout("", "[202px][28px][220px]", "[75px][23px][][][][][][][]"));

		/* First Calandar starts here */
		UtilDateModel model = new UtilDateModel();
		model.setDate(12, 05, 2016);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		add(datePicker, "cell 0 0");

		/* Secound Calandar starts here */
		UtilDateModel model1 = new UtilDateModel();
		model.setDate(12, 05, 2016);
		// Need this...
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);

		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());

		add(datePicker1, "cell 2 0");

		// Button Action event
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(e -> {
			this.removeAll();
			this.add(new ChooseRoom(b));
			this.revalidate();
			this.repaint();
		});

		JLabel lblRoomType = new JLabel(rt.getRoomType());
		add(lblRoomType, "cell 0 1");

		add(btnBack, "cell 0 8,alignx right,aligny top");

		JButton btnNext = new JButton("Book Room");
		btnNext.addActionListener(e -> {

			Date selectedDate = (Date) datePicker.getModel().getValue();
			Date selectedDate1 = (Date) datePicker1.getModel().getValue();
			b.setStartDate(selectedDate);
			b.setEndDate(selectedDate1);
			b.setI(bCtrl.createInvoice());
			this.removeAll();
			this.add(new BookingFinish(b));
			this.revalidate();
			this.repaint();
			// bCtrl.createBooking("12-05-2016", "17-05-2016", 5.00, new
			// Invoice(5,2000.00), new Guest());
		});
		add(btnNext, "cell 2 8,alignx left,aligny top");

	}
}
