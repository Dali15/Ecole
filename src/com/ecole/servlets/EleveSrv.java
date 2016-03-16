package com.ecole.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecole.beans.GestionEleve;
import com.ecole.models.Eleve;
import com.google.gson.Gson;

/**
 * Servlet implementation class Eleve
 */
//@WebServlet("/Eleve")
public class EleveSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleveSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("testID"));
		GestionEleve g = new GestionEleve(); 
		List l = new ArrayList();
		List l2 = new ArrayList();
		l2.add("nom");
		l2.add("prenom");
		l2.add("yoyo");
		  
		//l=g.getEleve("matricule", "d7666c67-649e-4835-8a83-f1e65e959c32");// Product is just a Javabean with properties `id`, `name` and `description`.
		l=g.getEleve("tout","");
		Eleve e = (Eleve) l.get(0);
		System.out.println(e.getAddresse());
		request.setAttribute("listData", l);
		request.setAttribute("listData2", l2);
		
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/tables.jsp");
	    rd.forward(request, response);
		
		
		
		
		/*String json = new Gson().toJson(l);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
