package org.obolibrary.oboformat.diff.test;

import static junit.framework.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.obolibrary.obo2owl.test.OboFormatTestBasics;
import org.obolibrary.oboformat.diff.Diff;
import org.obolibrary.oboformat.diff.OBODocDiffer;
import org.obolibrary.oboformat.model.OBODoc;

public class OBODocDifferTest extends OboFormatTestBasics {
	
	@Test
	public void testIdentical() throws IOException {
		OBODoc obodoc1 = parseOBOFile("caro.obo");
		OBODoc obodoc2 = parseOBOFile("caro.obo");
		OBODocDiffer dd = new OBODocDiffer();
		List<Diff> diffs = dd.getDiffs(obodoc1, obodoc2);
		for (Diff diff : diffs) {
			System.out.println("Diff="+diff);
		}
		assertEquals(0, diffs.size());
	}
	
	@Test
	public void testDiff() throws IOException {
		OBODoc obodoc1 = parseOBOFile("caro.obo");
		OBODoc obodoc2 = parseOBOFile("caro_modified.obo");
		OBODocDiffer dd = new OBODocDiffer();
		List<Diff> diffs = dd.getDiffs(obodoc1, obodoc2);
		for (Diff diff : diffs) {
			System.out.println("MDiff="+diff);
		}
		assertEquals(19, diffs.size());
	}
	
}
