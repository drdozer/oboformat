# Introduction #

This document provides guidelines for parsing OBO-Format documents using the reference parser.

The org.oboformat codebase provides two key components:

  * A **parser**, which parses obo-format documents into **OBODocument** objects
  * A **translator**, which translates **OBODocument** objects into [OWLOntology](http://owlapi.sourceforge.net/javadoc/org/semanticweb/owlapi/model/OWLOntology.html) objects


It is **strongly recommended** that software applications using this library performs **both** steps and consume **OWLOntology objects**, rather than using OBODoc objects, which are intended as intermediate structures. The following advantages are gained:

  * That application is then able to work with both obo **and** owl documents
  * The application is future-proofed in the case of the input ontology moving to OWL as it's primary format
  * The application can take of all the features of the OWL API, including integration with reasoners

Whilst it is true that this library can perform a reverse lossy translation from OWL to OBO-Format, use of the obo document objects in inherently limited, as these will never support all OWL constructs.

Note that if you use [OWLTools](http://code.google.com/p/owltools/) you will not need to use this API directly, translation is handled behind the scenes.

## Using the OBO Format parser to generate OBODoc objects ##

See notes above. It is **strongly recommended** you use parse into OWLAPI OWLOntology objects, and use the OWLAPI (or an API that wraps the OWLAPI) to perform ontology operations.

However, if you have a strong need to work at the level of OBO documents, here is a basic guide. The top level object is an OBODoc, which represents the contents of a single OBO-Format file. An OBODoc can be obtained like this:

```
import org.obolibrary.oboformat.model.*;

public class Test {
  public static void main(String[] args) {
    OBOFormatParser p = new OBOFormatParser();
    OBODoc obodoc = p.parse("go.obo");
    ...
  }
}
```

Each OBODoc consists of multiple **frames**, with each frame consisting of **clauses**. The data model maps directly to the [OBO-Format specifcation](http://purl.obolibrary.org/obo/oboformat/spec.html).

In particular, see:

  * [Section 3](http://purl.obolibrary.org/obo/oboformat/spec.html#3), which specifies the basic document structure.
  * [Section 4](http://purl.obolibrary.org/obo/oboformat/spec.html#4), which specifies cardinality constraints for different clause types.

Note that the data model implementation is fairly generic, and does not include methods for performing useful ontology operations. This design is deliberate. The API should only be used for walking over the OBODoc and translating the frames into some other more useful data model.

## Using the OBO Format parser to generate OWLOntology objects ##

The **recommended** way to use this API is to skip the intermediate OBODoc representation and use the OWLAPI once the OBODoc has been translated to OWL.

```
import org.obolibrary.obo2owl.*;
import org.obolibrary.oboformat.model.*;
import org.obolibrary.oboformat.parser.*;
import org.semanticweb.owlapi.io.*;
import org.semanticweb.owlapi.model.*;

public class ExportLabelsAsOWL {

	public static void main(String[] args) 
           throws IOException, OWLOntologyCreationException,
                  OWLOntologyStorageException {
		// create a parser object and get an OBO Document
		OBOFormatParser p = new OBOFormatParser();
		OBODoc obodoc = p.parse(args[0]);

		// create a translator object and feed it the OBODoc
		Obo2Owl bridge = new Obo2Owl();
		OWLOntologyManager manager = bridge.getManager();
		OWLOntology ontology = bridge.convert(obodoc);
                ...

```

[see full example](http://oboformat.googlecode.com/svn/trunk/src/main/java/org/obolibrary/examples/ExportLabelsAsOWL.java)

# Using OWLTools #

For programmers making the transition from the OBO-format world, the OWL API can be overwhelming. The [OWLTools](http://code.google.com/p/owltools/) library provides a simple facade on top of the OWL API that simplifies the following operations:

  * Fetching OBO-metadata, including synonyms, text definitions, subsets/slims, etc
  * Traversing the ontology graph

OWLTools also includes utility packages for graph visualization, comparing based on semantic similarity, etc.

If you intend to use OWLTools then you can **skip these org.oboformat docs entirely**. OWLTools transparently accepts obo or owl files, translating them to OWLOntology objects behind the scenes.

# Direct use from the OWLAPI #

Note that at this time, the OWLAPI contains an obo parser that precedes this one. This parser may be fine for some purposes, but it doesn't support the full spec.

**We hope to integrate this parser and translator into the OWLAPI in the future**, thus allowing you to treat obo format as any other OWL serialization (albeit an idiosyncratic, incomplete one).

For the current time, you need to explicitly translate obo documents. Apologies for the inconvenience.