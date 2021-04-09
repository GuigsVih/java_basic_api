package br.com.vesmos.Database.SQL;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Guilherme Vilela Oliveira <guivo11@gmail.com>
 */
public class Statment 
{
	public static enum SQLTypes {
		SELECT, INSERT, UPDATE, DELETE		
	};
	
	SQLTypes type;
	List<String> select  = new ArrayList<String>();
	List<String> where   = new ArrayList<String>();
	List<String> join    = new ArrayList<String>();
	List<String> orderBy = new ArrayList<String>();
	List<String> groupBy = new ArrayList<String>();
	String from;
}
