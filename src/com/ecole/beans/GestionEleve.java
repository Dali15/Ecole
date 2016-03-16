package com.ecole.beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecole.models.Eleve;

public class GestionEleve {
	
		private List eleves;
		private Connecteur c = new Connecteur();
		private Eleve eleve;
		private ResultSet r ;

		
		
		
		
		public List getEleve(String choix, String data ) {
			eleves=new ArrayList();
			
			if (c.connect()){
				if(choix.equals("nom")){
					r =c.exec("select * from eleve where nom='"+data+"'");
				}
				else if(choix.equals("prenom")){
					r =c.exec("select * from eleve where prenom='"+data+"'");
				}
				else if (choix.equals("date_naissance")){
					r =c.exec("select * from eleve where prenom='"+data+"'");
				}else if (choix.equals("matricule")){
					r =c.exec("select * from eleve where matricule='"+data+"'");
				}else if (choix.equals("date_naissance")){
					r =c.exec("select * from eleve where date_naissance='"+data+"'");
				}else if (choix.equals("tout")){
					r =c.exec("select * from eleve ");
				}
				else {
					r=null;
				}
			
				try{	
					if(r!=null){		
						while(r.next()){
						 eleve = new Eleve();
						 eleve.setMatricule(r.getString("matricule"));
						 eleve.setNom(r.getString("nom"));
						 eleve.setPrenom(r.getString("prenom"));
						 eleve.setDate_naissance(r.getString("date_naissance"));
						 eleve.setAddresse(r.getString("adresse"));		
						 eleves.add(eleve);
						 
						}
						
				}				
				}
				catch (SQLException e) {
					System.out.println("requet feha mochkla");
					e.printStackTrace();
						
				}
				c.close();
							
			}
			else{
				System.out.println("Probleme de connexion BD");
				c.close();
			}
			return eleves;
		}

		public int setEleve(Eleve eleve) {
			
			if(c.connect()){
				int valeur=c.update("insert into eleve values('"+eleve.getNom()+"','"+eleve.getPrenom()+"','"+eleve.getMatricule()+"','"+eleve.getAddresse()+"','"+eleve.getDate_naissance()+"')");
				c.close();
				return valeur;
			}
			else{
				System.out.println("Probleme de connexion BD");
				return 0;
			}
			
			
		}
		public int updateEleve(String matricule, String colone, String data) {
			if(c.connect()){
						return c.update("update eleve set "+colone+"= '"+data+
										"' where matricule = '"+matricule+"'");
						
			}
			else{
				System.out.println("Probleme de connexion BD");
				return 0;
			}
		}

		
		
}
