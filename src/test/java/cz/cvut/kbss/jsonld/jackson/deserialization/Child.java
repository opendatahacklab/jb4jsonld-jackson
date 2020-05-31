package cz.cvut.kbss.jsonld.jackson.deserialization;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;

@OWLClass(iri="http://example.org/Child")
public class Child implements Serializable{
	
	public Child() {
		
	}
	@Id
	private String iri;

	public String getIri() {
		return iri;
	}

	public void setIri(String iri) {
		this.iri = iri;
	}
    @OWLObjectProperty(iri = "http://example.org/hasFriend")
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://example.org/Child", max = 1)
    })
    Child hasFriend;

	public Child getHasFriend() {
		return hasFriend;
	}

	public void setHasFriend(Child hasFriend) {
		this.hasFriend = hasFriend;
	}
}