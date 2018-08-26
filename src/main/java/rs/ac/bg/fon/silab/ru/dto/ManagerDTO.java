package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagerDTO {
    private Long managerId;
    private String firstName;
    private String lastName;
    private RankDTO rank;
    private TitleDTO title;

    public ManagerDTO() {
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RankDTO getRank() {
        return rank;
    }

    public void setRank(RankDTO rank) {
        this.rank = rank;
    }

    public TitleDTO getTitle() {
        return title;
    }

    public void setTitle(TitleDTO title) {
        this.title = title;
    }
    
    
}
