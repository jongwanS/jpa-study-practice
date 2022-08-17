package jpabook.start;

import javax.persistence.*;  //**

/**
 테이블과의 매핑관계
 */
@Entity//이 클래스를 테이블과 매핑시킬게하는 정보
@Table(name="MEMBER")   //테이블 이름 매핑
public class Member {

    @Id
    @Column(name = "ID")    //칼럼명 매핑
    private String id;

    @Column(name = "NAME")
    private String username;

    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
