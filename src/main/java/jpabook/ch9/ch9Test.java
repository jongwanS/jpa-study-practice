package jpabook.ch9;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ch9Test {
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static <JPAQuery> void logic(EntityManager em) throws CloneNotSupportedException {

//        Member member = new Member();
//
//        //임베디드값
//        member.setHomeAddress(new Address("통영","몽돌해수욕장","660123"));
//
//        //기본값
//        member.getFavoriteFoods().add("짬뽕");
//        member.getFavoriteFoods().add("짜장");
//        member.getFavoriteFoods().add("탕수육");
//
//        //임베디드값 컬렉션
//        member.getAddressHistory().add(new Address("서울","강남","123123"));
//        member.getAddressHistory().add(new Address("서울","강북","000000"));
//        em.persist(member);

//        System.out.println("===============================================================");
        Member member = em.find(Member.class, 1L);
        member.setHomeAddress(new Address("새로운 도시","신도시","1234"));

        Set<String> favoriteFoods = member.getFavoriteFoods();
        favoriteFoods.remove("탕수육");
        favoriteFoods.add("치킨");

        List<Address> addressHistory = member.getAddressHistory();
        addressHistory.remove(new Address("서울","강북","000000"));
        addressHistory.add(new Address("새롭","새롭2","123456"));

    }
}
