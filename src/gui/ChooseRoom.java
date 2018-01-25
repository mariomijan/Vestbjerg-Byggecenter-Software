package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ctrl.BookingCtrl;
import model.Booking;
import model.RoomType;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;

public class ChooseRoom extends JPanel {
	private BookingCtrl bCtrl;
	private JComboBox comboBox;
	public ChooseRoom(Booking b){
		bCtrl = new BookingCtrl();
		setLayout(new MigLayout("", "[202px][28px][220px]", "[75px][23px]"));
		
		JLabel lblTitle = new JLabel("Choose a room");
		add(lblTitle, "flowy,cell 0 0 3 1,grow");
		//Get all the Room Types from the database here TODO
		//Add it to the combobox
				
		
		//Creates and fills the combobox withRommTypes
		comboBox = new JComboBox(getRoomTypeStrings());
		
		
		//comboBox.setToolTipText();
		add(comboBox, "cell 0 0");
				
		
		JButton btnBack = new JButton("back");
		//btn action event
		btnBack.addActionListener(e -> {
			changeFrame(new CreateGuestUi(b));
		});
		add(btnBack, "cell 0 1,alignx right,aligny top");
		
		
		JButton btnNext = new JButton("Next ->");
		//btn action event
		btnNext.addActionListener(e -> {
			
			changeFrame(new ChooseDate(b,comboBoxValue()));
			
			
		});
		add(btnNext, "cell 2 1,alignx left,aligny top");
	}

	//Returns the RoomType of the chosen dropdown item
	private RoomType comboBoxValue() {
		RoomType o1 = (RoomType) comboBox.getSelectedItem();
		
		
		return o1;
		
	}

	// Changes the current panel with a new one
	//TODO make a external class with this function and reuse it
	private void changeFrame(JPanel jpanel) {
		this.removeAll();
		this.add(jpanel);
		this.revalidate();
		this.repaint();
	}

	// Place this method in the Controller??? TODO
	//TODO Rename
	//Gets the list of roomTypes and returns it as a String[]
	private RoomType[] getRoomTypeStrings() {
		return bCtrl.getAllRoomTypes().stream().toArray(RoomType[]::new);
	}
}
