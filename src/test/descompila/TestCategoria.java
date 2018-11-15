package test.descompila;

import main.descompila.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.SourceType;

import connection.descompila.ConnectionFactory;
import descompila.dao.CategoriaDAO;

public class TestCategoria {

	public static void main(String[] args) {

		CategoriaDAO dao = new CategoriaDAO();
		
		/*
		//save
		Categoria cs = new Categoria();
		cs.setDescricao("Alimento 1");
		cs.setValor(14.0);
		
		dao.save(cs);
		
		
		//update
		Categoria cu = new Categoria();
		cu.setId(4);
		cu.setDescricao("Bebidas 4");
		cu.setValor(20);		

		dao.update(cu);
		*/
		
		
		//find
		/*
		Categoria cf = dao.findById(5);
		System.out.println("Descrição do ID: " +cf.getDescricao());
		*/
		
		
		// list all/		
		for (Categoria cla: dao.findAll()) {
			System.out.println("Id: " + cla.getId() + "\tDescricao: " +cla.getDescricao());
		}
		
		
		
		//remove
		//dao.remove(5);
		
		
	}
	
}
