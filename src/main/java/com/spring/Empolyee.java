package com.spring;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Dao;
import com.iempolye.IEmployee;
import com.jdbc.DaoJdbc;
import com.pojo.Pojo;

@Controller
public class Empolyee {
	@Autowired
	private IEmployee d;
	// register
	@RequestMapping(value = "/gotoweb", method = RequestMethod.POST)
	public String mapping(Pojo p) {
/*		Service s = new Service();
		s.Register(p);
*/		/* Dao d=new Dao(); hibernate*/
		 /*DaoJdbc d = new DaoJdbc();*/
		d.mapping(p);
		return "login";
	}

	// login
	@RequestMapping(value = "/go", method = RequestMethod.POST)
	public String login(Pojo p, Model model) throws ClassNotFoundException, SQLException {
		/*Service service = new Service();
		String result = service.login(p, model);*/
		/* Dao l = new Dao(); */
		/*DaoJdbc d = new DaoJdbc();*/
		List<Pojo> list = d.login(p);

		if (list.isEmpty()) {
			model.addAttribute("message", "Invalid Credentials!! Please try again ");
			return "login";
		} else {

			/* Dao dao2 = new Dao(); */
			List<Pojo> getall = d.getall1(p);
			model.addAttribute("message", getall);
			return "profile";
		}
	}

	// delete
	@RequestMapping(value = "/deleteEmployee")
	public String delete(@RequestParam("gamil") String gamil,Pojo p, Model model) throws ClassNotFoundException, SQLException {
		System.out.println(gamil);
		/*Service s = new Service();
		String delete = s.delete(gamil,p,model);*/
		/*Dao d = new Dao();*/
		/*DaoJdbc d = new DaoJdbc();*/
		d.delete(gamil,p);

		
		  Dao d2 = new Dao(); 
		  List<Pojo> getall = d2.getall();
		  model.addAttribute("message", getall);
		 
		return "profile";

		// System.out.println(executeUpdate);

	}

	// deleteall
	@RequestMapping(value = "/deleteall", method = RequestMethod.POST)
	private String deleteall(@RequestParam("gamil") String gmail, Model mod) {
		System.out.println("method done");
		/*Service s = new Service();
		String deleteall = s.deleteall(gmail, mod);*/
		Dao d = new Dao();
		d.deleteall(gmail);

		/*
		 * Dao d2 = new Dao(); List<Pojo> list = d2.getall();
		 * mod.addAttribute("message", list);
		 */
		return "profile";
		

	}
}