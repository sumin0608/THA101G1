package tw.idv.ixercise.course.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import tw.idv.ixercise.course.dao.CourseDao;
import tw.idv.ixercise.course.entity.Course;
import tw.idv.ixercise.course.entity.DistrictsDto;

@Repository
public class CourseDaoImpl implements CourseDao {
	@PersistenceContext
	private Session session;

	@Override
	public int insertCourse(Course course) {
		session.persist(course);
		return 1;
	}

	@Override
	public int deleteByCourseId(Integer courseId) {
		Course course = session.load(Course.class, courseId);
		session.remove(course);
		return 1;
	}

	@Override
	public int upateByCourseId(Course course) {
		final StringBuilder hql = new StringBuilder().append("UPDATE course SET ");

		hql.append("eventName = :eventName,").append("expectedPrice = :expectedPrice,")
				.append("courseStartDate = :courseStartDate,").append("courseStartTime = :courseStartTime,")
				.append("courseDuration = :courseDuration,").append("registrationDeadline = :registrationDeadline,")
				.append("maximumCapacity = :maximumCapacity,").append("description = :description,");
		if (course.getPhoto() != null) {
			hql.append("photo = :photo,");
		}
		hql.append("location = :location,").append("city = :city,").append("district = :district,")
				.append("detailedAddress = :detailedAddress,").append("categoryId = :categoryId,")
				.append("courseStatus = :courseStatus,")
				.append("paidAdvertising = :paidAdvertising,")
				.append("paidAdvertisingTime = :paidAdvertisingTime,")
				.append("courseCreationDate = NOW() ").append("WHERE courseId = :courseId");
		
		Query query = session.createQuery(hql.toString());
		query.setParameter("eventName", course.getEventName())
			.setParameter("expectedPrice", course.getExpectedPrice())
			.setParameter("courseStartDate", course.getCourseStartDate())
			.setParameter("courseStartTime", course.getCourseStartTime())
			.setParameter("courseDuration", course.getCourseDuration())
			.setParameter("maximumCapacity", course.getMaximumCapacity());
		
		if (course.getPhoto() != null) {
			query.setParameter("photo", course.getPhoto());
		}
		
		query.setParameter("location", course.getLocation())
			.setParameter("city", course.getCity())
			.setParameter("district", course.getDistrict())
			.setParameter("district", course.getDistrict())
			.setParameter("detailedAddress", course.getDetailedAddress())
			.setParameter("courseStatus", course.getCourseStatus())
			.setParameter("paidAdvertising", course.getPaidAdvertising())
			.setParameter("paidAdvertisingTime", course.getPaidAdvertisingTime())
			.setParameter("courseId", course.getCourseId());

		return query.executeUpdate();
	}

	@Override
	public List<Course> selectByName(String eventName) {
		String sql = "SELECT * FROM course WHERE eventName = :eventName";
		return session.createNativeQuery(sql, Course.class).setParameter("eventName", eventName).getResultList();
	}

	@Override
	public Course selectByCourseId(Integer cocurseId) {
		String sql = "SELECT * FROM course WHERE cocurseID = :cocurseId";
		return session.createNativeQuery(sql, Course.class).setParameter("cocurseId", cocurseId).uniqueResult();
	}

	@Override
	public List<Course> selectBycategoryId(String categoryId) {
		String sql = "SELECT * FROM course WHERE categoryID = :categoryId";
		return session.createNativeQuery(sql, Course.class).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Course> selectByCity(String city) {
		String sql = "SELECT * FROM course WHERE city = :city";
		return session.createNativeQuery(sql, Course.class).setParameter("city", city).getResultList();
	}

	@Override
	public List<Course> selectByCreator(Integer creator) {
		String sql = "SELECT * FROM course WHERE creator = :creator";
		return session.createNativeQuery(sql, Course.class).setParameter("creator", creator).getResultList();
	}

	@Override
	public List<Course> selectAll() {
		final String sql = "SELECT * FROM course";
		return session.createNativeQuery(sql, Course.class).getResultList();
	}

	@Override
	public List<DistrictsDto> getDistricts(String city) {
		final String sql = "SELECT * FROM districts WHERE id LIKE :cityPrefix";
	    return session.createNativeQuery(sql, DistrictsDto.class)
	            	.setParameter("cityPrefix", city + "%")
	            	.getResultList();
	}

}
