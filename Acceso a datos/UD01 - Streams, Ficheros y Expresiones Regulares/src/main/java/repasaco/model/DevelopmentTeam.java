
package repasaco.model;

import java.util.ArrayList;
import java.util.List;

public class DevelopmentTeam {
    private String teamName;
    private String project;
    private List<String> members;

    public DevelopmentTeam(String teamName, String project) {
        this.teamName = teamName;
        this.project = project;
        this.members = new ArrayList<>();
    }

    public void addMember(String member) {
        members.add(member);
    }

    public void removeMember(String member) {
        members.remove(member);
    }

    public void assignNewProject(String project) {
        this.project = project;
    }

    public List<String> getMembers() {
        return members;
    }

    public String getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "DevelopmentTeam [teamName=" + teamName + ", project=" + project + ", members=" + members + "]";
    }
}
