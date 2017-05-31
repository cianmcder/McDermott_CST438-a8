package com.csumb.cst438.a1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.csumb.cst438.a1.Word;
/**
 *
 * @author Cian
 */
public class wordDB
{
    public static void insert(Word w) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(w);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(Word w) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(w));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    public static Word selectWord(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT w FROM word w " +
                "WHERE w.id = :id";
        TypedQuery<Word> q = em.createQuery(qString, Word.class);
        q.setParameter("id", id);
        try {
            Word w = q.getSingleResult();
            return w;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static List<Word> selectWords() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT w from word w";
        TypedQuery<Word> q = em.createQuery(qString, Word.class);

        List<Word> words;
        try {
            words = q.getResultList();
            if (words == null || words.isEmpty())
                words = null;
        } finally {
            em.close();
        }
        return words;
    }
}
