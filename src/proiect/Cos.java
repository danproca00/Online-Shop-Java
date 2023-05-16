package proiect;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Cos extends JFrame{

	private JFrame frame;
	List<Produs> produse = new ArrayList();
	List<Meniu> meniuri = new ArrayList();
	private JTable tabelBurger;
	private JTable tabelPizza;
	private JTable tabelShaworma;
	private JTable tabelMeniu;
	private double total;
	int nrBurgeri;
	int nrPizza;
	int nrShaworma;
	public Cos(List<Produs> produse, List<Meniu> meniuri, int nrBurgeri, int nrPizza, int nrShaworma) {
		this.produse = produse;
		this.meniuri = meniuri;
		this.nrBurgeri = nrBurgeri;
		this.nrPizza = nrPizza;
		this.nrShaworma = nrShaworma;
		initialize();
		total = 0;
		total += creareTabelBurger(produse);
		total += creareTabelPizza(produse);
		total += creareTabelShaworma(produse);
		total += creareTabelMeniu(meniuri);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(152, 251, 152));
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Fast food");
		frame.getContentPane().setLayout(null);
		
		JLabel titlu = new JLabel("Fast food");
		titlu.setBounds(535, 24, 144, 37);
		titlu.setHorizontalAlignment(SwingConstants.CENTER);
		titlu.setForeground(SystemColor.textHighlight);
		titlu.setFont(new Font("Monospaced", Font.BOLD, 27));
		frame.getContentPane().add(titlu);
		
		JButton btnConfirma = new JButton("Confirma comanda");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,"Doriti sa confirmati comanda in valoare de " + total +" ?", "Confirmare comanda",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Comanda a fost confirmata cu succes !");
					updateCantitate(produse,meniuri);
					GUI gui = new GUI();
					gui.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnConfirma.setBounds(88, 24, 169, 37);
		frame.getContentPane().add(btnConfirma);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI gui = new GUI();
				gui.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(943, 24, 169, 37);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 105, 528, 290);
		frame.getContentPane().add(scrollPane);
		
		tabelBurger = new JTable();
		scrollPane.setViewportView(tabelBurger);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(619, 105, 528, 290);
		frame.getContentPane().add(scrollPane_1);
		
		tabelPizza = new JTable();
		scrollPane_1.setViewportView(tabelPizza);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(40, 460, 528, 290);
		frame.getContentPane().add(scrollPane_2);
		
		tabelShaworma = new JTable();
		scrollPane_2.setViewportView(tabelShaworma);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(619, 460, 528, 290);
		frame.getContentPane().add(scrollPane_3);
		
		tabelMeniu = new JTable();
		scrollPane_3.setViewportView(tabelMeniu);
	}
	
	public JFrame getJFrame() {
		return frame;
	}
	
	double creareTabelBurger(List<Produs> produse) {
		String[] columnNames = {"Id burger", "Nume", "Descriere", "Pret", "Cantitate", "Tip Carne", "Tip Chifla", "Salata" , "Pret total"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		int i = 1;
		double pretTotal = 0;
		for(Produs p : produse) {
			if(p.getNume().contains("Burger")) {
				Burger burger = (Burger)p;
				Object[] data = { i, p.getNume(), p.getDescriere() , p.getPret(), p.getCantitate(), burger.getTipCarne(), burger.getTipChifla() , burger.getAreSalata() } ;
				i++;
				pretTotal += burger.getPret();
				tableModel.addRow(data);
			}
		}
		Object[] data = {null, null , null , null , null , null, null , null , pretTotal};
		tableModel.addRow(data);
		tabelBurger.setModel(tableModel);
		return pretTotal;
	}
	double creareTabelPizza(List<Produs> produse) {
		String[] columnNames = {"Id pizza", "Nume", "Descriere", "Pret", "Cantitate", "Tip Blat", "Topping", "Dimensiune" , "Pret total"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		int i = 1;
		double pretTotal = 0;
		for(Produs p : produse) {
			if(p.getNume().contains("Pizza")) {
				Pizza pizza = (Pizza)p;
				Object[] data = { i, p.getNume(), p.getDescriere() , p.getPret(), p.getCantitate(), pizza.getTipBlat(), pizza.getTopping() , pizza.getDimensiune()} ;
				i++;
				pretTotal += pizza.getPret();
				tableModel.addRow(data);
			}
		}
		Object[] data = {null, null , null , null , null , null, null , null , pretTotal};
		tableModel.addRow(data);
		tabelPizza.setModel(tableModel);
		return pretTotal;
	}
	double creareTabelShaworma(List<Produs> produse) {
		String[] columnNames = {"Id shaworma", "Nume", "Descriere", "Pret", "Cantitate", "Tip carne", "Tip lipie", "Are salata" , "Pret total"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		int i = 1;
		double pretTotal = 0;
		for(Produs p : produse) {
			if(p.getNume().contains("Shaworma")) {
				Shaworma shaworma = (Shaworma)p;
				Object[] data = { i, p.getNume(), p.getDescriere() , p.getPret(), p.getCantitate(), shaworma.getTipCarne(), shaworma.getTipLipie() , shaworma.getAreSalata()} ;
				i++;
				pretTotal += shaworma.getPret();
				tableModel.addRow(data);
			}
		}
		Object[] data = {null, null , null , null , null , null, null , null , pretTotal};
		tableModel.addRow(data);
		tabelShaworma.setModel(tableModel);
		return pretTotal;
	}
	double creareTabelMeniu(List<Meniu> meniuri) {
		String[] columnNames = {"Id meniu", "Nume", "Sos" , "Suc" , "Pret meniu" , "Pret total"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		int i = 1;
		double pretTotal = 0;
		for(Meniu m : meniuri) {
			Object[] data = { i, m.getNume(), m.getTipSos() , m.getTipSuc(), m.getProdus().getPret()} ;
			i++;
			pretTotal += m.getProdus().getPret();
			tableModel.addRow(data);
			}
		Object[] data = {null, null , null , null , null , pretTotal};
		tableModel.addRow(data);
		tabelMeniu.setModel(tableModel);
		return pretTotal;
	}
	
	void updateCantitate(List<Produs> produse,List<Meniu> meniuri) {
		int currNrBurgeri = 0;
		int currNrPizza = 0;
		int currNrShaworma = 0;
		for(Produs p : produse) {
			if(p.getNume().contains("Burger")) {
				currNrBurgeri++;
			}
			else if(p.getNume().contains("Pizza")) {
				currNrPizza++;
			}
			else {
				currNrShaworma++;
			}
		}
//		for(Meniu m : meniuri) {
//			if(m.getProdus().getNume().contains("Burger")) {
//				currNrBurgeri++;
//			}
//			else if(m.getProdus().getNume().contains("Pizza")) {
//				currNrPizza++;
//			}
//			else if(m.getProdus().getNume().contains("Shaworma")){
//				currNrShaworma++;
//			}
//		}
		String queryBurger = "UPDATE produs SET cantitate=" + (nrBurgeri - currNrBurgeri) + " WHERE nume='Burger';";
		String queryPizza = "UPDATE produs SET cantitate=" + (nrPizza - currNrPizza) + " WHERE nume='Pizza';"; 
		String queryShaworma = "UPDATE produs SET cantitate=" + (nrShaworma - currNrShaworma) + " WHERE nume='Shaworma';"; 

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			if(nrBurgeri!=0)
			statement.executeUpdate(queryBurger);
			if(nrPizza!=0)
			statement.executeUpdate(queryPizza);
			if(nrShaworma!=0)
			statement.executeUpdate(queryShaworma);
			
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}