package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.iempolye.IEmployee;
import com.pojo.Pojo;

//register
public class Dao implements IEmployee {
	public void mapping(Pojo p) {
		System.out.println("enter registerdao ");
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session Session = sessionFactory.openSession();
		Session.save(p);
		Session.beginTransaction().commit();

	}

	// login
	public List<Pojo> login(Pojo p) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session Session = sessionFactory.openSession();
		Query query = Session.createQuery("from Pojo where gamil=:gamil and password=:password");
		query.setParameter("gamil", p.getGamil());
		query.setParameter("password", p.getPassword());
		List<Pojo> l = query.list();
		return l;

	}

	public List<Pojo> getall1(Pojo p) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session Session = sessionFactory.openSession();
		Query queryAll = Session.createQuery("from Pojo");
		List<Pojo> list = queryAll.list();
		return list;

	}

	// delete
	public void delete(String gamil,Pojo p)
	 {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session Session = sessionFactory.openSession();
		Query query = Session.createQuery("delete from Pojo where gamil=:gamil");
		query.setParameter("gamil", gamil);
		int executeUpdate = query.executeUpdate();
		Session.beginTransaction().commit();
	}

	// deleteall
	public void deleteall(String gamil) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session Session = sessionFactory.openSession();
		String[] split = gamil.split(",");
		for (String list : split) {
			Query query = Session.createQuery("delete from Pojo where gamil=:gmail");
			System.out.println("query done");
			query.setParameter("gmail", list);
			int i = query.executeUpdate();
			System.out.println(i);
			Session.beginTransaction().commit();
		}
	}

	public List<Pojo> getall() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session Session = sessionFactory.openSession();
		Query queryAll = Session.createQuery("from Pojo");
		List<Pojo> list = queryAll.list();
		return list;

	}
}