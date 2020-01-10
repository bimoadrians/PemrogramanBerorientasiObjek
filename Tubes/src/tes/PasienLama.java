package tes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JToggleButton;
import java.awt.Toolkit;

public class PasienLama {

	public JFrame frame;
	public static JTable table;
	public JButton btnPilih;
	public static String name="";
	public static String names="";
	public static String ibu="";
	public static String almt="";
	public static String lahir="";
	public static String umur="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasienLama lamaWindow= new PasienLama();
					lamaWindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasienLama() {
		initialize();
		showTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public ArrayList<DataPasien> getdataAnak(){
		ArrayList<DataPasien> dataAnak = new ArrayList<DataPasien>();
		Connection con = SQLConnect.getConnection();
		
		String query = "SELECT nama, namaIbu from pasien";
		Statement st;
		ResultSet rs;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			DataPasien pasien;
			while(rs.next()) {
				pasien = new DataPasien(rs.getString("nama"), rs.getString("namaIbu"));
				dataAnak.add(pasien);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dataAnak;
	}
	
	public void showTable() {
		ArrayList<DataPasien> data = getdataAnak();
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		Object[] row = new Object[3];
		for(int i=0; i<data.size(); i++) {
			row[0] = i+1;
			row[1] = data.get(i).getNama();
			row[2] = data.get(i).getNamaIbu();
			
			model.addRow(row);
		}
		
		
	}
	
	 public void displayRowValues()
	    {       
		 	try {
	        	int rowIndex = table.getSelectedRow();
		            Object o = table.getValueAt(rowIndex, 1);
		            name = o.toString();
		            
		            Connection con = SQLConnect.getConnection();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from pasien where nama='"+name+"'");
					while(rs.next()) {
						names = rs.getString("nama");
						ibu = rs.getString("namaIbu");
						lahir = rs.getString("ttl");
						almt = rs.getString("alamat");
						umur = rs.getString("usia");
					}
	    } catch(SQLException e) {
        	System.out.println(e);
        }
	}
	 
	 public void deleteUser()
	    {       
		 try{
			 int row = table.getSelectedRow();
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
			 String selected = model.getValueAt(row, 1).toString();
			 
			 Connection con = SQLConnect.getConnection();
			 String sql = "delete from pasien where nama= ?";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 stmt.setString( 1, selected);
			 stmt.executeUpdate();
			 
			 ((DefaultTableModel) table.getModel()).removeRow(row);
			 ((DefaultTableModel) table.getModel()).fireTableRowsDeleted(row, row);
			 ((DefaultTableModel) table.getModel()).fireTableDataChanged();
		 } catch(SQLException e) {
			 System.out.println(e);
		 }
	}
	 
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ayo Ke Posyandu!");
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setResizable(false);
		frame.setBounds(100, 100, 518, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 11, 488, 73);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDataPasienLama = new JLabel("Data Pasien Lama");
		lblDataPasienLama.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDataPasienLama.setBounds(134, 11, 220, 51);
		panel.add(lblDataPasienLama);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 95, 488, 228);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(null);
		table.setBackground(new Color(255, 192, 203));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nomor", "Nama Anak", "Nama Ibu"
			}
		));
		table.getSelectionModel().addListSelectionListener((ListSelectionEvent event) ->{
			if(event.getValueIsAdjusting() == false) {
				btnPilih.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(new Color(255, 192, 203));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Welcome welcomeWindow = new Welcome();
				welcomeWindow.frame.setVisible(true);
			}
		});
		btnHome.setBounds(409, 378, 89, 23);
		frame.getContentPane().add(btnHome);
		
		btnPilih = new JButton("Pilih ");
		btnPilih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayRowValues();
				tabelPasienLama window = new tabelPasienLama();
				window.nama.setText(names);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnPilih.setEnabled(false);
		btnPilih.setBackground(new Color(255, 192, 203));
		btnPilih.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPilih.setBounds(409, 335, 89, 23);
		frame.getContentPane().add(btnPilih);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 192, 203));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});
		btnDelete.setBounds(310, 334, 89, 23);
		frame.getContentPane().add(btnDelete);
		ImageIcon i = new ImageIcon("./img/");
	}
}
