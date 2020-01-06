package edu.schwabe.sequencesort.algorithm.tests;

import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import java.util.stream.Stream;
import org.eclipse.jdt.annotation.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WhenCreatingAnOperationReport {

  @ParameterizedTest
  @MethodSource("creationParameters")
  void itShouldNotThrow(
    @NonNull final OperationResult<int @NonNull []> operationResult, final int trial,
    final long duration
  ) {
    Assertions.assertDoesNotThrow(() -> {
      return new OperationReport(operationResult, trial, duration);
    });
  }

  static Stream<Arguments> creationParameters() {
    return Stream
      .of(Arguments.of(new OperationResult<>(), Integer.valueOf(0), Integer.valueOf(0)), Arguments.of(new OperationResult<>(0, 0, new int[0]), Integer.valueOf(0), Integer.valueOf(1)), Arguments.of(new OperationResult<>(0, 0, new int[] { 0, 1 }), Integer.valueOf(1), Integer.valueOf(0)));
  }
}
