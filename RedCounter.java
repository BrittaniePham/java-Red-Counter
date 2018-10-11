package a06_red_counter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class RedCounter extends JFrame {

	private JPanel contentPane;
	private ArrayList<Color> colors = new ArrayList<>();
	private int counter;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedCounter frame = new RedCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RedCounter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBrittaniesGui = new JLabel("Brittanie's GUI");
		lblBrittaniesGui.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrittaniesGui.setBorder(new EmptyBorder(7, 0, 7, 0));
		lblBrittaniesGui.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblBrittaniesGui, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Red Counter: " + counter);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblNewLabel.setBorder(new EmptyBorder(0, 50, 0, 50));
		contentPane.add(lblNewLabel, BorderLayout.WEST);
		
		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.GREEN);
		colors.add(Color.ORANGE);
		colors.add(Color.MAGENTA);
		
		JButton btnNewButton = new JButton("Click Me");
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorder(new EmptyBorder(0, 70, 0, 70));
		contentPane.add(btnNewButton, BorderLayout.EAST);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int num = rand.nextInt(5);
				Color color = colors.get(num);
				while(color.equals(btnNewButton.getBackground())) {
					num = rand.nextInt(5);
					color = colors.get(num);
				}
				btnNewButton.setBackground(color);
				if(color.equals(Color.RED)) {
					counter++;
					lblNewLabel.setText("Red Counter: " + counter);
				}
			}
		});
	}
}
