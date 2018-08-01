pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
      stage('install and sonar parallel') {
            steps {
                parallel(install: {
                    sh "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
                }, sonar: {
                    sh "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"
                })
            }
            post {
                always {
                    junit '**/target/*-reports/TEST-*.xml'
                    step([$class: 'CoberturaPublisher', coberturaReportFile: 'target/site/cobertura/coverage.xml'])
                }
            }
        }
        stage('INT') { 
            steps {
                sh 'echo int' 
            }
        }
        stage('QA') { 
            steps {
                sh 'echo qa' 
            }
        }
        stage('QA Regression') { 
            steps {
                sh 'echo qa Regression' 
            }
        }
        stage('QA Security Testing') { 
            steps {
                sh 'echo qa Security Testing' 
            }
        }
        stage('PROD') { 
            steps {
                sh 'echo prod' 
            }
        }
        stage('PROD Regression') { 
            steps {
                sh 'echo prod Regression' 
            }
        }
    }
}
