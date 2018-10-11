/*
 * Author: Brittanie Pham
 * A06 Red Counter
 * CSIS 1410
 */

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

/**
 * public class RedCounter is a Jframe that makes a GUI
 * @author Brittanie Pham
 *
 */
public class RedCounter extends JFrame {

	private JPanel contentPane;
	private ArrayList<Color> colors = new ArrayList<>();
	private int counter;
	private JLabel lblNewLabel;

	/**
	 * Launches the application.
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
	 * Constructor that creates the frame
	 */
	public RedCounter() {
		makeWindow();
		brittsGuiLabel();
		makeCounterLabel();
		possibleColors();
		JButton btnNewButton = makeButton();
		buttonEventHandler(btnNewButton);
	}

	/**
	 * button with an event handler on click that changes the color of the button's background every time
	 * the button also changes the Red Counter label with the 
	 * amount of times the color red appears.
	 * @param btnNewButton
	 */
	private void buttonEventHandler(JButton btnNewButton) {
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

	/**
	 * creation of JButton and styling of the button by
	 * setting font, background, foreground, opaqueness, and border
	 * @return button created
	 */
	private JButton makeButton() {
		JButton btnNewButton = new JButton("Click Me");
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorder(new EmptyBorder(0, 70, 0, 70));
		contentPane.add(btnNewButton, BorderLayout.EAST);
		return btnNewButton;
	}

	/**
	 * adds all possible color options in an ArrayList for the button (btnNewButton) to be able to change to
	 */
	private void possibleColors() {
		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.GREEN);
		colors.add(Color.ORANGE);
		colors.add(Color.MAGENTA);
	}

	/**
	 * creates a JLabel that displays the amount of times the color red appears on the button
	 * label gets set to opaque, changes background to gray, gets a new font, and border change.
	 */
	private void makeCounterLabel() {
		lblNewLabel = new JLabel("Red Counter: " + counter);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblNewLabel.setBorder(new EmptyBorder(0, 50, 0, 50));
		contentPane.add(lblNewLabel, BorderLayout.WEST);
	}

	/**
	 * creates a new JLabel that gets set to the center, has padding on its borders added, and changes the font. 
	 * This label gets put in the south of Border Layout
	 */
	private void brittsGuiLabel() {
		JLabel lblBrittaniesGui = new JLabel("Brittanie's GUI");
		lblBrittaniesGui.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrittaniesGui.setBorder(new EmptyBorder(7, 0, 7, 0));
		lblBrittaniesGui.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblBrittaniesGui, BorderLayout.SOUTH);
	}

	/**
	 * creates a JPanel with a border, a preferredSize, and sets a layout
	 */
	private void makeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}
