package tw.idv.ixercise.course.dao;

import org.springframework.data.jpa.repository.*;
import tw.idv.ixercise.course.entity.*;

import java.util.*;

public interface CourseAndAttendeesRepository extends JpaRepository<CourseAndAttendeesEntity, Integer> {


    List<CourseAndAttendeesEntity> findByAccountId(Integer accountId);

    List<CourseAndAttendeesEntity> findByCourseID(Integer courseId);

    List<CourseAndAttendeesEntity> findByCourseIDAndStatus(Integer courseId, Integer status);

}
