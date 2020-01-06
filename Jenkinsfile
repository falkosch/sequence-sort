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
        sh 'mvn clean package verify site -ntp'
      }
    }
    stage('report') {
      steps {
        script {
          recordIssues(
            enabledForFailure: true,
            ignoreFailedBuilds: false,
            qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]],
            tools: [
              mavenConsole(),
              java(),
              javaDoc(),
              checkStyle(pattern: '**/target/checkstyle-result.xml'),
              cpd(pattern: '**/target/cpd.xml'),
              pmdParser(pattern: '**/target/pmd.xml')
            ]
          )
          junit '**/target/surefire-reports/TEST-*.xml'
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