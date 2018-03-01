package jielin.snapshot.service.impl;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.dao.NoteDao;
import jielin.snapshot.domain.NoteEntity;
import jielin.snapshot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteDao noteDao;

    public Result add(String msg,int expired){

        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK,expired);
        Date expireDate =cal.getTime();
        NoteEntity note=new NoteEntity();
        note.setCreatedDate(date);
        note.setDescription(msg);
        note.setExpiredDate(expireDate);
        noteDao.save(note);
        return ResultUtil.success("added");

    }

    public Result getNotes(int days){
        return ResultUtil.success(noteDao.findAll(
                new Specification<NoteEntity>() {
                    @Override
                    public Predicate toPredicate(Root<NoteEntity> root, CriteriaQuery<?> criteriaQuery,
                                                 CriteriaBuilder criteriaBuilder) {
                        Calendar cal=Calendar.getInstance();
                        cal.setTime(new Date());
                        cal.add(Calendar.DAY_OF_WEEK,days);
                        Predicate p=criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"),cal.getTime());
                        criteriaQuery.where(p);
                        return null;
                    }
                },new Sort(Sort.Direction.DESC, "id")
        ));
    }

    public Result getNotes(){
        return ResultUtil.success(noteDao.findAll(
                new Specification<NoteEntity>() {
                    @Override
                    public Predicate toPredicate(Root<NoteEntity> root, CriteriaQuery<?> criteriaQuery,
                                                 CriteriaBuilder criteriaBuilder) {
                        Calendar cal=Calendar.getInstance();
                        cal.setTime(new Date());
                        Predicate p=criteriaBuilder.greaterThanOrEqualTo(root.get("expiredDate"),cal.getTime());
                        criteriaQuery.where(p);
                        return null;
                    }
                },new Sort(Sort.Direction.DESC, "id")
        ));
    }
}
