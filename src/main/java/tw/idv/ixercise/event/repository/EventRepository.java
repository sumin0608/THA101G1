package tw.idv.ixercise.event.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import tw.idv.ixercise.event.entity.*;

import java.util.*;

public interface EventRepository extends JpaRepository<Event, Integer> {

    // 使用自動化命名規則進行條件搜尋
    Event findByEventName(String eventName);

    //eventName 對應到 Event 的 eventName 屬性

    //    @Query(value = FIND_PHOTO, nativeQuery = true)
    @Query(value = "SELECT e.photo FROM  Event e WHERE e.eventId = :eventId")
    public byte[] findPhotoByEventId(@Param("eventId") Integer eventId);
//    public static final String FIND_PHOTO = "SELECT photo FROM Event";


//    public static final String FIND_PROJECTS = "SELECT projectId, projectName FROM projects";
//
//    @Query(value = FIND_PROJECTS, nativeQuery = true)
//    public List<Object[]> findProjects();

//    public List<Student> findByStudentIdLessThanAndMarksGreaterThan(Long studentId, Long marks) {
//
//
//
//        em.getTransaction().begin();
//
//
//
//        Query q = em.createQuery("SELECT S FROM STUDENT S WHERE S.studentID < :studentID AND S.marks > :marks");
//
//        q.setParameter("studentID", studentId);
//
//        q.setParameter("studentID", marks);
//
//        return (List<Student>) q.getResultList();
//
//    }
}
