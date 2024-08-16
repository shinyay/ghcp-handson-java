package org.example.challenge5;

import org.example.challenge3.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
	private static final String JDBC_URL = "jdbc:derby:memory:bookDB;create=true";
	private static final String JDBC_USER = "";
	private static final String JDBC_PASSWORD = "";

	public BookService() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			 Statement statement = connection.createStatement()) {
			String createTableSQL = "CREATE TABLE books (" +
					"id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY," +
					"title VARCHAR(255)," +
					"author VARCHAR(255)," +
					"publicationYear INT," +
					"isbn VARCHAR(20)," +
					"price DOUBLE)";
			statement.executeUpdate(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addBook(Book book) {
		String insertSQL = "INSERT INTO books (title, author, publicationYear, isbn, price) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setInt(3, book.getPublicationYear());
			preparedStatement.setString(4, book.getIsbn());
			preparedStatement.setDouble(5, book.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		String selectSQL = "SELECT * FROM books";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery(selectSQL)) {
			while (resultSet.next()) {
				Book book = new Book(
						resultSet.getString("title"),
						resultSet.getString("author"),
						resultSet.getInt("publicationYear"),
						resultSet.getString("isbn"),
						resultSet.getDouble("price")
				);
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void updateBook(int id, Book book) {
		String updateSQL = "UPDATE books SET title = ?, author = ?, publicationYear = ?, isbn = ?, price = ? WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setInt(3, book.getPublicationYear());
			preparedStatement.setString(4, book.getIsbn());
			preparedStatement.setDouble(5, book.getPrice());
			preparedStatement.setInt(6, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
		String deleteSQL = "DELETE FROM books WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
