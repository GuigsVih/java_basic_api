package br.com.vesmos.Database.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import br.com.vesmos.Database.ConnectionFactory;
import br.com.vesmos.Database.SQL.Queries.SelectQuery;

/**
 * Abstract sql functions
 * 
 * @author Guilherme Vilela Oliveira <guivo11@gmail.com>
 *
 */
public abstract class AbstractSQL extends ConnectionFactory
{	
	Statment sql = new Statment();
	
	public abstract ResultSet get() throws SQLException;
	
	public AbstractSQL select(String... columns) 
	{
		sql().type = Statment.SQLTypes.SELECT;
		sql().select.addAll(Arrays.asList(columns));
		return this;
	}
	
	public AbstractSQL from(String table)
	{
		sql().from = table;
		return this;
	}
	
	public String getQueryString()
	{
		String query;
		
		switch (sql().type) {
			case SELECT:
				SelectQuery queryBuilder = new SelectQuery(
						sql().select, 
						sql().where, 
						sql().join, 
						sql().orderBy, 
						sql().groupBy,
						sql().from
						);
				query = queryBuilder.build();
				break;
			default:
				query = null;
				break;
		}
		
		return query;
	}
	
	private Statment sql() 
	{
		return sql;
	}
}
