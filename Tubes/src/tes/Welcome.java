package tes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Welcome {
	public JFrame frame;
	public JTable JTabel_Display_User;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome welcomeWindow = new Welcome();
					welcomeWindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ayo Ke Posyandu!");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 466, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPasienBaru = new JButton("");
		btnPasienBaru.setBounds(148, 112, 180, 54);
		frame.getContentPane().add(btnPasienBaru);
		btnPasienBaru.setOpaque(false);
		btnPasienBaru.setContentAreaFilled(false);
		btnPasienBaru.setBorderPainted(false);
		btnPasienBaru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataPasienBaru window = new DataPasienBaru();
				window.frame.setVisible(true);
				window.button.setEnabled(true);
//				window.button_4.setEnabled(true);
				frame.dispose();
			}
		});
		btnPasienBaru.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnPasienLama = new JButton("");
		btnPasienLama.setBounds(148, 167, 180, 47);
		frame.getContentPane().add(btnPasienLama);
		btnPasienLama.setOpaque(false);
		btnPasienLama.setContentAreaFilled(false);
		btnPasienLama.setBorderPainted(false);
		btnPasienLama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasienLama lamaWindow= new PasienLama();
				lamaWindow.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnPasienLama.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 466, 361);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("E:\\KULIAH MILA\\SEMESTER 3\\OOP\\tubes\\SC\\BackGround.png"));
	}
}
