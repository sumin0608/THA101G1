package tw.idv.ixercise.report.dao.impl;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import tw.idv.ixercise.report.dao.articleDao;
import tw.idv.ixercise.report.entity.Article;

@Repository
public class articleDaoImpl implements articleDao{
	
	@PersistenceContext
	private Session session;
	
	
	
	public int insert(Article member) {
		session.persist(member);
		return 1;
	}

	
	public int deleteById(Integer id) {
		Article article = session.load(Article.class, id);
		session.remove(article);
		return 1;
	}


//	public int update(Article article) {
//		final StringBuilder hql = new StringBuilder()
//				.append("UPDATE Article SET ");
//		final String password =article.getPassword();
//		if (password != null && !password.isEmpty()) {
//			hql.append("password = :password,");
//		}
//		final byte[] img = article.getImage();
//		if (img != null && img.length != 0) {
//			hql.append("image = :image,");
//		}
//		hql.append("nickname = :nickname,")
//			.append("pass = :pass,")
//			.append("roleId = :roleId,")
//			.append("updater = :updater,")
//			.append("lastUpdatedDate = NOW() ")
//			.append("WHERE username = :username");
//		Query query = session.createQuery(hql.toString());
//		if (password != null && !password.isEmpty()) {
//			query.setParameter("password", member.getPassword());
//		}
//		if (img != null && img.length != 0) {
//			query.setParameter("image", img);
//		}
//		return query.setParameter("nickname", member.getNickname())
//				.setParameter("pass", member.getPass())
//				.setParameter("roleId", member.getRoleId())
//				.setParameter("updater", member.getUpdater())
//				.setParameter("username", member.getUsername())
//				.executeUpdate();
//	}

	


//	public List <Article> selectAll() {
//		final String hql = "FROM Article ORDER BY articleId";
//		return session
//				.createQuery(hql, Article.class)
//				.getResultList();
//	}


	public List <Article> selectAll() {
		final String hql = "SELECT new tw.idv.ixercise.report.entity.Article(articleId, accountId, articleTitle, articleTime, articleState, articleType) FROM Article ";
		return session
				.createQuery(hql, Article.class)
				.getResultList();
	}

	


@Override
public Article selectById(Integer id) {
	return session.get(Article.class, id);
}




//	@Override
//	public Member selectByUsername(String username) {
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
//		Root<Member> root = criteriaQuery.from(Member.class);
//		criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
//		return session.createQuery(criteriaQuery).uniqueResult();
//	}
//
//	@Override
//	public Member selectForLogin(String username, String password) {
//		final String sql = "select * from MEMBER "
//				+ "where USERNAME = :username and PASSWORD = :password";
//		return session.createNativeQuery(sql, Member.class)
//				.setParameter("username", username)
//				.setParameter("password", password)
//				.uniqueResult();
//	}
//
//	@Override
//	public Article selectById(int articleId) {
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article .class);
//		Root<Article > root = criteriaQuery.from(Article.class);
//		criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
//		return session.createQuery(criteriaQuery).uniqueResult();
//	}

	
}
