package proiect;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class GUI {

	private JFrame frame;
	private JTable tabelProduse;
	private JTable tabelMeniu;
	private JComboBox comboSos;
	private JComboBox comboSuc;
	List<Produs> produse = new ArrayList();
	List<Meniu> meniuri = new ArrayList();
	int nrBurgeri = 0;
	int nrPizza = 0;
	int nrShaworma = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {
		initialize();
		creareTabelProduse();
		creareTabelMeniu();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1202, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Fast food");
		frame.getContentPane().setLayout(null);
		
		JLabel titlu = new JLabel("Fast food");
		titlu.setBounds(574, 19, 144, 37);
		titlu.setHorizontalAlignment(SwingConstants.CENTER);
		titlu.setForeground(SystemColor.textHighlight);
		titlu.setFont(new Font("Monospaced", Font.BOLD, 27));
		frame.getContentPane().add(titlu);
		
		JScrollPane scrollProduse = new JScrollPane();
		scrollProduse.setBounds(33, 96, 594, 476);
		frame.getContentPane().add(scrollProduse);
		
		tabelProduse = new JTable();
		scrollProduse.setViewportView(tabelProduse);
		
		JButton btnCos = new JButton("Cos produse");
		btnCos.setBounds(916, 18, 155, 51);
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cos cos = new Cos(produse,meniuri,nrBurgeri,nrPizza,nrShaworma);
				cos.getJFrame().setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCos);
		
		JButton btnProduse = new JButton("Adauga produse in cos");
		btnProduse.setBounds(220, 681, 179, 51);
		btnProduse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] prod =  new Object[10];
				int[] selectedRows = tabelProduse.getSelectedRows();
				Object selectedObject = null;
				for(int i = 0 ; i < selectedRows.length ; i++) {
					int currentRow = selectedRows[i];
					for(int j = 0 ; j < tabelProduse.getColumnCount() ; j++) {
						selectedObject = (Object) tabelProduse.getModel().getValueAt(currentRow, j);
						prod[j] = selectedObject;
					}
					
					switch(prod[1].toString()) {
					case "Burger" : Burger burger = new Burger(prod[1].toString(),prod[2].toString(),
							Double.parseDouble(prod[3].toString()),
							Double.parseDouble(prod[4].toString()),
							TipCarne.valueOf(prod[5].toString()),TipChifla.valueOf(prod[6].toString()),
							Boolean.parseBoolean(prod[7].toString()));
							nrBurgeri = (int)Double.parseDouble(prod[4].toString());
							if(Double.parseDouble(prod[4].toString()) == 0) {
								JOptionPane.showMessageDialog(null,"Nu mai avem burgeri din pacate !");
							}
							else if(Double.parseDouble(prod[4].toString()) < selectedRows.length) {
								JOptionPane.showMessageDialog(null,"Nu mai avem destui burgeri din pacate !");
								return;
							}
							else {
								produse.add(burger);
							}
							break;
					case "Pizza" : Pizza pizza = new Pizza(prod[1].toString(),prod[2].toString(),
							Double.parseDouble(prod[3].toString()),
							Double.parseDouble(prod[4].toString()),
							TipBlat.valueOf(prod[5].toString()),prod[6].toString(),
							Integer.parseInt(prod[7].toString()));
							nrPizza = (int)Double.parseDouble(prod[4].toString());

					if(Double.parseDouble(prod[4].toString()) == 0) {
						JOptionPane.showMessageDialog(null,"Nu mai avem pizza din pacate !");
					}
					else if(Double.parseDouble(prod[4].toString()) < selectedRows.length) {
						JOptionPane.showMessageDialog(null,"Nu mai avem destula pizza din pacate !");
						return;
					}
					else {
						produse.add(pizza);
					}
					break;
					default : Shaworma shaworma = new Shaworma(prod[1].toString(),prod[2].toString(),
							Double.parseDouble(prod[3].toString()),
							Double.parseDouble(prod[4].toString()),
							TipCarne.valueOf(prod[5].toString()),TipLipie.valueOf(prod[6].toString()),
							Boolean.parseBoolean(prod[7].toString()));
							nrShaworma = (int)Double.parseDouble(prod[4].toString());

					if(Double.parseDouble(prod[4].toString()) == 0) {
						JOptionPane.showMessageDialog(null,"Nu mai avem shaworma din pacate !");
					}
					else if(Double.parseDouble(prod[4].toString()) < selectedRows.length) {
						JOptionPane.showMessageDialog(null,"Nu mai avem destula shaworma din pacate !");
						return;
					}
					else {
						produse.add(shaworma);
					}
					}

				}
				if(!produse.isEmpty())
				JOptionPane.showMessageDialog(null, "Produse adaugate cu succes!");
				
			}
		});
		frame.getContentPane().add(btnProduse);
		
		JButton btnMeniu = new JButton("Adauga meniu in cos");
		btnMeniu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tabelMeniu.getSelectedRow();
				String tipMeniu = tabelMeniu.getValueAt(row, 1).toString();
				String suc = comboSuc.getSelectedItem().toString();
				String sos = comboSos.getSelectedItem().toString();
				Meniu meniu;
				switch(tipMeniu) {
				case "Meniu Burger" : 
					Burger burger = getBurgerFromDatabase();
					meniu = new Meniu(tipMeniu,TipSos.valueOf(sos),TipSuc.valueOf(suc),burger);
					meniuri.add(meniu);
					break;
				case "Meniu Pizza" :
					Pizza pizza = getPizzaFromDatabase();
					meniu = new Meniu(tipMeniu,TipSos.valueOf(sos),TipSuc.valueOf(suc),pizza);
					meniuri.add(meniu);
					break;
				case "Meniu Shaworma" : 
					Shaworma shaworma = getShawormaFromDatabase();
					meniu = new Meniu(tipMeniu,TipSos.valueOf(sos),TipSuc.valueOf(suc),shaworma);
					meniuri.add(meniu);
					break;
				}
				JOptionPane.showMessageDialog(null, "Meniu adaugat cu succes!");
			}
		});
		btnMeniu.setBounds(833, 681, 179, 51);
		frame.getContentPane().add(btnMeniu);
		
		JScrollPane scrollMeniu = new JScrollPane();
		scrollMeniu.setBounds(710, 96, 404, 476);
		frame.getContentPane().add(scrollMeniu);
		
		tabelMeniu = new JTable();
		scrollMeniu.setViewportView(tabelMeniu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectie = comboBox.getSelectedItem().toString();
				switch(selectie) {
				case "Burger" : creareTabelBurger();
								break;
				case "Pizza" : creareTabelPizza();
							   break;
				case "Shaworma" : creareTabelShaworma();
								  break;
				default : creareTabelProduse();
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Alege-", "Burger", "Pizza", "Shaworma"}));
		comboBox.setBounds(220, 583, 179, 51);
		frame.getContentPane().add(comboBox);
		
		comboSos = new JComboBox();
		comboSos.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboSos.setModel(new DefaultComboBoxModel(new String[] {"-Alege Sos-", "KETCHUP", "USTUROI", "MAIONEZA", "MUSTAR"}));
		comboSos.setBounds(744, 592, 155, 37);
		frame.getContentPane().add(comboSos);
		
		comboSuc = new JComboBox();
		comboSuc.setModel(new DefaultComboBoxModel(new String[] {"-Alege Suc-", "COLA", "PEPSI", "FANTA", "SPRITE"}));
		comboSuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboSuc.setBounds(942, 590, 155, 37);
		frame.getContentPane().add(comboSuc);
	}


	public JFrame getFrame() {
		return frame;
	}
	
	void creareTabelProduse() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs";
		String[] columnNames = {"Id produs", "Nume", "Descriere", "Pret", "Cantitate"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idprodus");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				Object[] data = { id, nume, descriere , pret, cantitate } ;
			    tableModel.addRow(data);
			}
			tabelProduse.setModel(tableModel);
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	void creareTabelMeniu() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from meniu";
		String[] columnNames = {"Id meniu", "Nume"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idmeniu");
				String nume = resultSet.getString("nume");
				Object[] data = { id, nume} ;
			    tableModel.addRow(data);
			}
			tabelMeniu.setModel(tableModel);
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	void creareTabelBurger() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs,burger WHERE burger.idProdus = produs.idprodus;";
		String[] columnNames = {"Id burger", "Nume", "Descriere", "Pret", "Cantitate", "Tip Carne", "Tip Chifla", "Salata"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idBurger");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				TipCarne tipCarne = TipCarne.valueOf(resultSet.getString("carne"));
				TipChifla tipChifla = TipChifla.valueOf(resultSet.getString("chifla"));
				boolean areSalata = resultSet.getBoolean("salata");
				Object[] data = { id, nume, descriere , pret, cantitate, tipCarne, tipChifla , areSalata } ;
			    tableModel.addRow(data);
			}
			tabelProduse.setModel(tableModel);
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	void creareTabelPizza() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs,pizza WHERE pizza.idProdus = produs.idprodus;";
		String[] columnNames = {"Id pizza", "Nume", "Descriere", "Pret", "Cantitate", "Tip Blat", "Topping", "Dimensiune(cm)"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idPizza");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				TipBlat tipBlat = TipBlat.valueOf(resultSet.getString("aluat"));
				String topping = resultSet.getString("topping");
				int dimensiune = resultSet.getInt("dimensiune");
				Object[] data = { id, nume, descriere , pret, cantitate, tipBlat, topping , dimensiune } ;
			    tableModel.addRow(data);
			}
			tabelProduse.setModel(tableModel);
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	void creareTabelShaworma() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs,shaworma WHERE shaworma.idProdus = produs.idprodus;";
		String[] columnNames = {"Id shaworma", "Nume", "Descriere", "Pret", "Cantitate","Tip carne", "Tip Lipie", "Are Salata"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idshaworma");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				TipCarne tipCarne = TipCarne.valueOf(resultSet.getString("carne"));
				TipLipie tipLipie = TipLipie.valueOf(resultSet.getString("lipie"));
				boolean areSalata = resultSet.getBoolean("salata");
				Object[] data = { id, nume, descriere , pret, cantitate, tipCarne, tipLipie, areSalata} ;
			    tableModel.addRow(data);
			}
			tabelProduse.setModel(tableModel);
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	Burger getBurgerFromDatabase() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs,burger WHERE burger.idProdus = produs.idprodus and burger.idBurger = 1;";
		Burger burger = new Burger();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idBurger");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				TipCarne tipCarne = TipCarne.valueOf(resultSet.getString("carne"));
				TipChifla tipChifla = TipChifla.valueOf(resultSet.getString("chifla"));
				boolean areSalata = resultSet.getBoolean("salata");
				burger.setNume(nume);
				burger.setDescriere(descriere);
				burger.setPret(pret);
				burger.setCantitate(cantitate);
				burger.setTipCarne(tipCarne);
				burger.setTipChifla(tipChifla);
				burger.setAreSalata(areSalata);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return burger;
	}

	Pizza getPizzaFromDatabase() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs,pizza WHERE pizza.idProdus = produs.idprodus and pizza.idPizza = 1;";
		Pizza pizza = new Pizza();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idPizza");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				TipBlat tipBlat = TipBlat.valueOf(resultSet.getString("aluat"));
				String topping = resultSet.getString("topping");
				int dimensiune = resultSet.getInt("dimensiune");
				pizza.setNume(nume);
				pizza.setDescriere(descriere);
				pizza.setPret(pret);
				pizza.setCantitate(cantitate);
				pizza.setTipBlat(tipBlat);
				pizza.setTopping(topping);
				pizza.setDimensiune(dimensiune);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return pizza;
	}
	
	Shaworma getShawormaFromDatabase() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * from produs,shaworma WHERE shaworma.idProdus = produs.idprodus;";
		Shaworma shaworma = new Shaworma();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idshaworma");
				String nume = resultSet.getString("nume");
				String descriere = resultSet.getString("descriere");
				Double pret = resultSet.getDouble("pret");
				Double cantitate = resultSet.getDouble("cantitate");
				TipCarne tipCarne = TipCarne.valueOf(resultSet.getString("carne"));
				TipLipie tipLipie = TipLipie.valueOf(resultSet.getString("lipie"));
				boolean areSalata = resultSet.getBoolean("salata");
				shaworma.setNume(nume);
				shaworma.setDescriere(descriere);
				shaworma.setPret(pret);
				shaworma.setCantitate(cantitate);
				shaworma.setTipCarne(tipCarne);
				shaworma.setTipLipie(tipLipie);
				shaworma.setAreSalata(areSalata);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return shaworma;
	}
}
