package org.obolibrary.oboformat.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class Clause {
	protected String tag;

	protected Collection<Object> values;
	protected Collection<Xref> xrefs;
	protected Collection<QualifierValue> qualifierValues =
		 new ArrayList<QualifierValue>();



	public Clause(String tag) {
		super();
		this.tag = tag;
	}
	public Clause(String tag, String value) {
		super();
		this.tag = tag;
		this.setValue(value);
	}

	public Clause() {
		super();
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Collection<Object> getValues() {
		return values;
	}

	public void setValues(Collection<Object> values) {
		this.values = values;
	}

	public void setValue(Object v) {
		this.values = new ArrayList<Object>(1);
		values.add(v);
	}
	
	public void addValue(Object v) {
		if (values == null)
			values = new ArrayList<Object>(1);
		values.add(v);
		
	}


	public Object getValue() {
		// TODO Auto-generated method stub
		return values.toArray()[0];
	}
	
	public Object getValue2() {
		// TODO Auto-generated method stub
		return values.toArray()[1];
	}
	
	public Collection<Xref> getXrefs() {
		return xrefs;
	}

	public void setXrefs(Collection<Xref> xrefs) {
		this.xrefs = xrefs;
	}
	
	public void addXref(Xref xref) {
		if (xrefs == null)
			xrefs = new Vector<Xref>();
		xrefs.add(xref);
	}


	public Collection<QualifierValue> getQualifierValues() {
		return qualifierValues;
	}

	public void setQualifierValues(Collection<QualifierValue> qualifierValues) {
		this.qualifierValues = qualifierValues;
	}

	public void addQualifierValue(QualifierValue qv) {
		if (qualifierValues == null)
			qualifierValues = new Vector<QualifierValue>();
		qualifierValues.add(qv);
	}

	
	public String toString() {
		if (values == null)
			return tag+"=null";
		StringBuffer sb = new StringBuffer();
		for (Object ob : values) {
			sb.append(ob);
		}
		if (qualifierValues != null) {
			for (QualifierValue qv : qualifierValues) {
				sb.append(qv+" ");
			}
		}
		if (xrefs != null) {
			for (Xref x : xrefs) {
				sb.append(x+" ");
			}
		}
		return tag+"("+sb.toString()+")";
	}

	public boolean equals(Object e) {
		
		if(e == null || !(e instanceof Clause))
			return false;
		
		Clause other = (Clause) e;
		
		
		if (!getTag().equals(other.getTag()))
			return false;
		
		if (!getValues().equals(other.getValues()))
			return false;
	
		
		if (xrefs != null) {
			if (other.getXrefs() == null)
				return false;
			if (!xrefs.equals(other.getXrefs()))
				return false;
		}
		else {
			if (other.getXrefs() != null && other.getXrefs().size() > 0) {
				return false;
			}
		}
		
		if (qualifierValues != null) {
			if (other.getQualifierValues() == null)
				return false;
			if (!qualifierValues.equals(other.getQualifierValues()))
				return false;
		}
		else {
			if (other.getQualifierValues() != null && other.getQualifierValues().size() > 0) {
				return false;
			}
		}
		

		return true;
	}


}
