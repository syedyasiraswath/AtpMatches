/**
 * 
 */
package com.titaniam.demo.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

/**
 * @author Syedyasiraswath
 *
 */
@Configuration
public class FileReaderConfig {

	Logger logger = LoggerFactory.getLogger(FileReaderConfig.class);

	@Value("${asp.document.location}")
	private String docPath;

	@PostConstruct
	public void init() throws SQLException, IOException, CsvException {
		File myDirectory = new File(docPath);
		String[] containingFileNames = myDirectory.list();
		Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		try  {
			List<String[]> resultList = null;
			Integer primKey = 1;
			for (String fileName : containingFileNames) {
				logger.info("File Name : {}", fileName);
				if (null != fileName && fileName.length() > 0 && fileName.contains("atp_matches_")) {
					try (CSVReader reader = new CSVReaderBuilder(new FileReader(docPath + fileName))
							.withCSVParser(getCSVParser()).build()) {
						resultList = reader.readAll();
						PreparedStatement stmt = connection.prepareStatement(
								"INSERT INTO ATP_MATCHES (ID_ATP, TOURNEY_ID, TOURNEY_NAME, SURFACE, TOURNEY_YEAR, WINNER_ID, WINNER_NAME, WINNER_IOC, LOSER_ID, LOSER_NAME, LOSER_IOC"
								+ ",ROUND"
								+ ") \r\n"
										+ "VALUES (?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?)");
						try {
							Integer listIndex = 0;
							for (String[] arr : resultList) {
								if (listIndex != 0 && null != arr[2]) {
									stmt.setLong(1, primKey);
									stmt.setString(2, arr[0]);
									stmt.setString(3, arr[1]);
									stmt.setString(4, arr[2]);
									if (null != arr[5] && arr[5].length() > 4) {
										String year = arr[5].substring(0, 4);
										stmt.setLong(5, Long.parseLong(year));
									}
									stmt.setLong(6, Long.parseLong(arr[7]));
									stmt.setString(7, arr[10]);
									stmt.setString(8, arr[13]);
									stmt.setLong(9, Long.parseLong(arr[15]));
									stmt.setString(10, arr[18]);
									stmt.setString(11, arr[21]);
									stmt.setString(12, arr[25]);
									stmt.execute();

								}
								primKey++;
								listIndex++;
							}
							//stmt.execute();
						} finally {
							stmt.close();
						}
					}
				}
			}
		} finally {
			connection.close();
		}
	}

	private CSVParser getCSVParser() {
		return new CSVParserBuilder().withSeparator(',').build();
	}

}
