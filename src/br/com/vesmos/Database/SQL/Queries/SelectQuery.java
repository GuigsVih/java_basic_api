package br.com.vesmos.Database.SQL.Queries;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 
 * @author Guilherme Vilela Oliveira <guivo11@gmail.com> *
 */
public class SelectQuery extends BaseQuery 
{
	List<String> select = new ArrayList<String>();
	List<String> from = new ArrayList<String>();
	List<String> where = new ArrayList<String>();
	List<String> join = new ArrayList<String>();
	List<String> orderBy = new ArrayList<String>();
	List<String> groupBy = new ArrayList<String>();
		
	public SelectQuery(
			List<String> select, 
			List<String> where, 
			List<String> join, 
			List<String> orderBy, 
			List<String> groupBy,
			String from
			)
	{
		this.select  = select;
		this.where   = where;
		this.join    = join;
		this.orderBy = orderBy;
		this.groupBy = groupBy;
		this.from.add(from);
	}
	
	/**
	 * Build select query
	 * 
	 * @return String
	 */
	public String build()
	{
		StringJoiner buffer = new StringJoiner(" ");
		createQuery(buffer, "SELECT", ", ");
		return "";
	}
}
