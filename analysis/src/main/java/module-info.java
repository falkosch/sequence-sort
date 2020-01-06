module edu.schwabe.sequencesort.analysis {
    requires transitive edu.schwabe.sequencesort.algorithm.api;
    requires transitive org.eclipse.jdt.annotation;

    exports edu.schwabe.sequencesort.analysis;

    provides edu.schwabe.sequencesort.algorithm.SortedProperty
        with edu.schwabe.sequencesort.analysis.ReflectsMonotonicOrderSortedProperty;
    provides edu.schwabe.sequencesort.algorithm.Reporter
        with edu.schwabe.sequencesort.analysis.TextReporter;

    uses edu.schwabe.sequencesort.algorithm.SortedProperty;
}