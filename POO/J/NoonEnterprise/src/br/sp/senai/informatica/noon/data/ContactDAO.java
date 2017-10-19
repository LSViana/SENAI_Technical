package br.sp.senai.informatica.noon.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.sp.senai.informatica.noon.model.Contact;

public class ContactDAO {
	private static Connection CONNECTION;
	private static String INSERTINTO = "INSERT INTO Contato VALUES(0, ?, ?, ?, ?)";
	private static String GETALL = "SELECT * FROM Contato";
	private static String DELETEBYID = "DELETE FROM Contato WHERE Id = ?";
	private static String FINDBYID = "SELECT * FROM Contato WHERE Id = ?";
	private static String UPDATEBYID = "UPDATE Contato SET Nome = ?, Email = ?, Endereco = ?, DataNascimento = ? WHERE Id = ?";

	public ContactDAO() {
		// Standard Constructor
	}

	public Contact insert(Contact contact) throws ClassNotFoundException, SQLException {
		CONNECTION = ConnectionFactory_Agenda.openConnection();
		PreparedStatement stmt = CONNECTION.prepareStatement(INSERTINTO);
		stmt.setString(1, contact.getName());
		stmt.setString(2, contact.getEmail());
		stmt.setString(3, contact.getAddress());
		stmt.setObject(4, contact.getDateOfBirthday());
		stmt.executeUpdate();
		ConnectionFactory_Agenda.closeConnection(CONNECTION);
		return contact;
	}

	public List<Contact> getAll() {
		try {
			CONNECTION = ConnectionFactory_Agenda.openConnection();
			PreparedStatement stmt = CONNECTION.prepareStatement(GETALL);
			ResultSet resultSet = stmt.executeQuery();
			List<Contact> result = new ArrayList<Contact>();
			while (resultSet.next()) {
				result.add(new Contact(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getObject(5, LocalDate.class)));
			}
			ConnectionFactory_Agenda.closeConnection(CONNECTION);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Contact contact) {
		delete(contact.getId());
	}

	public void delete(int id) {
		try {
			CONNECTION = ConnectionFactory_Agenda.openConnection();
			PreparedStatement stmt = CONNECTION.prepareStatement(DELETEBYID);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			ConnectionFactory_Agenda.closeConnection(CONNECTION);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Contact findById(int id) {
		try {
			CONNECTION = ConnectionFactory_Agenda.openConnection();
			PreparedStatement stmt = CONNECTION.prepareStatement(FINDBYID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Contact result = null;
			if (rs.next()) {
				result = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getObject(5, LocalDate.class));
			}
			ConnectionFactory_Agenda.closeConnection(CONNECTION);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, String name, String email, String address, LocalDate dateOfBirthday) {
		try {
			CONNECTION = ConnectionFactory_Agenda.openConnection();
			PreparedStatement stmt = CONNECTION.prepareStatement(UPDATEBYID);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, address);
			stmt.setObject(4, dateOfBirthday);
			stmt.setInt(5, id);
			stmt.executeUpdate();
			ConnectionFactory_Agenda.closeConnection(CONNECTION);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}