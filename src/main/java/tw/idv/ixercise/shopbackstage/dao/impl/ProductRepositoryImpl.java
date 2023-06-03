package tw.idv.ixercise.shopbackstage.dao.impl;

import org.hibernate.Session;
import tw.idv.ixercise.shopbackstage.dao.ProductRepository;

import javax.persistence.PersistenceContext;

public class ProductRepositoryImpl {
    @PersistenceContext
    private Session session;
}
