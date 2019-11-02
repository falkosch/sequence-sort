module edu.schwabe.sequencesort.testrunner {
    requires edu.schwabe.sequencesort.api;
    requires edu.schwabe.sequencesort.inplace;
    requires edu.schwabe.sequencesort.outofplace;
    requires edu.schwabe.sequencesort.analysis;
    requires org.eclipse.jdt.annotation;

    uses edu.schwabe.sequencesort.api.Algorithm;
    uses edu.schwabe.sequencesort.api.SortedProperty;
    uses edu.schwabe.sequencesort.api.Reporter;
}