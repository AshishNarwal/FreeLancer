package com.cts.freelancer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.freelancer.bean.Admin;

@Repository("adminLoginDAO")
@org.springframework.transaction.annotation.Transactional(propagation= Propagation.SUPPORTS)
public class AdminLoginDAOImpl implements AdminLoginDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public boolean authenticate(String emailId, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Admin where emailId=? and password=?");
		query.setParameter(0,emailId);
		query.setParameter(1,password);
		Admin admin=(Admin)query.getSingleResult();
		if(admin==null)
			return false;
		else
		return false;
	}

	@Transactional
	public boolean registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(admin);
		
		return true;
	}

	
}
