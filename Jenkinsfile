pipeline {
  agent none
  options {
    skipStagesAfterUnstable()
    timeout(time: 1, unit: 'HOURS')
  }
  triggers {
    pollSCM('H */15 * * *')
  }
  environment {
      CI = true
      HOME = "${env.WORKSPACE}"
  }
  stages {
    stage('maven') {
      agent {
        docker {
          image 'maven:3.6.3-jdk-13'
          label 'docker && linux'
          args '-v $WORKSPACE/.m2:/root/.m2'
        }
      }
      stages {

        stage('clean compile') {
          steps {
            sh 'mvn clean compile -ntp'
          }
        }

        stage('unit tests') {
          steps {
            sh 'mvn test -ntp'
          }
        }

        stage('package') {
          steps {
            sh 'mvn package -ntp'
          }
        }

        stage('integration tests') {
          steps {
            sh 'mvn verify -ntp'
          }
        }

        stage('reports') {
          steps {
            sh 'mvn site -ntp'
          }
        }

        stage('collect reports') {
          steps {
            recordIssues(
              enabledForFailure: true,
              ignoreFailedBuilds: false,
              qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]],
              tools: [
                mavenConsole(),
                java(),
                javaDoc(),
                checkStyle(pattern: '**/target/checkstyle-result.xml'),
              ]
            )

            junit '**/target/surefire-reports/TEST-*.xml'

            jacoco(
              buildOverBuild: true,
              changeBuildStatus: true,
              deltaBranchCoverage: '10',
              deltaClassCoverage: '10',
              deltaComplexityCoverage: '10',
              deltaInstructionCoverage: '10',
              deltaLineCoverage: '10',
              deltaMethodCoverage: '10',
              execPattern: '**/target/jacoco.exec',
              maximumBranchCoverage: '90',
              maximumClassCoverage: '90',
              maximumComplexityCoverage: '90',
              maximumInstructionCoverage: '90',
              maximumLineCoverage: '90',
              maximumMethodCoverage: '90',
              minimumBranchCoverage: '80',
              minimumClassCoverage: '80',
              minimumComplexityCoverage: '80',
              minimumInstructionCoverage: '80',
              minimumLineCoverage: '80',
              minimumMethodCoverage: '80'
            )
          }
        }

        stage('sonar quality gate') {
          steps {
            withSonarQubeEnv('sonarqube') {
              withEnv(["sonar.branch.name=${env.BRANCH_NAME}"]) {
                sh 'mvn sonar:sonar'
              }
            }
            retry(2) {
              sleep 3
              timeout(time: 1, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        }

      }
    }
  }
}