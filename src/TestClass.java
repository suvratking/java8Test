import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class TestClass {

	public static void main(String[] args) {
		Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); //fully quilified path ldap jndi
		ldapEnv.put(Context.PROVIDER_URL, "ldap://localhost:10389");//specify the port number and ip of apache server
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL,"uid=admin,ou=system"); // specify the username
		ldapEnv.put(Context.SECURITY_CREDENTIALS,"secret");// specify the password

		System.out.println("connction creted successfully");

		try {
			DirContext context= new InitialDirContext(ldapEnv);
		} catch (NamingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		Attributes attributes = new BasicAttributes();
		Attribute attribute = new BasicAttribute("objectClass");
		attribute.add("inetOrgPersion");
		attributes.put(attribute);

		Attribute cn = new BasicAttribute("cn"); //common name  
		cn.add("jhon");
		Attribute sn = new BasicAttribute("sn");  //sur name
		sn.add("smith");

		attributes.put(cn);
		attributes.put(sn);

		attributes.put("mobileNumber", "123456");
		attributes.put("employeeNumber=1, ou=users, ou=systems", attributes);

		System.out.println("data inserted successfully");

	}

}
