package stats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UsersStats {


	public static void main(String[] args) throws IOException {

		
		

	}


	/**
	 * cette méthode permet de retourner les stats sur l'utilisateur : 
	 * user + nombre_de_doc + nombre_de_book
	 * @throws IOException
	 */
	public static void getDocuBookStatUser() throws IOException{

		BufferedReader user  = new BufferedReader(new FileReader("./files/users_id"));		
		String line = "";	
		while ((line = user.readLine()) != null) {	
			ArrayList<String> list_user_doc= new ArrayList<>();		
			ArrayList<String> list_user_boo= new ArrayList<>();
			BufferedReader user_file = new BufferedReader(new FileReader("./corpus_users/"+line));		
			String file = "";
			while ((file = user_file.readLine()) != null) {
				String [] vect = file.split("\t");
				if(!list_user_doc.contains(vect[2]))
					list_user_doc.add(vect[2]);
				list_user_boo.add(vect[2]);
			}
			user_file.close();

			if(!list_user_doc.isEmpty())
				System.out.println(line+" "+list_user_doc.size()+" "+list_user_boo.size());
		}
		user.close();
	}

}
