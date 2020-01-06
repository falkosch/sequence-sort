module edu.schwabe.sequencesort.demonstrator {
  requires edu.schwabe.sequencesort.algorithm.api;
  requires edu.schwabe.sequencesort.algorithm.inplace;
  requires edu.schwabe.sequencesort.algorithm.outofplace;
  requires edu.schwabe.sequencesort.analysis;
  requires org.eclipse.jdt.annotation;

  uses edu.schwabe.sequencesort.algorithm.Algorithm;
  uses edu.schwabe.sequencesort.algorithm.SortedProperty;
  uses edu.schwabe.sequencesort.algorithm.Reporter;
}