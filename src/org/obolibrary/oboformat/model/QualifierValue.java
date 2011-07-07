package org.obolibrary.oboformat.model;

public class QualifierValue {
	protected String qualifier;
	protected Object value;
	
	public QualifierValue(String q, String v) {
		qualifier = q;
		value = v;
	}
	public String getQualifier() {
		return qualifier;
	}
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public boolean equals(Object e) {
		if(e == null || !(e instanceof QualifierValue))
			return false;
		
		QualifierValue other = (QualifierValue) e;
		return qualifier.equals(other.getQualifier()) &&
		value.equals(other.getValue());
	
	}
	
	public String toString() {
		return "{"+qualifier+"="+value+"}";
	}

}
