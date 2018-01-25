package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import CTRL.CustomerCtrl;
import CTRL.ItemCtrl;
import CTRL.OrderCtrl;
import MODEL.Customer;
import MODEL.Item;
import MODEL.Order;

public class AppWindow extends JFrame
{

	/**
	 * Launch the application.***
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AppWindow frame = new AppWindow();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = -6553019126998856092L;
	private CustomerCtrl cCtrl = new CustomerCtrl();
	private ItemCtrl iCtrl = new ItemCtrl();
	private OrderCtrl oCtrl = new OrderCtrl();

	/**
	 * Create the frame.
	 */
	public AppWindow()
	{
		Customer myCustomer = cCtrl.createCustomer("jens", "vej", "2912391", "kajsda@email", 20.00);
		Customer myCustomer1 = cCtrl.createCustomer("Peter", "vej 1", "2313953", "sadf@email", 10.00);
		cCtrl.addCustomer(myCustomer);
		cCtrl.addCustomer(myCustomer1);

		Item myItem = iCtrl.createItem("Hammer", "God kvalitet hammer med en h�rd sl�flade", 20.0, 20, 20, 50);
		Item myItem1 = iCtrl.createItem("Sav", "sav med 7mm savtakker", 40.0, 50, 30, 40);
		Item myItem2 = iCtrl.createItem("skrue", "7tommer skruer", 10, 2000, 1000, 5000);
		iCtrl.addItem(myItem);
		iCtrl.addItem(myItem1);
		iCtrl.addItem(myItem2);

		Order myOrder = oCtrl.createOrder();
		myOrder.setCustomerPhone("2912391");
		myOrder.addPartOrder(oCtrl.createPartOrder(myItem.getName(), 5, 2));
		oCtrl.addOrder(myOrder);

		setTitle("Vestbjerg byggecenter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel customerMenu = new CustomerPanel();
		customerMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Customer Menu", null, customerMenu, null);

		JPanel itemMenu = new ItemPanel();
		itemMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Item Menu", null, itemMenu, null);

		JPanel OrderMenu = new OrderPanel();
		OrderMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Order Menu", null, OrderMenu, null);
	}
}
