package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.RecruitDAO;
import entity.Recruit;
import entity.User;
import sql.GetSQLYuJu;

@SuppressWarnings("all")
public class RecruitDAOImpl implements RecruitDAO {
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveRecruit(Recruit recruit) {
		if (hibernateTemplate.save(recruit) != null)
			return true;
		return false;
	}

	@Override
	public boolean deleteRecruit(Recruit recruit) {
		try {
			if (hibernateTemplate.get(Recruit.class, recruit.getR_id()) == null) {
				return false;
			} else {
				hibernateTemplate.delete(hibernateTemplate.get(Recruit.class, recruit.getR_id()));
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 只更新状态
	 */
	@Override
	public boolean UpdateRecruit(String[] ids, String userStatus) {
		System.out.println("hh**&&" + ids[0].toString() + "####" + userStatus);
		// String ne = StringUtils.join(ids, ",");
		// System.out.println("neeeee"+ne);
		// List<long> list = new List<long>();
		// list = ne.Split(',').ToList().ConvertAll(s => long.Parse(s));
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query query = session.createSQLQuery(GetSQLYuJu.RECRUIT_UPDATE_MUL);
			query.setInteger(0, Integer.parseInt(userStatus));
			query.setParameterList("ids", ids);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			session.close();
		}
		return false;
	}

	@Override
	public List<Recruit> getAllRecruit(String userStatus) {
		if (userStatus.equals("all")) {
			String sql = GetSQLYuJu.RECRUITPART_ALL_COUNTABLE;
			return (List<Recruit>) hibernateTemplate.find(sql);
		} else {
			Integer temp = Integer.parseInt(userStatus);
			String sql = GetSQLYuJu.RECRUITPART_ALL;
			return (List<Recruit>) hibernateTemplate.find(sql, temp);
		}
	}

	@Override
	public List<Recruit> getPartRecruit(String data) {
		return (List<Recruit>) hibernateTemplate.find(GetSQLYuJu.RECRUITPART, "%" + data + "%");
	}

	@Override
	public Recruit getRecruit(Recruit recruit) {
		if (hibernateTemplate
				.find(GetSQLYuJu.RECRUITOBJECT, new String[] { recruit.getName(), recruit.getR_id().toString() })
				.size() == 0)
			return null;
		return (Recruit) hibernateTemplate
				.find(GetSQLYuJu.RECRUITOBJECT, new String[] { recruit.getName(), recruit.getR_id().toString() })
				.get(0);
	}

	@Override
	public Recruit access(User user) {
		System.out.println("u((" + user.getAccount() + "  " + user.getEmail());
		return (Recruit) hibernateTemplate.find(GetSQLYuJu.RECRUIT_PASS_EMAIL, user.getAccount(), user.getEmail())
				.get(0);
	}

}
