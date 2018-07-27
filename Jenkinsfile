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
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    sh 'mvn cobertura:cobertura'
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
        stage('PROD') { 
            steps {
                sh 'echo prod' 
            }
        }
    }
}
