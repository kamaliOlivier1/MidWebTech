package DAO;

import MODEL.Semester;
import org.hibernate.Session;
import org.hibernate.Transaction;
import DAO.HibernateUtil;

import java.util.List;
import java.util.UUID;
import org.hibernate.Query;

public class SemesterDAO {

    public void saveOrUpdateSemester(Semester semester) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(semester);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Semester getSemesterById(UUID semesterId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (Semester) session.get(Semester.class, semesterId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Semester> getAllSemesters() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Semester");
            return q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteSemester(UUID semesterId) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Semester semester = (Semester) session.get(Semester.class, semesterId);
            if (semester != null) {
                session.delete(semester);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
