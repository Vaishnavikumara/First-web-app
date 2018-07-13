


import static org.junit.Assert.fail;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;

@SuppressWarnings("unused")
public class Entities {
	
	

	private static DatastoreService datastore;
	public static Key key;
	static Entity e3 = null;
	static String uname = null;
	static String password = null;
	
	//datastore = DatastoreServiceFactory.getDatastoreService();
	
	
	
	 public static boolean kindExample_writesEntity(String n,String a,String i,String p) throws Exception {
		    // [START kind_example]
		    Entity employee = new Entity("Employee", i);
		    employee.setProperty("Pin", p);
		    employee.setProperty("Name", n);
		    employee.setProperty("Age", a);
		    
		    //employee.setProperty("lastName", "Salieri");
		    //employee.setProperty("hireDate", new Date());
		    //employee.setProperty("attendedHrTraining", true);
		    

		     datastore = DatastoreServiceFactory.getDatastoreService();
		    datastore.put(employee);
		    key = KeyFactory.createKey("Employee", i);
		    
		    String j = KeyFactory.keyToString(key);
		    
		    
		    
		   // key = employee.getKey();
		    
		    System.out.println("key is :"+employee.getKey());
		    System.out.println("String value is :"+j);
		    
		    
		    System.out.println("Key from String is :"+KeyFactory.stringToKey(j));
		   // datastore.delete(key);
		    
		    
		    return true;
}

	/*  public static void retrieve(String i) {
		  try {
			Entity e = datastore.get(key);
			System.out.println(e);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }*/
	  
	@SuppressWarnings("deprecation")
	public static boolean login_user(String u , String p)throws NullPointerException {
		
		
		
		String user = u;
		String password = p;//global variable
		//Entity e = new Entity("Employee");
		System.out.println("User inside function :"+user+"Password is :"+password);
		/*Filter newFilter = new FilterPredicate("Name", FilterOperator.EQUAL, user);
		Query q =  new Query("Employee").setFilter(newFilter);
		PreparedQuery pq = datastore.prepare(q);
		Entity storedUser = pq.asSingleEntity();
		
		System.out.println(storedUser);
		String storedPassword = (String) storedUser.getProperty("Pin");*/
		
		datastore = DatastoreServiceFactory.getDatastoreService();
		 Query q = new Query("Employee").addFilter("Name", FilterOperator.EQUAL,user);
		    PreparedQuery pq = datastore.prepare(q);
		    
		    for(Entity ei : pq.asIterable()) {
		    	String username = ei.getProperty("Name").toString();
		    	int Age = Integer.valueOf((String) (ei.getProperty("Age")));
		    	password = (String) ei.getProperty("Pin");
		    	System.out.println("The username is "+username+"Age :"+Age+"Password "+password);
		    	
		    }
		    
		if (p.equals(password)) { 
		  //correct password
			return true;
		}
		else
		{
			return false;
		}
		
		
		
		
	}
	

	public static  void delete(String i) throws Exception   {
		 System.out.println("To be deleted id is :"+i);
		  
		Key  k = KeyFactory.createKey("Employee",i);
		
		datastore = DatastoreServiceFactory.getDatastoreService();
		   
		 //Entity e3= datastore.get(k);
		 System.out.println(k);
		
		 datastore.delete(k);
		// fail("Entity not found exception");
	
		 
		 }
	
	
	//retrieve a record

	public static Entity retrieve(String i) {
	
		datastore = DatastoreServiceFactory.getDatastoreService();
		Key k = KeyFactory.createKey("Employee", i);
		try {
			 e3 = datastore.get(k);
			System.out.println(e3);
			//Object name = e3.getProperty("user");
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e1) {
			e1.printStackTrace();
		}
		//System.out.println("Name is :"+e3.getProperty("Name"));
		//return (e3.getProperty("Name"));
		
		return e3;
		
	}
	
	
		
	  }

	

	 