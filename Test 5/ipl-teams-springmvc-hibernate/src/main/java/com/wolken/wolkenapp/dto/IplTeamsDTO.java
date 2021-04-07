package com.wolken.wolkenapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
@Entity
@Table(name = "ipl_teams")
@NamedQueries({
	@NamedQuery(name = "updateone",query = "update IplTeamsDTO dto set dto.teamName =:b1 where dto.iplTeamID=:id1"),
	@NamedQuery(name = "selectAll", query = "from IplTeamsDTO dto"),
	@NamedQuery(name = "deleteone",query = "delete IplTeamsDTO dto where dto.iplTeamID=:id1")
})
public class IplTeamsDTO {
	@Id
	@Column(name = "iplTeamID")
	private int iplTeamID;
	@Column(name = "teamName")
	private String teamName;
	@Column(name = "captain")
	private String captain;
	@Column(name = "no_of_teams")
	private int no_of_teams;

}
