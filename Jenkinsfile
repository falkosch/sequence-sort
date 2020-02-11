pipeline {
  agent none
  
  options {
    buildDiscarder(logRotator(numToKeepStr: '10'))
    preserveStashes(buildCount: 3)
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
        stage('clean') {
          steps {
            sh 'mvn clean -ntp'
          }
        }

        stage('build & tests') {
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
          
            publishHTML([
              allowMissing: false,
              alwaysLinkToLastBuild: true,
              keepAll: false,
              reportDir: 'target/site',
              reportFiles: 'index.html',
              reportName: 'Maven Site'
            ])
          
            recordIssues(
              enabledForFailure: true,
              ignoreFailedBuilds: false,
              qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]],
              tools: [
                mavenConsole(),
                java(),
                javaDoc(),
                checkStyle(pattern: '**/target/checkstyle-result.xml'),
                spotBugs(useRankAsPriority: true)
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
            
            sleep time: 20, unit: 'SECONDS'
            
            timeout(time: 1, unit: 'MINUTES') {
              waitForQualityGate abortPipeline: true
            }
          }
        } // sonar quality gate
      }
    } // maven
  }
}