module edu.schwabe.sequencesort.algorithm.inplace {
  requires transitive edu.schwabe.sequencesort.algorithm.api;

  exports edu.schwabe.sequencesort.algorithm.inplace;

  provides edu.schwabe.sequencesort.algorithm.Algorithm
      with edu.schwabe.sequencesort.algorithm.inplace.AlgorithmImpl;
}