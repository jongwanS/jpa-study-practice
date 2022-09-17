package jpabook.ch6;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private String id;

    private String name;
    @OneToMany(mappedBy = "team")
    @JoinColumn(name = "TEAM_ID")//외래키 매핑
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        this.members.add(member);
        if(member.getTeam() != this){
            member.setTeam(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
