package tw.idv.ixercise.course.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.ixercise.course.dao.CourseAttendeeDao;
import tw.idv.ixercise.course.entity.CourseAttendee;

@Repository
public class CourseAttendeeDaoImpl implements CourseAttendeeDao {

	@PersistenceContext
	private Session session;

	@Override
	public int insertCourseAttendee(CourseAttendee courseAttendee) {
		session.persist(courseAttendee);
		return 1;
	}

	@Override
	public int deleteByAttendId(Integer attendId) {
		CourseAttendee courseAttendee=session.load(CourseAttendee.class, attendId);
		session.remove(courseAttendee);
		return 1;
	}

	@Override
	public int updateByAttendId(Integer attendId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CourseAttendee> selectByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseAttendee> selectByaccountId(Integer accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
