pipeline {
    agent any
    
    stages {
        stage('Package') {
            steps {
                withMaven(maven: 'Maven') {
                    sh 'mvn clean package'
                }
            }
        }
      stage('test') {
            steps {
                parallel(test: {
                     withMaven(maven: 'Maven') {
                        sh "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
                     }
                }, sonar: {
                    withMaven(maven: 'Maven') {
                        sh "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"    
                    }
                    
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
                bat 'echo int' 
            }
        }
        stage('QA') { 
            input {
               message "Are you sure and wanna proceed with QA Deployment?"
           }
            steps {
                bat 'echo qa deploy' 
            }
        }
        stage('QA Regression') { 
            steps {
                bat 'echo qa Regression' 
            }
        }
        stage('QA Security Testing') { 
            steps {
                bat 'echo qa Security Testing' 
            }
        }
        stage('PROD') { 
            steps {
                bat 'echo prod' 
            }
        }
        stage('PROD Regression') { 
            steps {
                bat 'echo prod Regression' 
            }
        }
    }
}

