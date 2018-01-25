package db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;


public class FrameWork {
	Connection con;

	public FrameWork() {
		con = DbConnection.getInstance().getDBcon();
	}

	// This method inset information into the database
	// The function works by you applying a table name and a object to update.
	public <T> void addToDatabase(String tableName, T objectToBuild) {

		try {
			String addQuery = addQuery(tableName, objectToBuild);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(addQuery);
			stmt.close();
		} catch (Exception e) {
			System.out.println("Query exception: " + e);
		}

	}

	// columnValue needs to come from the GUI and get insertet into the method
	// parameter.
	// the function works by parameter Table Name and what column, the
	// columnValue.
	public void deleteFromDatabase(String tableName, String whatColumn, String columnValue) {
		try {
			String deleteQuery = deleteQuery(tableName, whatColumn, columnValue);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(deleteQuery);
			stmt.close();
		} catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
	}

	//Finds the Object from the database
	public <T> T findFromDatbase(T clazz, String whatColumn, String columnValue) {
		ResultSet results;
		T obj = null;
		try {
			String findQuery = findQuery(clazz, whatColumn, columnValue);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(findQuery);
			obj = buildObject(results, clazz);
			stmt.close();
		} catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return (T) obj;
	}

	public String deleteQuery(String tableName, String whatColumn, String columnValue) {
		return "DELETE FROM " + tableName + " WHERE " + whatColumn + " = " + columnValue + ";";
	}

	public String addQuery(String tableName, Object obj) {
		return "INSERT INTO " + tableName + "(" + getStringClassFileds(obj) + ") " + "VALUES ('" + getObjectValues(obj)
				+ ")";
	}

	public <T> String findQuery(T clazz, String whatColumn, String columnValue) {
		return "select * from " + ((Class) clazz).getSimpleName() + " where " + whatColumn + "= '" + columnValue + "';";
	}

	
	public <T> String getStringClassFileds(T obj) {
		Field[] myFields = getAllClassFields(obj);
		String myString = "";
		for (int i = 1; i < myFields.length; i++) {
			myString += "\"" + myFields[i].getName() + "\",";
		}
		myString = myString.substring(0, myString.length() - 1);
		return myString;
	}

	public String getObjectValues(Object obj) {
		String myString = "";
		Field[] myFields = getAllClassFields(obj);
		for(int i = 1; i < myFields.length; i++){
			Field field = null;
			try {
				field = obj.getClass().getDeclaredField(myFields[i].getName());
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			field.setAccessible(true);
			try {
				myString += field.get(obj) + "','";

			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		myString = myString.substring(0, myString.length() - 2);
		return myString;
	}

	public Field[] getAllClassFields(Object obj) {
		return obj.getClass().getDeclaredFields();
	}

	public <T> T buildObject(ResultSet results, T clazz) {
		T obj = null;
		try {
			Class<?> cls = Class.forName("ModelLayer." + ((Class) clazz).getSimpleName());

			Constructor[] constructors = cls.getDeclaredConstructors();

			for (Constructor ctor : constructors) {
				
					if (results.next()) {
						Object[] testList = new Object[ctor.getParameterCount()];
						Class<?>[] pType  = ctor.getParameterTypes();
						for (int x = 0; x < ctor.getParameterCount(); x++) {
							if(pType[x].getName() == "int"){
								testList[x] = results.getInt(x+1);	
							}
							else {
								testList[x] = results.getString(x+1);
							}
							//Need all datatype here as a switch
						}
							obj = (T) ctor.newInstance(testList);
							return obj;
					}
			}
		} catch (

		Exception e) {
			System.out.print(e.getMessage());
		}
		return obj;
	}


}