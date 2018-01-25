package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;

public class MainUi extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2176293357931831077L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainUi frame = new MainUi();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainUi()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		setTitle("Marokko holiday center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		
		JPanel bookingMenu = new CreateGuestUi(null);
		bookingMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Book Menu", null, bookingMenu, null);
		
		JPanel guestOriginMenu = new GuestOriginUi();
		guestOriginMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Guest Origin Menu", null, guestOriginMenu, null);
		

		JPanel loginMenu = new LoginUi();
		loginMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Login", null, loginMenu, null);
		
		setContentPane(contentPane);
		
		
	}

}
