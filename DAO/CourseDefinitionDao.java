package DAO;

import MODEL.CourseDefinition;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDefinitionDao {

    private EntityManager entityManager;

    public CourseDefinitionDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveCourseDefinition(CourseDefinition courseDefinition) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(courseDefinition);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public CourseDefinition getCourseDefinitionById(int id) {
        return entityManager.find(CourseDefinition.class, id);
    }

    public void updateCourseDefinition(CourseDefinition courseDefinition) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(courseDefinition);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCourseDefinition(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            CourseDefinition courseDefinition = entityManager.find(CourseDefinition.class, id);
            if (courseDefinition != null) {
                entityManager.remove(courseDefinition);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<CourseDefinition> findAllCourseDefinitions() {
        TypedQuery<CourseDefinition> query = entityManager.createQuery("SELECT cd FROM CourseDefinition cd", CourseDefinition.class);
        return query.getResultList();
    }
}
