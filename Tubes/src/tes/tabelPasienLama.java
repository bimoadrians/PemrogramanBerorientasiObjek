package tes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class tabelPasienLama {

	public JFrame frame;
	private JTable tblVitA;
	private JTextField tinggiTF;
	private JTextField vitaTF;
	private JComboBox comboBulan;
	private JTextField statusBCG;
	private JTextField tanggalBCG;
	private JTextField statusPolio1;
	private JTextField tanggalPolio1;
	private JTextField statusPolio2;
	private JTextField tanggalPolio2;
	private JTextField statusPolio3;
	private JTextField tanggalPolio3;
	private JTextField statusPolio4;
	private JTextField tanggalPolio4;
	private JTextField statusCampak;
	private JTextField tanggalCampak;
	public JLabel nama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabelPasienLama window = new tabelPasienLama();
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
	public tabelPasienLama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void getBulan() {
	try {
		Connection con = SQLConnect.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select `Tinggi Badan`, `Vitamin`  from tinggi where nama='"+nama.getText()+"' AND Bulan='"+comboBulan.getSelectedItem().toString()+"'");
		String tinggi = "";
		String stvita = "Belum";
		while(rs.next()) {
			tinggi = rs.getString("Tinggi Badan");
			stvita = rs.getString("Vitamin");
			
			tinggiTF.setText(tinggi);
			vitaTF.setText(stvita);
		}
			
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void getImunisasi() {
	try {
		Connection con = SQLConnect.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from status where nama='"+nama.getText()+"'");
		while(rs.next()) {
			String bcg = rs.getString("bcg");
			String tglbcg = rs.getString("tanggalBCG");
			String polio1 = rs.getString("polio1");
			String tglpolio1 = rs.getString("tanggalPolio1");
			String polio2 = rs.getString("polio2");
			String tglpolio2 = rs.getString("tanggalPolio2");
			String polio3 = rs.getString("polio3");
			String tglpolio3 = rs.getString("tanggalPolio3");
			String polio4 = rs.getString("polio4");
			String tglpolio4 = rs.getString("tanggalPolio4");
			String campak = rs.getString("campak");
			String tglcampak = rs.getString("tanggalCampak");
			
			statusBCG.setText(bcg);
			tanggalBCG.setText(tglbcg);
			statusPolio1.setText(polio1);
			tanggalPolio1.setText(tglpolio1);
			statusPolio2.setText(polio2);
			tanggalPolio2.setText(tglpolio2);
			statusPolio3.setText(polio3);
			tanggalPolio3.setText(tglpolio3);
			statusPolio4.setText(polio4);
			tanggalPolio4.setText(tglpolio4);
			statusCampak.setText(campak);
			tanggalCampak.setText(tglcampak);
		}
			
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void inputBulan() {
		Connection con = SQLConnect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate("insert into tinggi(`Nama`, `Bulan`, `Tinggi Badan`, `Vitamin`) VALUES('"
	                + nama.getText() + "','"+ comboBulan.getSelectedItem().toString() + "','"+ tinggiTF.getText() + "','" + vitaTF.getText()+"')");
			JOptionPane.showConfirmDialog(null, "Data Disimpan",
		                "Result", JOptionPane.DEFAULT_OPTION,
		                JOptionPane.PLAIN_MESSAGE);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Masukkan Data Dengan Benar!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void inputImunisasi() {
		Connection con = SQLConnect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate("Update status set Nama='"+nama.getText()+"', bcg='"+statusBCG.getText()+"', tanggalBcg='"+tanggalBCG.getText()+"', polio1='"+statusPolio1.getText()+"', tanggalPolio1='"+ tanggalPolio1.getText() +
					"', polio2='"+statusPolio2.getText()+"', tanggalPolio2='"+tanggalPolio2.getText()+"', polio3='"+statusPolio3.getText()+"', tanggalPolio3='"+tanggalPolio3.getText()+"', polio4='"+statusPolio4.getText()+"', tanggalPolio4='"+
					tanggalPolio4.getText()+"', campak='"+statusCampak.getText()+"', tanggalCampak='"+tanggalCampak.getText()+"' where Nama='"+nama.getText()+"'");
			JOptionPane.showConfirmDialog(null, "Data Disimpan",
		                "Result", JOptionPane.DEFAULT_OPTION,
		                JOptionPane.PLAIN_MESSAGE);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Masukkan Data Dengan Benar!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ayo Ke Posyandu!");
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 407, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBorder(new LineBorder(UIManager.getColor("CheckBox.focus")));
		panel.setBounds(10, 104, 369, 192);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTinggiBadan = new JLabel("Tinggi Badan*");
		lblTinggiBadan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinggiBadan.setBounds(10, 78, 89, 17);
		panel.add(lblTinggiBadan);
		
		tinggiTF = new JTextField();
		tinggiTF.setBounds(149, 78, 120, 20);
		panel.add(tinggiTF);
		tinggiTF.setColumns(10);
		
		JLabel lblImunisasiVitaminA = new JLabel("Imunisasi Vitamin A");
		lblImunisasiVitaminA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImunisasiVitaminA.setBounds(10, 106, 129, 17);
		panel.add(lblImunisasiVitaminA);
		
		vitaTF = new JTextField();
		vitaTF.setColumns(10);
		vitaTF.setBounds(149, 106, 120, 20);
		panel.add(vitaTF);
		
		comboBulan = new JComboBox();
		comboBulan.setBackground(new Color(240, 255, 240));
		comboBulan.setBounds(10, 44, 129, 23);
		panel.add(comboBulan);
		comboBulan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBulan.setModel(new DefaultComboBoxModel(new String[] {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"}));
		
		JButton btnTampilkan = new JButton("Tampilkan");
		btnTampilkan.setBackground(new Color(240, 255, 240));
		btnTampilkan.setBounds(162, 42, 107, 25);
		panel.add(btnTampilkan);
		btnTampilkan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getBulan();
			}
		});
		btnTampilkan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDataImunisasiPer = new JLabel("Data Imunisasi Per Bulan");
		lblDataImunisasiPer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataImunisasiPer.setBounds(10, 11, 206, 20);
		panel.add(lblDataImunisasiPer);
		
		JLabel lblsatuanTinggiBadan = new JLabel("*Satuan Tinggi Badan Adalah CM");
		lblsatuanTinggiBadan.setBounds(10, 134, 259, 14);
		panel.add(lblsatuanTinggiBadan);
		
		JButton button = new JButton("Simpan");
		button.setBackground(new Color(240, 255, 240));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputBulan();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(270, 158, 89, 23);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBorder(new LineBorder(UIManager.getColor("CheckBox.focus"), 1, true));
		panel_1.setBounds(10, 307, 369, 310);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDataImunisasiKeseluruhan = new JLabel("Data Imunisasi Keseluruhan");
		lblDataImunisasiKeseluruhan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataImunisasiKeseluruhan.setBounds(10, 11, 228, 20);
		panel_1.add(lblDataImunisasiKeseluruhan);
		
		JLabel lblJenisImunisasi = new JLabel("Jenis Imunisasi");
		lblJenisImunisasi.setBounds(10, 74, 111, 14);
		panel_1.add(lblJenisImunisasi);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(131, 73, 71, 14);
		panel_1.add(lblStatus);
		
		JLabel lblTanggalImunisasi = new JLabel("Tanggal Imunisasi");
		lblTanggalImunisasi.setBounds(227, 73, 129, 14);
		panel_1.add(lblTanggalImunisasi);
		
		JLabel lblBcg = new JLabel("BCG");
		lblBcg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBcg.setBounds(10, 97, 46, 14);
		panel_1.add(lblBcg);
		
		statusBCG = new JTextField();
		statusBCG.setBounds(131, 95, 86, 20);
		panel_1.add(statusBCG);
		statusBCG.setColumns(10);
		
		tanggalBCG = new JTextField();
		tanggalBCG.setColumns(10);
		tanggalBCG.setBounds(227, 95, 129, 20);
		panel_1.add(tanggalBCG);
		
		JLabel lblPolio = new JLabel("Polio 1");
		lblPolio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPolio.setBounds(10, 124, 46, 14);
		panel_1.add(lblPolio);
		
		statusPolio1 = new JTextField();
		statusPolio1.setColumns(10);
		statusPolio1.setBounds(131, 122, 86, 20);
		panel_1.add(statusPolio1);
		
		tanggalPolio1 = new JTextField();
		tanggalPolio1.setColumns(10);
		tanggalPolio1.setBounds(227, 122, 129, 20);
		panel_1.add(tanggalPolio1);
		
		JLabel lblPolio_1 = new JLabel("Polio 2");
		lblPolio_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPolio_1.setBounds(10, 151, 46, 14);
		panel_1.add(lblPolio_1);
		
		statusPolio2 = new JTextField();
		statusPolio2.setColumns(10);
		statusPolio2.setBounds(131, 149, 86, 20);
		panel_1.add(statusPolio2);
		
		tanggalPolio2 = new JTextField();
		tanggalPolio2.setColumns(10);
		tanggalPolio2.setBounds(227, 149, 129, 20);
		panel_1.add(tanggalPolio2);
		
		JLabel lblPolio_2 = new JLabel("Polio 3");
		lblPolio_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPolio_2.setBounds(10, 178, 46, 14);
		panel_1.add(lblPolio_2);
		
		statusPolio3 = new JTextField();
		statusPolio3.setColumns(10);
		statusPolio3.setBounds(131, 176, 86, 20);
		panel_1.add(statusPolio3);
		
		tanggalPolio3 = new JTextField();
		tanggalPolio3.setColumns(10);
		tanggalPolio3.setBounds(227, 176, 129, 20);
		panel_1.add(tanggalPolio3);
		
		JLabel lblPolio_3 = new JLabel("Polio 4");
		lblPolio_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPolio_3.setBounds(10, 205, 46, 14);
		panel_1.add(lblPolio_3);
		
		statusPolio4 = new JTextField();
		statusPolio4.setColumns(10);
		statusPolio4.setBounds(131, 203, 86, 20);
		panel_1.add(statusPolio4);
		
		tanggalPolio4 = new JTextField();
		tanggalPolio4.setColumns(10);
		tanggalPolio4.setBounds(227, 203, 129, 20);
		panel_1.add(tanggalPolio4);
		
		JLabel lblCampak = new JLabel("Campak");
		lblCampak.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCampak.setBounds(10, 232, 50, 16);
		panel_1.add(lblCampak);
		
		statusCampak = new JTextField();
		statusCampak.setColumns(10);
		statusCampak.setBounds(131, 230, 86, 20);
		panel_1.add(statusCampak);
		
		tanggalCampak = new JTextField();
		tanggalCampak.setColumns(10);
		tanggalCampak.setBounds(227, 230, 129, 20);
		panel_1.add(tanggalCampak);
		
		JButton btnTampilkanDataImunisasi = new JButton("Tampilkan Data Imunisasi");
		btnTampilkanDataImunisasi.setBackground(new Color(240, 255, 240));
		btnTampilkanDataImunisasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getImunisasi();
			}
		});
		btnTampilkanDataImunisasi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTampilkanDataImunisasi.setBounds(10, 42, 180, 23);
		panel_1.add(btnTampilkanDataImunisasi);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBackground(new Color(240, 255, 240));
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputImunisasi();
			}
		});
		btnSimpan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSimpan.setBounds(267, 276, 89, 23);
		panel_1.add(btnSimpan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(UIManager.getColor("CheckBox.focus")));
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBounds(10, 11, 371, 82);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDataImunisasi = new JLabel("Data Imunisasi");
		lblDataImunisasi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataImunisasi.setBounds(10, 11, 189, 20);
		panel_2.add(lblDataImunisasi);
		
		JLabel lblNama = new JLabel("Nama :");
		lblNama.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNama.setBounds(10, 42, 61, 16);
		panel_2.add(lblNama);
		
		nama = new JLabel("Nama");
		nama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nama.setBounds(68, 42, 96, 17);
		panel_2.add(nama);
		
		JButton btnTampilkanDataDiri = new JButton("Tampilkan Data Diri");
		btnTampilkanDataDiri.setBackground(new Color(240, 248, 255));
		btnTampilkanDataDiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataPasienBaru windows = new DataPasienBaru();
				windows.frame.setVisible(true);
				windows.namaTF.setText(PasienLama.names);
				windows.alamatTF.setText(PasienLama.almt);
				windows.namaIbuTF.setText(PasienLama.ibu);
				windows.ttlTF.setText(PasienLama.lahir);
				windows.usiaTF.setText(PasienLama.umur);
				windows.button.setVisible(false);
				windows.btnTutup.setVisible(true);
				windows.btnClose.setVisible(false);
				windows.btnUpdate.setVisible(true);
			}
		});
		btnTampilkanDataDiri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTampilkanDataDiri.setBounds(187, 40, 174, 25);
		panel_2.add(btnTampilkanDataDiri);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(new Color(255, 192, 203));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Welcome welcomeWindow = new Welcome();
				welcomeWindow.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBounds(290, 633, 91, 25);
		frame.getContentPane().add(btnHome);
	}
}
