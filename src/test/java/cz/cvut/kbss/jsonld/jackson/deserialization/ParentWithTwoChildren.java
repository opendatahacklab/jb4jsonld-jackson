package cz.cvut.kbss.jsonld.jackson.deserialization;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;

@OWLClass(iri="http://example.org/ParentWithTwoChildren")
public class ParentWithTwoChildren implements Serializable{
	
	public ParentWithTwoChildren() {
		
	}
	@Id
	private String iri;

	public String getIri() {
		return iri;
	}

	public void setIri(String iri) {
		this.iri = iri;
	}
	
    @OWLObjectProperty(iri = "http://example.org/hasChildA")
    Child hasChildA;
    
    @OWLObjectProperty(iri = "http://example.org/hasChildB")
    Child hasChildB;
    


	public Child getHasChildA() {
		return hasChildA;
	}

	public void setHasChildA(Child hasChildA) {
		this.hasChildA = hasChildA;
	}

	public Child getHasChildB() {
		return hasChildB;
	}

	public void setHasChildB(Child hasChildB) {
		this.hasChildB = hasChildB;
	}
}