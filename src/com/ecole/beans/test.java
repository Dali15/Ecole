package com.ecole.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecole.models.Eleve;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		GestionEleve g = new GestionEleve();
	   Eleve e = new Eleve();
	   
	   e.setPrenom("khalil");
	   e.setNom("saidi");
	   e.setMatricule("9c2c5ded-0a21-4f15-b44b-24ce034feb6e");
	   e.setDate_naissance("1990-06-19");
	   e.setAddresse("5 rue ankara mourouj 4 ben arous");
	   
	   //g.setEleve(e);
	   
	   List l = new ArrayList();
	  
	   l=g.getEleve("matricule", "9c2c5ded-0a21-4f15-b44b-24ce034feb6");
	   if(l.size()!=0){
	   for (int i = 0; i < l.size(); i++)
	   {
		   System.out.println(((Eleve)l.get(i)).getPrenom());
	       
	   }}
	   else System.out.println("Aucun eleves");

	   
	   
	   /*if(g.updateEleve("d7666c67-649e-4835-8a83-f1e65e959c32", "prenom", "mohamed")==1){
	   e=g.getEleve("nom", "saidi");
	   System.out.println(e.getAddresse());
	   }else
		   System.out.println("erreur dans l'update");*/
	   
		
		
		
		
/*		Connecteur c = new Connecteur();

		if (c.connect()){
			 ResultSet r = c.exec("select * from test");
			 try{	
			 if(r!=null){		
					 r.next();
						 System.out.println(r.getString("titre"));
				
					 }}
			 catch (SQLException e) {
				 System.out.println("requet feha mochkla");
						e.printStackTrace();
						
					}
				
		}
	*/	

	}

}
