package tw.idv.ixercise.report.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import tw.idv.ixercise.report.entity.Comment;

@Repository
public class CommentRepositoryImpl {


//	
//
//	@Override
//	public List<Comment> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Comment> findAllById(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Comment> List<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <S extends Comment> S saveAndFlush(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAllInBatch(Iterable<Comment> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllInBatch() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Comment getOne(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Comment getById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Comment getReferenceById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Comment> List<S> findAll(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Comment> List<S> findAll(Example<S> example, Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<Comment> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Comment> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Comment> findById(Integer id) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Comment entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Comment> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <S extends Comment> Optional<S> findOne(Example<S> example) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	@Override
//	public <S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Comment> long count(Example<S> example) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public <S extends Comment> boolean exists(Example<S> example) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public <S extends Comment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Comment getComment(Integer articleId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Comment> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
