package DAO;

import MODEL.StudentRegistration;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRegistrationDao {

    private EntityManager entityManager;

    public StudentRegistrationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveStudentRegistration(StudentRegistration studentRegistration) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(studentRegistration);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public StudentRegistration getStudentRegistrationById(int id) {
        return entityManager.find(StudentRegistration.class, id);
    }

    public void updateStudentRegistration(StudentRegistration studentRegistration) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(studentRegistration);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudentRegistration(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            StudentRegistration studentRegistration = entityManager.find(StudentRegistration.class, id);
            if (studentRegistration != null) {
                entityManager.remove(studentRegistration);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<StudentRegistration> findAllStudentRegistrations() {
        TypedQuery<StudentRegistration> query = entityManager.createQuery("SELECT sr FROM StudentRegistration sr", StudentRegistration.class);
        return query.getResultList();
    }
}
