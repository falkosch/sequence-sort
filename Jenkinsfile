pipeline {
  agent {
    docker {
      image 'maven:3.6.3-jdk-13'
      label 'docker && linux'
    }
  }
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
    stage('package') {
      steps {
        sh 'mvn clean package verify site -BU'
      }
    }
    stage('report') {
      steps {
        script {
          recordIssues(
            enabledForFailure: true,
            ignoreFailedBuilds: false,
            qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]],
            tools: [checkStyle(pattern: 'reports/*.checkstyle.xml')]
          )
          junit '**/reports/test-reports/TESTS*.xml'
          cobertura([
            coberturaReportFile: '**/reports/cobertura-coverage.xml',
            conditionalCoverageTargets: '80, 0, 0',
            enableNewApi: true,
            lineCoverageTargets: '80, 0, 0',
            maxNumberOfBuilds: 0,
            methodCoverageTargets: '80, 0, 0',
            onlyStable: false,
            sourceEncoding: 'ASCII'
          ])
        }
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
          timeout(time: 1, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
          }
        }
      }
    }
  }
  post {
    failure {
      script {
        committerEmail = sh(returnStdout: true, script: 'git --no-pager show -s --format=\'%ae\'').trim()
      }
      mail(
        to: "${committerEmail}",
        subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
        body: "Something is wrong with ${env.BUILD_URL}"
      )
    }
  }
}