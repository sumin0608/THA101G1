package tw.idv.ixercise.shopbackstage.dao.impl;



import org.hibernate.Session;
import org.springframework.stereotype.Repository;



import javax.persistence.PersistenceContext;


@Repository
public class ProductRepositoryImpl {

    @PersistenceContext
    private Session session;


}
