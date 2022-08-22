package jpabook.start;

import javax.persistence.*;  //**
import java.util.Date;

/**
 테이블과의 매핑관계
 */
//엔티티로선언!
@Entity
//테이블 이름 매핑, 제약조건 설정
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"} )})
public class Member {

    @Id
    @Column(name = "ID")    //칼럼명 매핑
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    //@Column(name = "NAME")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType rolType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

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

    public RoleType getRolType() {
        return rolType;
    }

    public void setRolType(RoleType rolType) {
        this.rolType = rolType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
