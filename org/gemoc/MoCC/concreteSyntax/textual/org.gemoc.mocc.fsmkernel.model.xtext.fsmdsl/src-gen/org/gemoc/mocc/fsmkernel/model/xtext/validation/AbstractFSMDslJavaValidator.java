/*
* generated by Xtext
*/
package org.gemoc.mocc.fsmkernel.model.xtext.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractFSMDslJavaValidator extends fr.inria.aoste.timesquare.ccslkernel.library.xtext.validation.CCSLLibraryJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.gemoc.mocc.fsmmodel/1.0"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.gemoc.mocc.fsmmodel/editionextension/1.0"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://fr.inria.aoste.timemodel.classicalexpression"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://fr.inria.aoste.timemodel.ccslmodel.clockexpressionandrelation"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://fr.inria.aoste.timemodel"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://fr.inria.aoste.timemodel.basicTypes"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://fr.inria.aoste.timemodel.ccslmodel.clockexpressionandrelation.kernelexpression"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://fr.inria.aoste.timemodel.ccslmodel.clockexpressionandrelation.kernelrelation"));
		return result;
	}

}
