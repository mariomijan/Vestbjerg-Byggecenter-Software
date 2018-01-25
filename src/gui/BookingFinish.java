package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Booking;

public class BookingFinish extends JPanel
{
	
	public BookingFinish(Booking b)
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 60, 55, 65, 83, 55, 45, 55, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 13, 14, 14, 14, 14, 155, 23, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnPrintPdf = new JButton("Print");
		btnPrintPdf.addActionListener(e -> 
		{
			new Pdf(b);
		});

		JLabel lblGuestName = new JLabel(b.getG().getName());
		GridBagConstraints gbc_lblGuestName = new GridBagConstraints();
		gbc_lblGuestName.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestName.gridx = 1;
		gbc_lblGuestName.gridy = 0;
		add(lblGuestName, gbc_lblGuestName);

		JLabel lblTotalPrice = new JLabel(Double.toString(b.getI().getTotalPrice()));
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPrice.gridx = 1;
		gbc_lblTotalPrice.gridy = 1;
		add(lblTotalPrice, gbc_lblTotalPrice);

		JLabel lblStartDate = new JLabel(b.getStartDate().toString());
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 1;
		gbc_lblStartDate.gridy = 2;
		add(lblStartDate, gbc_lblStartDate);

		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(e -> {

		});

		JLabel lblEndDate = new JLabel(b.getEndDate().toString());
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate.gridx = 1;
		gbc_lblEndDate.gridy = 3;
		add(lblEndDate, gbc_lblEndDate);

		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		GridBagConstraints gbc_btnSendEmail = new GridBagConstraints();
		gbc_btnSendEmail.insets = new Insets(0, 0, 5, 5);
		gbc_btnSendEmail.gridx = 3;
		gbc_btnSendEmail.gridy = 6;
		add(btnSendEmail, gbc_btnSendEmail);
		GridBagConstraints gbc_btnPrintPdf = new GridBagConstraints();
		gbc_btnPrintPdf.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnPrintPdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrintPdf.gridx = 4;
		gbc_btnPrintPdf.gridy = 6;
		add(btnPrintPdf, gbc_btnPrintPdf);
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(e -> {

		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 5;
		gbc_btnOk.gridy = 6;
		add(btnOk, gbc_btnOk);

		/* Buttons */

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 6;
		gbc_btnBack.gridy = 6;
		add(btnBack, gbc_btnBack);
	}

}
