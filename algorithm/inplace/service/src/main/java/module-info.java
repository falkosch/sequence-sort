module edu.schwabe.sequencesort.algorithm.inplace {
    requires transitive edu.schwabe.sequencesort.algorithm.api;
    requires transitive org.eclipse.jdt.annotation;

    exports edu.schwabe.sequencesort.algorithm.inplace;

    provides edu.schwabe.sequencesort.algorithm.Algorithm
        with edu.schwabe.sequencesort.algorithm.inplace.AlgorithmImpl;
}