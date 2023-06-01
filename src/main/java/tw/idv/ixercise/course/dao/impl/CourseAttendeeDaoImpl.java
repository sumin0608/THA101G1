package tw.idv.ixercise.course.dao.impl;

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
	public int deleteByattendId(Integer attendId) {
		CourseAttendee courseAttendee=session.load(CourseAttendee.class, attendId);
		session.remove(courseAttendee);
		return 1;
	}

}
