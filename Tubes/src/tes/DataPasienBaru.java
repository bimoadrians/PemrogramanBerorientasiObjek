package tes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DataPasienBaru {

	public JFrame frame;
	public JTextField namaTF;
	public JTextField alamatTF;
	public JTextField ttlTF;
	public JTextField usiaTF;
	public JTextField namaIbuTF;
	public String checkA = "Belum";
	public String checkBcg = "Belum";
	public String checkPolio1 = "Belum";
	public String checkPolio2 = "Belum";
	public String checkPolio3="Belum";
	public String checkPolio4="Belum";
	public String checkCampak="Belum";
	public JButton button, btnUpdate, btnTutup, btnClose;
	public boolean stVit=false;
	public boolean stBCG=false;
	public boolean stPolio1=false;
	public boolean stPolio2=false;
	public boolean stPolio3=false;
	public boolean stPolio4=false;
	public boolean stCampak=false;
	public String tglVitA="";
	public String tglBCG="";
	public String tglPolio1="";
	public String tglPolio2="";
	public String tglPolio3="";
	public String tglPolio4="";
	public String tglCampak="";
	public String tinggiJan="";
	public String tinggiFeb="";
	public String tinggiMar="";
	public String tinggiApr="";
	public String tinggiMei1="";
	public String tinggiJun="";
	public String tinggiJul="";
	public String tinggiAgu="";
	public String tinggiSep="";
	public String tinggiOkt="";
	public String tinggiNov="";
	public String tinggiDes="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataPasienBaru window = new DataPasienBaru();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataPasienBaru() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void setUser() {
		Connection con = SQLConnect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate("insert into pasien(nama, namaIbu, alamat, ttl, usia) VALUES('"
	                + namaTF.getText() + "','"+ namaIbuTF.getText() + "','"+ alamatTF.getText() + "','" + ttlTF.getText()+ "','" + usiaTF.getText()
					+"')");
			JOptionPane.showConfirmDialog(null, "Data Diri Disimpan",
		                "Result", JOptionPane.DEFAULT_OPTION,
		                JOptionPane.PLAIN_MESSAGE);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void setStatus() {
		Connection con = SQLConnect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate("insert into status(Nama) VALUES('"+ namaTF.getText()+"')");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
//	public void setTinggi() {
//		Connection con = SQLConnect.getConnection();
//		Statement st;
//		try {
//			st = con.createStatement();
//			st.executeUpdate("insert into tinggi(Nama) VALUES('"+ namaTF.getText()+"')");
//		}catch(Exception ex) {
//			JOptionPane.showMessageDialog(null, ex);
//		}
//	}
	
	public void updateUser() {
		Connection con = SQLConnect.getConnection();
		Statement st;
		try {
			String quuery = "Update pasien set nama='"+namaTF.getText()+"', namaIbu='"+namaIbuTF.getText()+"', alamat='"+alamatTF.getText()+"', ttl='"+ttlTF.getText()+"', usia='"+ usiaTF.getText() +
					"' where nama='"+PasienLama.names+"'";
			st = con.createStatement();
			st.executeUpdate(quuery);
			JOptionPane.showConfirmDialog(null, "Data Disimpan",
		                "Result", JOptionPane.DEFAULT_OPTION,
		                JOptionPane.PLAIN_MESSAGE);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Masukkan Data Dengan Benar!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
//	public void submitBulan() {
//		Connection con = SQLConnect.getConnection();
//		Statement st;
//		String sql = "INSERT INTO `tinggi` (`Nama`, `Bulan`, `Tinggi Badan`, `Vitamin`) VALUES ('"+namaTF.getText()+"', '"+tinggiBulan.getSelectedItem().toString()+"', '"+tinggiTF.getText()+"','"+checkA+"')";
//		try {
//			st = con.prepareStatement(sql);
//			st.executeUpdate(sql);
//			JOptionPane.showConfirmDialog(null, "Data Imunisasi Bulan "+tinggiBulan.getSelectedItem().toString()+" Telah Disimpan",
//		                "Result", JOptionPane.DEFAULT_OPTION,
//		                JOptionPane.PLAIN_MESSAGE);
//		}catch(Exception ex) {
//			System.out.println(ex);
//			System.out.println(sql);
//		}
//	}
//	
//	public void getStatus()
//    {       
//	 	try {
//	            Connection con = SQLConnect.getConnection();
//				Statement st = con.createStatement();
//				ResultSet rs = st.executeQuery("select * from statusanak where nama='"+namaTF.getText()+"'");
//				while(rs.next()) {
//					stVit = rs.getBoolean("vitA");
//					stBCG = rs.getBoolean("bcg");
//					stPolio1 = rs.getBoolean("polio1");
//					stPolio2 = rs.getBoolean("polio2");
//					stPolio3 = rs.getBoolean("polio3");
//					stPolio4 = rs.getBoolean("polio4");
//					stCampak = rs.getBoolean("campak");
//					tglBCG = rs.getString("tanggalBCG");
//					tglPolio1 = rs.getString("tanggalPolio1");
//					tglPolio2 = rs.getString("tanggalPolio1");
//					tglPolio3 = rs.getString("tanggalPolio1");
//					tglPolio4 = rs.getString("tanggalPolio1");
//					tglCampak = rs.getString("tanggalCampak");
//
//					bcgTF.setText(tglBCG);
//					p1TF.setText(tglPolio1);
//					p2TF.setText(tglPolio2);
//					p3TF.setText(tglPolio3);
//					p4TF.setText(tglPolio4);
//					campakTF.setText(tglCampak);
//					cbA.setSelected(stVit);
//					cbBCG.setSelected(stBCG);
//					cbP1.setSelected(stPolio1);
//					cbP2.setSelected(stPolio2);
//					cbP3.setSelected(stPolio3);
//					cbP4.setSelected(stPolio4);
//					cbC.setSelected(stCampak);
//					bcgTF.setEditable(false);
//					p1TF.setEditable(false);
//					p2TF.setEditable(false);
//					p3TF.setEditable(false);
//					p4TF.setEditable(false);
//					campakTF.setEditable(false);
//					
//				}
//					
//	        }catch(SQLException e) {
//	        	System.out.println(e);
//	        }
//    }

//	public void getTinggi() {
//	 try {
//            Connection con = SQLConnect.getConnection();
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select * from tingianak where nama='"+namaTF.getText()+"'");
//			while(rs.next()) {
//				tinggiJan = rs.getString("januari");
//				tinggiFeb = rs.getString("februari");
//				tinggiMar = rs.getString("maret");
//				tinggiApr = rs.getString("april");
//				tinggiMei1 = rs.getString("mei");
//				tinggiJun = rs.getString("juni");
//				tinggiJul = rs.getString("juli");
//				tinggiAgu = rs.getString("agustus");
//				tinggiSep = rs.getString("september");
//				tinggiOkt = rs.getString("oktober");
//				tinggiNov = rs.getString("november");
//				tinggiDes = rs.getString("desember");
//
//				tinggiTF.setText(tinggiJan);
//				tinggiTF.setEditable(false);
//				febTF.setText(tinggiFeb);
//				febTF.setEditable(false);
//				marTF.setText(tinggiMar);
//				marTF.setEditable(false);
//				aprTF.setText(tinggiApr);
//				aprTF.setEditable(false);
//				meiTF.setText(tinggiMei1);
//				meiTF.setEditable(false);
//				junTF.setText(tinggiJun);
//				junTF.setEditable(false);
//				julTF.setText(tinggiJul);
//				julTF.setEditable(false);
//				aguTF.setText(tinggiAgu);
//				aguTF.setEditable(false);
//				sepTF.setText(tinggiSep);
//				sepTF.setEditable(false);
//				oktTF.setText(tinggiOkt);
//				oktTF.setEditable(false);
//				novTF.setText(tinggiNov);
//				novTF.setEditable(false);
//				desTF.setText(tinggiDes);
//				desTF.setEditable(false);
//			}
//
//        }catch(SQLException e) {
//        	System.out.println(e);
//        }
// }
// 
//	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ayo Ke Posyandu!");
		frame.getContentPane().setBackground(new Color(255, 192, 203));
		frame.setBounds(100, 100, 398, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(10, 11, 364, 232);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Identitas Anak");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(95, 11, 140, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nama");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 61, 46, 14);
		panel.add(label_1);
		
		namaTF = new JTextField();
		namaTF.setOpaque(false);
		namaTF.setColumns(10);
		namaTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		namaTF.setBounds(115, 55, 239, 20);
		panel.add(namaTF);
		
		JLabel label_2 = new JLabel("Alamat");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(10, 87, 62, 14);
		panel.add(label_2);
		
		alamatTF = new JTextField();
		alamatTF.setOpaque(false);
		alamatTF.setColumns(10);
		alamatTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		alamatTF.setBounds(115, 81, 239, 20);
		panel.add(alamatTF);
		
		JLabel label_3 = new JLabel("TTL");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(10, 113, 46, 14);
		panel.add(label_3);
		
		ttlTF = new JTextField();
		ttlTF.setOpaque(false);
		ttlTF.setColumns(10);
		ttlTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		ttlTF.setBounds(115, 107, 239, 20);
		panel.add(ttlTF);
		
		JLabel label_4 = new JLabel("Usia");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(10, 139, 46, 14);
		panel.add(label_4);
		
		usiaTF = new JTextField();
		usiaTF.setOpaque(false);
		usiaTF.setColumns(10);
		usiaTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		usiaTF.setBounds(115, 133, 239, 20);
		panel.add(usiaTF);
		
		namaIbuTF = new JTextField();
		namaIbuTF.setOpaque(false);
		namaIbuTF.setColumns(10);
		namaIbuTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		namaIbuTF.setBounds(115, 159, 239, 20);
		panel.add(namaIbuTF);
		
		JLabel label_5 = new JLabel("Nama Ibu");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(10, 165, 82, 14);
		panel.add(label_5);
		
		button = new JButton("Simpan");
		button.setBackground(new Color(173, 216, 230));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUser();
//				setTinggi();
				setStatus();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(261, 196, 93, 25);
		panel.add(button);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(95, 61, 19, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel(":");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(95, 87, 19, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel(":");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(95, 113, 19, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel(":");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_9.setBounds(95, 139, 19, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel(":");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(95, 161, 19, 14);
		panel.add(label_10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(173, 216, 230));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateUser();
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setVisible(false);
		btnUpdate.setBounds(149, 196, 102, 25);
		panel.add(btnUpdate);
		
		btnClose = new JButton("Close");
		btnClose.setBackground(new Color(173, 216, 230));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Welcome welcomeWindow = new Welcome();
				welcomeWindow.frame.setVisible(true);
				
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBounds(272, 254, 89, 23);
		frame.getContentPane().add(btnClose);
		
		btnTutup = new JButton("Close");
		btnTutup.setBackground(new Color(173, 216, 230));
		btnTutup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnTutup.setVisible(false);
		btnTutup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTutup.setBounds(162, 254, 89, 23);
		frame.getContentPane().add(btnTutup);
	}
}
