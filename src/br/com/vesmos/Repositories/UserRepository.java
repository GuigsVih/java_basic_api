package br.com.vesmos.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;

import br.com.vesmos.Database.SQL.SQL;
import br.com.vesmos.Models.User;

public class UserRepository
{
	public Boolean authenticate(User user)
	{
		return false;
	}
	
	public GenericEntity<List<User>> getUser(int id) throws SQLException
	{
		List<User> userList = new ArrayList<User>();
		SQL query = new SQL();
		ResultSet result = query
				.select("users.name", "users.email")
				.from("users")
				.get();
		
		while (result.next()) {
			String name = result.getString("name");
			String email = result.getString("email");
			userList.add(new User(name, email));
		}
		return new GenericEntity<List<User>>(userList) {};
	}
}
