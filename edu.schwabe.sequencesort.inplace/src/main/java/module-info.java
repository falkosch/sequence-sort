module edu.schwabe.sequencesort.inplace {
    requires transitive edu.schwabe.sequencesort.api;
    requires transitive org.eclipse.jdt.annotation;

    exports edu.schwabe.sequencesort.inplace;

    provides edu.schwabe.sequencesort.api.Algorithm with edu.schwabe.sequencesort.inplace.AlgorithmImpl;
}