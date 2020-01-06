module edu.schwabe.sequencesort.algorithm.outofplace {
  requires transitive edu.schwabe.sequencesort.algorithm.api;

  exports edu.schwabe.sequencesort.algorithm.outofplace;

  provides edu.schwabe.sequencesort.algorithm.Algorithm
    with edu.schwabe.sequencesort.algorithm.outofplace.AlgorithmImpl;
}