package org.obolibrary.obo2owl;

import org.obolibrary.oboformat.parser.OBOFormatConstants.OboFormatTag;
import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Shahid Manzoor
 *
 */
public class Obo2OWLConstants {

	public static final String DEFAULT_IRI_PREFIX = "http://purl.obolibrary.org/obo/";
	public static final String OIOVOCAB_IRI_PREFIX = "http://www.geneontology.org/formats/oboInOwl#";
	
	public enum Obo2OWLVocabulary{
		
		//TODO: assign label from IAO ontology
		IRI_IAO_0000424(Obo2OWLConstants.DEFAULT_IRI_PREFIX, "IAO_0000424", "expand expression to", OboFormatTag.TAG_EXPAND_EXPRESSION_TO.getTag()),
		IRI_IAO_0000425(Obo2OWLConstants.DEFAULT_IRI_PREFIX, "IAO_0000425", "expand assertion to", OboFormatTag.TAG_EXPAND_ASSERTION_TO.getTag()),
		IRI_IAO_0000115(Obo2OWLConstants.DEFAULT_IRI_PREFIX, "IAO_0000115", "definition", OboFormatTag.TAG_DEF.getTag()),
		//IRI_IAO_0000118(Obo2OWLConstants.DEFAULT_IRI_PREFIX, "IAO_0000118", "alternative term", OboFormatTag.TAG_SYNONYM.getTag()),
		IRI_IAO_0000427(Obo2OWLConstants.DEFAULT_IRI_PREFIX, "IAO_0000427", "antisymmetric property", OboFormatTag.TAG_IS_ANTI_SYMMETRIC.getTag()),
		IRI_IAO_0100001(Obo2OWLConstants.DEFAULT_IRI_PREFIX, "IAO_0100001", "term replaced by", OboFormatTag.TAG_REPLACED_BY.getTag()),
		IRI_OIO_hasOBOFormatVersion(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasOBOFormatVersion", "has_obo_format_version", OboFormatTag.TAG_FORMAT_VERSION.getTag()),
		IRI_OIO_treatXrefsAsIsA(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "treat-xrefs-as-is_a", "treat-xrefs-as-is_a", OboFormatTag.TAG_TREAT_XREFS_AS_IS_A.getTag()),
		IRI_OIO_treatXrefsAsHasSubClass(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "treat-xrefs-as-has-subclass", "treat-xrefs-as-has-subclass", OboFormatTag.TAG_TREAT_XREFS_AS_HAS_SUBCLASS.getTag()),
		IRI_OIO_treatXrefsAsRelationship(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "treat-xrefs-as-relationship", "treat-xrefs-as-relationship", OboFormatTag.TAG_TREAT_XREFS_AS_RELATIONSHIP.getTag()),
		IRI_OIO_treatXrefsAsGenusDifferentia(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "treat-xrefs-as-genus-differentia", "treat-xrefs-as-genus-differentia", OboFormatTag.TAG_TREAT_XREFS_AS_GENUS_DIFFERENTIA.getTag()),
		IRI_OIO_treatXrefsAsReverseGenusDifferentia(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "treat-xrefs-as-reverse-genus-differentia", "treat-xrefs-as-reverse-genus-differentia", OboFormatTag.TAG_TREAT_XREFS_AS_REVERSE_GENUS_DIFFERENTIA.getTag()),
		IRI_OIO_treatXrefsAsEquivalent(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "treat-xrefs-as-equivalent", "treat-xrefs-as-equivalent", OboFormatTag.TAG_TREAT_XREFS_AS_EQUIVALENT.getTag()),
		IRI_OIO_hasOboNamespace(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasOBONamespace", "has_obo_namespace", OboFormatTag.TAG_NAMESPACE.getTag()),
		IRI_OIO_hasDbXref(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasDbXref", "database_cross_reference", OboFormatTag.TAG_XREF.getTag()),
		hasAlternativeId(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasAlternativeId", "has_alternative_id", OboFormatTag.TAG_ALT_ID.getTag()),
		IRI_OIO_inSubset(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "inSubset", "in_subset", OboFormatTag.TAG_SUBSET.getTag()),
		IRI_OIO_hasScope(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasScope", "has_scope", OboFormatTag.TAG_SCOPE.getTag()),
		IRI_OIO_hasBroadSynonym(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasBroadSynonym", "has_broad_synonym", OboFormatTag.TAG_BROAD.getTag()),
		IRI_OIO_hasNarrowSynonym(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasNarrowSynonym", "has_narrow_synonym", OboFormatTag.TAG_NARROW.getTag()),
		IRI_OIO_hasExactSynonym(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasExactSynonym", "has_exact_synonym", OboFormatTag.TAG_EXACT.getTag()),
		IRI_OIO_hasRelatedSynonym(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasRelatedSynonym", "has_related_synonym", OboFormatTag.TAG_RELATED.getTag()),
		hasSynonymType(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "hasSynonymType", "has_synonym_type", OboFormatTag.TAG_HAS_SYNONYM_TYPE.getTag()),
		IRI_OIO_Subset(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "SubsetProperty", "subset_property", OboFormatTag.TAG_SUBSETDEF.getTag()),
		IRI_OIO_SynonymType(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX, "SynonymTypeProperty", "synonym_type_property", OboFormatTag.TAG_SYNONYMTYPEDEF.getTag());
		
		IRI iri;
		String namespace;
		String shortName;
		String label;
		String mappedTag;
		
		Obo2OWLVocabulary(String namespce, String shortName, String label, String mappedTag){
			iri = IRI.create(namespce + shortName);
			this.shortName = shortName;
			this.namespace = namespce;
			this.label = label;
			this.mappedTag = mappedTag;
		}
		
		public String getShortName(){
			return shortName;
		}
		
		public String getNamespace(){
			return namespace;
		}
		
		public IRI getIRI(){
			return iri;
		}
		
		public String getLabel(){
			return this.label;
		}
		
		public String getMappedTag(){
			return this.mappedTag;
		}
	}
	
}
