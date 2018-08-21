pipeline {
    agent {
        docker {
            image 'maven' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Package') {
            steps {
                shell 'mvn clean package'
            }
        }
      stage('test') {
            steps {
                parallel(test: {
                    shell "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
                }, sonar: {
                    shell "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"
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
            input {
               message "Are you sure and wanna proceed with QA Deployment?"
           }
            steps {
                sh 'echo qa deploy' 
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

