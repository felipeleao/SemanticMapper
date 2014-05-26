package br.uniriotec.ppgi.mapping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.mit.jwi.item.POS;

@Entity
@Table(name="synsets")
public class MySynset {
	@Id 
	@Column(name = "wordnetID", nullable=false, unique=true)
	private String wordnetID;
	@Enumerated(EnumType.STRING)
	private POS pos;
	@Column(name = "gloss", columnDefinition="TEXT", nullable=false)
	private String gloss;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_supersense", nullable = false)
	private Supersense supersense;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_semantic_type", nullable = true)
	private SemanticType semanticType;
	@ElementCollection
	@CollectionTable(name="words", joinColumns=@JoinColumn(name="id_synset"))
	@Column(name="words", nullable=false)
	private List<String> words = new ArrayList<String>();
	
	public MySynset(){}
	
	public String getWordnetID() {
		return wordnetID;
	}
	public void setWordnetID(String wordnetID) {
		this.wordnetID = wordnetID;
	}
	public POS getPos() {
		return pos;
	}
	public void setPos(POS pos) {
		this.pos = pos;
	}
	public String getGloss() {
		return gloss;
	}
	public void setGloss(String gloss) {
		this.gloss = gloss;
	}
	public Supersense getSupersense() {
		return supersense;
	}
	public void setSupersense(Supersense supersense) {
		this.supersense = supersense;
	}
	public SemanticType getSemanticType() {
		return semanticType;
	}
	public void setSemanticType(SemanticType semanticType) {
		this.semanticType = semanticType;
	}
	public List<String> getWords() {
		return words;
	}
	public void setWords(List<String> words) {
		this.words = words;
	}
	

	
}
