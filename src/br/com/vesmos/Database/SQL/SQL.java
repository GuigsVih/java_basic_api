package br.com.vesmos.Database.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SQL Builder
 * 
 * @author Guilherme Vilela Oliveira <guivo11@gmail.com>
 * @param <T>
 */
public class SQL extends AbstractSQL
{
	@Override
	public ResultSet get() throws SQLException {
			String query = this.getQueryString();
			return execute(query);
	}
}
