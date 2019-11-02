module edu.schwabe.sequencesort.analysis {
    requires transitive edu.schwabe.sequencesort.api;
    requires transitive org.eclipse.jdt.annotation;

    exports edu.schwabe.sequencesort.analysis;

    provides edu.schwabe.sequencesort.api.SortedProperty
	    with edu.schwabe.sequencesort.analysis.ReflectsMonotonicOrderSortedProperty;
    provides edu.schwabe.sequencesort.api.Reporter with edu.schwabe.sequencesort.analysis.TextReporter;

    uses edu.schwabe.sequencesort.api.SortedProperty;
}