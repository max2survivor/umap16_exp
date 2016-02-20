/**
 * 
 */
package topics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * @author ould
 *
 */
public class QueryDocumentTopical {

	/**
	 * @param args
	 * 
	 * cette classe permet de cr�er de retrouver tout les documents elatifs a un tag pour un user 
	 */
	

	static org.jdom2.Document document;
	static Element racine;

	public static void main(String[] args) throws IOException {
		
		
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			document = sxb.build(new File("topics_bibsonomy_new_200.xml"));
		}
		catch(Exception e){}
		racine = document.getRootElement();
		List<Element> listQuery = racine.getChildren("TOP");
		Iterator<Element> i = listQuery.iterator();
		while(i.hasNext())		
		{
			String user = "";
			String query = "";
			Element courant = i.next();
			query = courant.getChild("TITLE").getText();
			user = courant.getChild("USER").getText();
			FileWriter f = new FileWriter("./corpus_users_doc/"+user+".txt");
			Scanner sc_user = new Scanner(new File("./corpus_users/"+user+".txt"));
			while (sc_user.hasNextLine()) {
				String vect = sc_user.nextLine();
				String [] line = vect.split("\t");
				if(line[1].equals(query)){
					//System.out.println(vect);
					System.out.println(courant.getChild("NUM").getText()+" "+query+" "+ line[2]);
					f.write(courant.getChild("NUM").getText()+" "+query+" "+ line[2]+"\n");
					f.flush();
				}
				
			}
			sc_user.close();
			f.close();
			
		}
	}

}
