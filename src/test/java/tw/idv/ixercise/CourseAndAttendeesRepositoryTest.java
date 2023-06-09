package tw.idv.ixercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.SpringRunner;
import tw.idv.ixercise.course.dao.*;
import tw.idv.ixercise.course.entity.*;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class CourseAndAttendeesRepositoryTest {

    @Autowired
    private CourseAndAttendeesRepository courseAndAttendeesRepository;

    @Test
    public void testAutoMapping() {
        // Perform a sample query or operation on the repository
        // For example, you can fetch all records from the view
        List<CourseAndAttendeesEntity> entities = courseAndAttendeesRepository.findAll();
        List<CourseAndAttendeesEntity> findByAccountId = courseAndAttendeesRepository.findByAccountId(5);
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        List<CourseAndAttendeesEntity> collect = findByAccountId.stream().filter(course -> course.getCourseStartTime().after(currentTimestamp)).collect(Collectors.toList());
//       List<Course> filteredCourseList = courseRepository.findByCourseIdIn(ids).stream()
//                .peek(e -> System.out.println(e))
//                .filter(course -> course.getCourseStartTime().after(currentTimestamp))
////					.peek(course -> {course.setSuccessful(true); course.setMessage("成功查詢參加課程");})
//                .collect(Collectors.toList());

//        findByAccountId.forEach(System.out::println);
        collect.forEach(System.out::println);
//        entities.forEach(System.out::println);
//        System.out.println(entities);
        // Assert or perform further checks on the fetched entities
        // ...
    }
}
