package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateGuestOriginUi extends JPanel
{

	/**
	 * Create the panel.
	 */
	public CreateGuestOriginUi()
	{
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener( e -> {
			
		});
		panel_1.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener( e -> {
			this.removeAll();
			this.add( new GuestOriginUi());
			this.revalidate();
			this.repaint();
		}
		);
		panel_1.add(btnBack);

	}

}
