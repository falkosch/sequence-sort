module edu.schwabe.sequencesort.outofplace {
    requires transitive edu.schwabe.sequencesort.api;
    requires transitive org.eclipse.jdt.annotation;

    exports edu.schwabe.sequencesort.outofplace;

    provides edu.schwabe.sequencesort.api.Algorithm with edu.schwabe.sequencesort.outofplace.AlgorithmImpl;
}