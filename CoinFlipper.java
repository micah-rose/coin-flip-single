/*********************************
 * Author: Micah L
 * Midterm Code Part 2 - CSIS 1410
 **********************************/

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.util.Random;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class CoinFlipper extends JFrame 
{
	/**
	 * private fields for GUI
	 */
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
					CoinFlipper frame = new CoinFlipper();
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
	public CoinFlipper() 
	{
		setTitle("Coin Flipper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCoin = new JLabel("");
		lblCoin.setIcon(new ImageIcon(CoinFlipper.class.getResource("/gui/heads.png")));
		lblCoin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCoin, BorderLayout.CENTER);
		
		/**
		 * Create Heads radio button
		 */
		JRadioButton rdbtnHeads = new JRadioButton("Heads");
		rdbtnHeads.setBackground(Color.WHITE);
		rdbtnHeads.setSelected(true);
		rdbtnHeads.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnHeads.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(rdbtnHeads.isSelected()) lblCoin.setIcon(new ImageIcon(CoinFlipper.class.getResource("/gui/heads.png")));
			}
		});
		buttonGroup.add(rdbtnHeads);
		panel.add(rdbtnHeads);
		
		/**
		 * Create Tails radio button
		 */
		JRadioButton rdbtnTails = new JRadioButton("Tails");
		rdbtnTails.setBackground(Color.WHITE);
		rdbtnTails.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnTails.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(rdbtnTails.isSelected()) lblCoin.setIcon(new ImageIcon(CoinFlipper.class.getResource("/gui/tails.png")));
			}
		});
		
		buttonGroup.add(rdbtnTails);
		panel.add(rdbtnTails);
		
		/**
		 * Create Random radio button
		 */
		JRadioButton rdbtnRandom = new JRadioButton("Random");
		rdbtnRandom.setOpaque(true);
		rdbtnRandom.setBackground(Color.WHITE);
		rdbtnRandom.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnRandom.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e)  
			{
				Random rand = new Random();
				int flip = rand.nextInt(2);
				
				if(flip == 0) lblCoin.setIcon(new ImageIcon(CoinFlipper.class.getResource("/gui/heads.png")));
				if(flip == 1) lblCoin.setIcon(new ImageIcon(CoinFlipper.class.getResource("/gui/tails.png")));				
			}
		});
		buttonGroup.add(rdbtnRandom);
		panel.add(rdbtnRandom);		
	}
}