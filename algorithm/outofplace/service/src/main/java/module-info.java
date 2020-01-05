module edu.schwabe.sequencesort.algorithm.outofplace {
	requires transitive edu.schwabe.sequencesort.algorithm.api;
	requires transitive org.eclipse.jdt.annotation;

	exports edu.schwabe.sequencesort.algorithm.outofplace;

	provides edu.schwabe.sequencesort.algorithm.Algorithm
	    with edu.schwabe.sequencesort.algorithm.outofplace.AlgorithmImpl;
}